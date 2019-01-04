package com.concept.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * format 형식을 동적으로 넣어서 string형을 date형으로 변환해주는 메서드
 * static으로 만들어서 여러군데서 사용하기 좋음
 * */
public class StringToDate {

    private Date stringToDateConformToFormat(String checkString, String formatForm){
        Date resultDate = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatForm);
            dateFormat.setLenient(false);

            resultDate = dateFormat.parse(checkString);

        }catch (ParseException e) {
            e.printStackTrace();
            System.out.println(">>>>유효하지 않은 날짜입니다.");
        }

        return resultDate;
    }

    public static void main(String[] args){
        StringToDate stringToDate = new StringToDate();
        String inputString = "2018-11-09";
        String format = "yyyy-MM-dd";

        System.out.println("기존 String형식의 input data : "+inputString);
        System.out.println("Date 형식으로 바뀐 결과 값 : "+stringToDate.stringToDateConformToFormat(inputString, format));
    }
}
