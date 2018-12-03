package com.algorithm.studyAlgorithm.huffmanCoding;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class HuffmanCoding {

    private List<Run> runs = new ArrayList<>();

    private void collectionRuns(RandomAccessFile fIn) throws IOException{
        /**
         * 데이터 파일 fIn에 등장하는 모든 run들과 각각의 등장횟수를 count를 하여
         * ArrayList runs에 저장한다.
         * */
    }

    public static void main(String[] args){
        HuffmanCoding app = new HuffmanCoding();
        RandomAccessFile fIn;
        try{
            fIn = new RandomAccessFile("sample.txt", "r");
            app.collectionRuns(fIn);
            fIn.close();
        }catch (IOException io){
            System.out.println("Cannot open sample.txt");
        }
    }


}
