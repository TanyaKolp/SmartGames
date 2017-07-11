<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output indent="yes"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4-landscape" page-height="5.5in" page-width="26in">
                    <fo:region-body margin="0.5in" margin-top="0.5in" margin-bottom="1.5in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4-landscape" font-family="ARIALUNI">
                <fo:flow flow-name="xsl-region-body" >
                    <xsl:apply-templates/>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="ReportData">
        <fo:table>
            <fo:table-header>
                <fo:table-row>
                    <xsl:apply-templates select="ColumnHeaders/ColumnHeader"/>
                </fo:table-row>
            </fo:table-header>
            <fo:table-body>
                <xsl:apply-templates select="Rows/Row"/>
            </fo:table-body>
        </fo:table>
    </xsl:template>

    <xsl:template match="ColumnHeader">
        <fo:table-cell width="{Width}cm" border="solid black 1px" padding="2px" font-weight="bold" text-align="center">
            <fo:block><xsl:value-of select="Name"/></fo:block>
        </fo:table-cell>
    </xsl:template>

    <xsl:template match="Row">
        <fo:table-row>
            <xsl:apply-templates/>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="Column">
        <fo:table-cell border="solid black 1px" padding="2px">
            <fo:block><xsl:value-of select="."/></fo:block>
        </fo:table-cell>
    </xsl:template>

</xsl:stylesheet>