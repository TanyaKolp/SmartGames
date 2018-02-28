package com.tania.model_mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

/**
 * Created by tanya on 07.02.18.
 */
public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(false)
                .setSkipNullEnabled(false)
                .setFieldAccessLevel(PRIVATE);

        Dto dto = new Dto(1, 2, "in db");
        Dto dto_ch = new Dto(1, null, null);
        System.out.println("dto = "+dto);
        System.out.println("dto_ch = "+dto_ch);
        System.out.println();
        modelMapper.map(dto_ch, dto);
        System.out.println("dto = "+dto);
        System.out.println("dto_ch = "+dto_ch);


    }
}
