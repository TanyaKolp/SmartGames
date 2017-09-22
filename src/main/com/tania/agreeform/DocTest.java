package com.tania.agreeform;
import com.tania.FindFillBox;
import com.tania.agreeform.AgreementFormCreater;
import com.tania.agreeform.AgreementFormCreator;
import com.tania.agreeform.AgreementFormCreatorImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanya on 21.07.17.
 */
public class DocTest {
    public static void main(String[] args) throws Exception {
        AgreementFormCreater app = new AgreementFormCreater();
        AgreementFormCreator creator = new AgreementFormCreatorImpl();
        Map<String, String> params =new HashMap<>();
        params.put("no", "100");
        params.put("name", "Name");
        params.put("director", "Директор");
        params.put("directorShort", "Директор HN");
        params.put("directorStatus", "Генеральный деректор");
        params.put("basis", "Устав");
        params.put("period", "ГОД");
        params.put("sumNum", "1 000 000");
        params.put("sumStr", "число");
        params.put("rewardNum", "2 000");
        params.put("rewardStr", "число");
        params.put("date", "2015-05-01");
        params.put("fulldate", "2015-01-01");

        //app.createForm(params);
        creator.createForm(params);
        FindFillBox box = new FindFillBox();
        box.createForm(params);
    }
}
