package com.algorithm.kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BlindTestNumber5 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     String[] firstInput = br.readLine().split(" ");
	     String[] secondInput = br.readLine().split(" ");
	     
	     Set<String> union = new HashSet<>();
	     for(String first: firstInput){
	    	 union.add(first);
	     }
	     for(String second: secondInput){
	    	 union.add(second);
	     }
	    System.out.println(union.toString());
	}

}
