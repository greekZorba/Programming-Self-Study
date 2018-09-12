package com.zorba.practice.kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BlindTestNumber5 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     String firstInput = br.readLine().toUpperCase();
	     List<String> compareArray = new ArrayList<>();

	     for(int i=0; i<firstInput.length()-1; i++){
	    	
	    	 if(firstInput.charAt(i) <=90 && firstInput.charAt(i) >= 65
	    			 && firstInput.charAt(i+1) <=90 && firstInput.charAt(i+1) >= 65){
	    		 String word = String.valueOf(firstInput.charAt(i)) + String.valueOf(firstInput.charAt(i+1));
	    		 compareArray.add(word);
	    	 }
	     }
	     int firstArraySize = compareArray.size();
	     
	     String secondInput = br.readLine().toUpperCase();
	     int secondArraySize = 0;

	     List<String> union = new ArrayList<>(); // 교집합 
	     for(int i=0; i<secondInput.length()-1; i++){

	    		 if(secondInput.charAt(i) <=90 && secondInput.charAt(i) >= 65 
	    				 && secondInput.charAt(i+1) <=90 && secondInput.charAt(i+1) >= 65){
	    			 String word = String.valueOf(secondInput.charAt(i)) + String.valueOf(secondInput.charAt(i+1));
		    		 secondArraySize++;
	    			 
		    		 if(compareArray.contains(word)){
		    			 compareArray.remove(word);
			    		 union.add(word);
			    	 }
		    		 
	    		 }
	     }
	     
	     
	     double common =  (firstArraySize + secondArraySize) - union.size() == 0 ? 1:(firstArraySize + secondArraySize) - union.size(); // 합집합 
	     double unionSize = union.size() == 0 ? 1:union.size(); // 교집합 
	     int result = (int) Math.floor(unionSize/common*65536);

	     bw.write(String.valueOf(result)); 
	     bw.flush();
	}

}
