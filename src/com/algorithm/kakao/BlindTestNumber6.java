package com.zorba.practice.kakao;

import java.io.*;
import java.util.StringTokenizer;

public class BlindTestNumber6 {
	
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     
	     int row = Integer.parseInt(br.readLine());
	     int column = Integer.parseInt(br.readLine());
	     String[][] picture = new String[row][column];
	     boolean[][] check = new boolean[row][column];
	     st = new StringTokenizer(br.readLine());
	     
	     for(int i=0; i<row; i++){
	    	 String inputString = st.nextToken();
	    	 
	    	 for(int j=0; j<column; j++){
	    		 picture[i][j] = String.valueOf(inputString.charAt(j));
	    		 check[i][j] = true;
	    	 }
	     }
	     
	     boolean flag = true;
	     int count = 0;
	     while(flag){
	    	 
	     
	     for(int i=0; i<row-1; i++){
	    	 
	    	 for(int j=0; j<column-1; j++){
	    		 
	    		 if(picture[i][j].equals(picture[i][j+1]) && picture[i][j].equals(picture[i+1][j])  && picture[i][j].equals(picture[i+1][j+1]) ){
	    			 check[i][j] = false;
	    			 check[i][j+1] = false; 
	    			 check[i+1][j] = false;
	    			 check[i+1][j+1] = false;
	    		 }
	    	 }
	     }
	     
	     flag = false;
	     count = 0;
	     for(int i=0; i<column-1; i++){
	    	 
	    	 for(int j=row-1; j>=0; j--){
	    		 
	    		 if(check[j][i] == false){
	    			 flag = true;
	    			 int originOrder = j;
	    			 
		    		 while(true){
		    			 
		    			 if(j <0){
		    				 picture[originOrder][i] = "0";
		    				 check[originOrder][i] = true;
		    				 count++;
		    				 break;
		    				 
		    			 }else if(check[j][i]== true){
		    				 picture[originOrder][i] = picture[j][i];
		    				 picture[j][i] = "0";
		    				 check[originOrder][i] = true;
		    				 count++;
		    				 break;
		    			 }
		    			 j--;
		    			 
		    		 }
		    	 }
	    	 }
	    	 
	     } 
	     
	     }
	     bw.write(String.valueOf(count));
	     bw.flush();
	     
	     
	}

}
