package com.concept.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 두 날짜간 월 차이 구하기
 * */
public class MonthsDifference {

    public static void main(String[] args){
        MonthsDifference monthsDifference = new MonthsDifference();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        try{
            Date date1 = format.parse("20180901");
            Date date2 = format.parse("20181205");

            System.out.println("두 날짜간 월 차이 :"
                    +monthsDifference.getMonthsDifference(date1, date2));
        }catch (ParseException e){
            System.out.println(e);
        }

    }

    /**
     * 두 날짜간의 월 차이 구하기
     * */
    private int getMonthsDifference(Date date1, Date date2){
        int month1 = date1.getYear() * 12 + date1.getMonth();
        int month2 = date2.getYear() * 12 + date2.getMonth();

        return month2 - month1;
    }
}
