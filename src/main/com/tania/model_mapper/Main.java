package com.tania.model_mapper;

import org.modelmapper.ModelMapper;

/**
 * Created by tanya on 07.02.18.
 */
public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);

    }
}
