package com.system.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：yangzengrui
 * @date ：Created in 10/4/2019 10:28 PM
 * @description：参数绑定 字符串日期转换器
 */

public class CustomDateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        //实现将日期字符串转成日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try{
            //转成直接返回
            return simpleDateFormat.parse(s);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
