package com.kgc.zhang.tools;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    private String pattern=null;


    public StringToDateConverter(String pattern) {
        super();
        this.pattern = pattern;
    }


    @Override
    public Date convert(String arg0) {
        Date date = null;
        try {
            date =  new SimpleDateFormat(pattern).parse(arg0);
            System.out.println("StringToDateConverter convert date ================================= > " + date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

}
