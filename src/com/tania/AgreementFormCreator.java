package com.tania;

import java.io.IOException;
import java.util.Map;

/**
 * Created by tanya on 24.07.17.
 */
public interface AgreementFormCreator {
    public String createForm(Map<String, String> params) throws IOException;
}
