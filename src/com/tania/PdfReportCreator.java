package com.tania;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.fop.apps.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by tkolpakova on 06.07.17.
 */
public class PdfReportCreator implements ReportCreator {
    public String create(List<Map<String, String>> data) {
        String pdfFileName = "testPDF";
        try {
            convertToPDF(data, pdfFileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FOPException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return pdfFileName;
    }

    private String createXmlForPdf(List<Map<String, String>> data) {
        String filePath = "file.xml";
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("ReportData");
            doc.appendChild(rootElement);
            //headers
            fillHeader(doc, rootElement);
            // rows
            fillDataRows(data, doc, rootElement);
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("file.xml"));
            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
            System.out.println("File 'file.xml' saved!");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        return filePath;
    }

    private void fillDataRows(List<Map<String, String>> data, Document doc, Element rootElement) {
        Element rows = doc.createElement("Rows");
        rootElement.appendChild(rows);
        //row
        int i = 0; //порядковый номер
        Element row = null;
        for (Map<String, String> map : data) {
            i++;
            row = doc.createElement("Row");
            rows.appendChild(row);
            //fill row
            //номер строки
            Element number = doc.createElement("Column");
            number.appendChild(doc.createTextNode(String.valueOf(i)));
            row.appendChild(number);
            //
            Element column = null;
            for (String columnName : VALUES_NAMES) {
                column = doc.createElement("Column");
                column.appendChild(doc.createTextNode(map.get(columnName)));
                row.appendChild(column);
            }
        }
    }

    private void fillHeader(Document doc, Element rootElement) {
        Element columnHeaders = doc.createElement("ColumnHeaders");
        rootElement.appendChild(columnHeaders);
        //first column "#"
        Element columnHeader = null;
        Element name = null;
        Element width = null;
        //rest columns
        for (String columnName : COLUMN_NAMES) {
            columnHeader = doc.createElement("ColumnHeader");
            columnHeaders.appendChild(columnHeader);
            name = doc.createElement("Name");
            columnHeader.appendChild(name);
            width = doc.createElement("Width");
            columnHeader.appendChild(width);
            if (columnName.equalsIgnoreCase("№")) {
                name.appendChild(doc.createTextNode("№"));
                width.appendChild(doc.createTextNode("2"));
            } else {
                name.appendChild(doc.createTextNode(columnName));
                width.appendChild(doc.createTextNode("5"));
            }
        }
    }

    public void convertToPDF(List<Map<String, String>> data, String pdfFileName) throws IOException, SAXException, TransformerException, ConfigurationException {
        // the XSL FO file
        File xsltFile = new File("template.xsl");
        // the XML file which provides the input
        String dataXmlPath = createXmlForPdf(data);
        StreamSource xmlSource = new StreamSource(new File(dataXmlPath));
        // create an instance of fop factory
        DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
        Configuration cfg = cfgBuilder.buildFromFile(new File("mycfg.xml"));
        FopFactoryBuilder fopFactoryBuilder = new FopFactoryBuilder(new File(".").toURI())
                .setConfiguration(cfg);
        FopFactory fopFactory = fopFactoryBuilder.build();
//        FopFactory fopFactory = FopFactory.newInstance(new File("fop.xconf").toURI());


        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out;
        out = new java.io.FileOutputStream(pdfFileName);

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }
}
