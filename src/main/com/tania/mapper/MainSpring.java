package com.tania.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by tanya on 16.02.18.
 */
public class MainSpring {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        ObjMain objMain = new ObjMain();
        objMain.setName("qweweqwe");
        objMain.setNumber(2);
        objMain.setId(1L);

        String s = objectMapper.writerWithView(UserView.class).writeValueAsString(new WarpObj<ObjMain>(objMain,100));
        System.out.println(s);
        s = null;
        s="sds_"+s;
        System.out.println(s);
    }

}
