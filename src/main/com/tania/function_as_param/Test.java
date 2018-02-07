package com.tania.function_as_param;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanya on 09.11.17.
 */
public class Test {
    public String mainMethod(Runnable function){
        List<String> testList = getTestList();
        testList.forEach(s -> {
            if(s.startsWith("q")){
                function.run();
            }
        });
        return null;
    }
    private List<String> getTestList(){
        return Arrays.asList("qwew","qreqqw","cat","1232");
    }

}
