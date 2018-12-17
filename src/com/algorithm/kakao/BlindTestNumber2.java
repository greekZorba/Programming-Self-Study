package com.algorithm.kakao;

import java.io.*;

public class BlindTestNumber2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String givenInput = br.readLine();
        bw.write(String.valueOf(cacluateScore(givenInput)));
        bw.flush();

    }

    private static int cacluateScore(String givenInput){
        double[] scoreArray = new double[3];
        int scoreOrder = -1;

        for(int i=0; i<givenInput.length(); i++){

            char checkChar = givenInput.charAt(i);
            if((checkChar == '0' && givenInput.charAt(i-1) != '1') || (checkChar == '1' && givenInput.charAt(i+1) != '0')
              || checkChar == '2' || checkChar == '3' || checkChar == '4'
              || checkChar == '5' || checkChar == '6' || checkChar == '7'
              || checkChar == '8' || checkChar == '9'){

                scoreArray[++scoreOrder] = Character.getNumericValue(checkChar);
                
            }else if(checkChar == '1' && givenInput.charAt(i+1) == '0'){
                scoreArray[++scoreOrder] = 10;

            }else if(checkChar == 'S'){
                scoreArray[scoreOrder] = Math.pow(scoreArray[scoreOrder], 1);

            }else if(checkChar == 'D'){
                scoreArray[scoreOrder] = Math.pow(scoreArray[scoreOrder], 2);

            }else if(checkChar == 'T'){
                scoreArray[scoreOrder] = Math.pow(scoreArray[scoreOrder], 3);

            }else if(checkChar == '*'){

                if(scoreOrder == 0){
                    scoreArray[scoreOrder] = scoreArray[scoreOrder]*2;
                }else{
                    scoreArray[scoreOrder] = scoreArray[scoreOrder]*2;
                    scoreArray[scoreOrder-1] = scoreArray[scoreOrder-1]*2;
                }
            }else if(checkChar == '#'){
                    scoreArray[scoreOrder] = -scoreArray[scoreOrder];
            }
        }

        int sum = 0;

        for(double score: scoreArray){
            sum += (int)score;
            
        }

        return sum;
    }
}


