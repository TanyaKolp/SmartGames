package com.tania.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tanya on 12.12.17.
 */
public class Main {
    public static void main(String[] args) {
        ObjDto dto = new ObjDto();
        dto.setObj_sub(122L);
        dto.setName("testQwerty");

        ObjMain objMain = new ObjMain();
        objMain.setName("qweweqwe");
        objMain.setNumber(2);
        objMain.setId(1L);
        objMain.setObj_sub(getSub());

        ModelMapper modelMapper = new ModelMapper();

        System.out.println("********** HASH ************");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map hashMap = objectMapper.readValue(getJsno(), HashMap.class);
            System.out.println(hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Base base = new Base();
        base.setDesc("test");
        base.setId(1);
        Dto dto1 = objectMapper.convertValue(base, Dto.class);
        dto1.setItemId(base.getId());
        System.out.println(dto1);


    }

    private static String getJsno() {
        return "{\"order\":[\"order\",\"item\"]}";
    }

    private static Obj_sub getSub() {
        Obj_sub obj_sub = new Obj_sub();
        obj_sub.setId(22L);
        obj_sub.setName("rewrewrw");
        return obj_sub;
    }

    private static Converter<ObjMain, ObjDto> getConverter() {
        return context -> {

            ObjMain source = context.getSource();
            ObjDto destination = context.getDestination();
            destination.setIds(toIdList(source.getObj_subs()));
            return destination;
        };
    }

    private static List<Long> toIdList(List<Obj_sub> obj_subs) {
        if (obj_subs == null && obj_subs.isEmpty()) {
            return Collections.emptyList();
        }
        return obj_subs.stream().map(obj_sub -> obj_sub.getId()).collect(Collectors.toList());
    }

    private static ObjMain createMain() {
        ObjMain objMain = new ObjMain();
        objMain.setName("test");
        objMain.setObj_subs(createSubList());
        objMain.setList(createSubList());
        return objMain;
    }

    private static ObjDto createDto() {
        ObjDto dto = new ObjDto();
        dto.setName("main");

        return dto;
    }

    private static List<Obj_sub> createSubList() {
        List<Obj_sub> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new Obj_sub("sub", (long) i));
        }
        return list;
    }
}
