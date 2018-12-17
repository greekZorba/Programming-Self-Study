package com.algorithm.kakao;

import java.io.*;
import java.util.LinkedList;

public class BlindTestNumber3 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     int cacheSize = Integer.parseInt(br.readLine());
	     String[] inputArray = br.readLine().toUpperCase().split(" ");
	     
	     bw.write(String.valueOf(calculate(cacheSize, inputArray)));
	     bw.flush();
	}

	private static int calculate(int cacheSize, String[] inputArray){
		LinkedList<String> cache = new LinkedList<>();
		int runTime = 0;

		for(int i=0; i<inputArray.length; i++){
			inputArray[i] = inputArray[i].toUpperCase();

			if(cache.contains(inputArray[i])){
				cache.remove(inputArray[i]);
				cache.add(inputArray[i]);
				runTime += 1;

			}else if(cacheSize > 0){
				if(cache.size() == cacheSize){
					cache.remove();
				}

				runTime += 5;
				cache.add(inputArray[i]);
			}else{
				runTime += 5;
			}

		}

		return runTime;
	}
	
}
