package com.algorithm.studyAlgorithm.huffmanCoding;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HuffmanEncoder {

    private List<Run> runs = new ArrayList<>();

    private Heap<Run> heap; /** minimum heap */
    private Run theRoot = null; /** root of Huffman tree */
    private Run[] chars = new Run[256];

    private void collectionRuns(RandomAccessFile fIn) throws IOException{
        /**
         * 데이터 파일 fIn에 등장하는 모든 run들과 각각의 등장횟수를 count를 하여
         * ArrayList runs에 저장한다.
         * */

    }

    private void createHuffmanTree(){
        heap = new Heap<Run>();
        /**
         * 1. store all runs into heap
         * 2. while the heap size > 1 do
         *    (1) perform extract min two times
         *    (2) make a combine tree
         *    (3) insert the combined tree into the heap
         * 3. Let the root be the root of the tree
         * */
    }

    private void assignCodeword(Run run, String codeword, String codewordLen){
        if(run.left == null && run.right == null){
            run.codeword = codeword;
            run.codewordLen = codewordLen;
        }
    }

    /** Huffman 트리의 모든 리프노드들을 chars에 recursion으로 저장한다 */
    private void storeRunsIntoArray(Run leafNode){
        if(leafNode.left == null && leafNode.right == null){
            insertToArray(leafNode);
        }else{
            storeRunsIntoArray(leafNode.left);
            storeRunsIntoArray(leafNode.right);
        }
    }

    /** 배열 chars에서 (symbol, length)에 해당하는 run을 찾아 반환한다. */
    public Run findRun(byte symbol, int length){

    }

    /** fIn: 압축할 파일, fOut: 압축된 파일 */
    private void outputFrequencies(RandomAccessFile fIn, RandomAccessFile fOut) throws IOException{
        /** run의 개수를 하나의 정수로 출력*/
        fOut.writeInt(runs.size());

        /** 원본 파일의 크기(byte단위)를 출력*/
        fOut.writeLong(fIn.getFilePointer());

        for(int j=0; j<runs.size(); j++){
            Run r = runs.get(j);
            fOut.write(r.symbol);
            fOut.writeInt(r.runLen);
            fOut.writeInt(r.freq);
        }
    }

    private void encode(RandomAccessFile fIn, RandomAccessFile fOut) throws IOException{
        List<String> buffer = new ArrayList<>();

        while(!runs.isEmpty()){
            Run runObject = runs.get(0);
            runs.remove(0);
            buffer.add(findRun(runObject.symbol, runObject.runLen).codeword);
        }
        /**
         * while there remains bytes to read in the file
         *  recognise a run;
         *  find the codeword for the run;
         *  pack the codeword into the buffer;
         *  if the buffer becomes full
         *      write the buffer into the compressed file;
         * */
        /**
         *  if buffer is not empty
         *      append 0s  into the buffer;
         *      write the buffer into the compressed file;
         * */
    }

    public void compressFile(String inFileName, RandomAccessFile fIn) throws IOException{

        String outFileName = new String(inFileName + ".z");

        RandomAccessFile fOut = new RandomAccessFile(outFileName, "rw");
        collectionRuns(fIn);
        outputFrequencies(fIn, fOut);
        createHuffmanTree();
        assignCodeword(theRoot, "0", "0");
        storeRunsIntoArray(theRoot);
        fIn.seek(0); // 파일의 시작부분으로 돌아감
        encode(fIn, fOut);
    }

    public static void main(String[] args){
        String fileName = "";
        HuffmanEncoder app = new HuffmanEncoder();
        RandomAccessFile fIn;
        Scanner kb = new Scanner(System.in);

        try{
            System.out.print("Enter a file name : ");
            fileName = kb.next();
            fIn = new RandomAccessFile("sample.txt", "r");
            app.compressFile("sample.txt",fIn);
            fIn.close();
        }catch (IOException io){
            System.err.println("Cannot open sample.txt");
        }
    }


}
