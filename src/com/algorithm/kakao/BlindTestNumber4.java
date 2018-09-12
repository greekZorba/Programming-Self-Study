package com.zorba.practice.kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BlindTestNumber4 {

	public static void main(String[] args) throws IOException, ParseException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
	     String originInput = br.readLine();
	     originInput = originInput.substring(1, originInput.length()-1).replace("\"", "");
	     String[] inputArray = originInput.split(",");
	     for(int i=0; i<inputArray.length; i++){
	    	 System.out.println(dateFormat.parse(inputArray[i]).getHours());
	     }
	     
	}
}
