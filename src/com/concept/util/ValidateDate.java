package com.concept.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 입력한 날짜가 달력상으로 유효한 날짜인지 아닌지 체크해줄 수 있는 메서드
 * 주요 포인트는 SimpleDateFormat의 setLenient
 * */
public class ValidateDate {

    public static void main(String[] args){
        ValidateDate validateDate = new ValidateDate();
        String notValidatedDate = "2018-12-32";
        String validatedDate = "2017-01-01";
        System.out.print(validateDate.validationDate(notValidatedDate,"yyyy-MM-dd"));
        System.out.println();
        System.out.print(validateDate.validationDate(validatedDate,"yyyy-MM-dd"));

    }

    public boolean validationDate(String checkDate, String formatForm){

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(formatForm);
            dateFormat.setLenient(false);
            dateFormat.parse(checkDate);
            System.out.println(checkDate+"는 유효한 날짜입니다.");
        }catch (ParseException e) {
            System.out.println(checkDate+"는 유효하지 않은 날짜입니다.");
            return false;
        }
        return true;
    }
}
