//package com.algorithm.studyAlgorithm.huffmanCoding;
//
//import java.io.IOException;
//import java.io.RandomAccessFile;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class HuffmanDecoder {
//
//    private List<Run> runs = new ArrayList<>();
//
//    private Heap<Run> heap; /** minimum heap */
//    private Run theRoot = null; /** root of Huffman tree */
//    private Run[] chars = new Run[256];
//    private long charCnt;
//
//    private void createHuffmanTree(){
//        heap = new Heap<Run>();
//        /**
//         * 1. store all runs into heap
//         * 2. while the heap size > 1 do
//         *    (1) perform extract min two times
//         *    (2) make a combine tree
//         *    (3) insert the combined tree into the heap
//         * 3. Let the root be the root of the tree
//         * */
//    }
//
//    private void assignCodeword(Run run, String codeword, String codewordLen){
//        if(run.left == null && run.right == null){
//            run.codeword = codeword;
//            run.codewordLen = codewordLen;
//        }
//    }
//
//    /** 배열 chars에서 (symbol, length)에 해당하는 run을 찾아 반환한다. */
//    public Run findRun(byte symbol, int length){
//
//    }
//
//    /** fIn: 압축할 파일, fOut: 압축된 파일 */
//    private void inputFrequencies(RandomAccessFile fIn) throws IOException{
//        int dataIndex = fIn.readInt();
//        charCnt = fIn.readLong(); // 원본 파일의 길이
//
//        for(int j=0; j<dataIndex; j++){
//            Run r = runs.get(j);
//            r.symbol = (byte)fIn.read();
//            r.runLen = fIn.readInt();
//            r.freq = fIn.readInt();
//            runs.add(r);
//        }
//    }
//
//    private void decode(RandomAccessFile fIn, RandomAccessFile fOut) throws IOException{
//        List<String> buffer = new ArrayList<>();
//
//        while(!runs.isEmpty()){
//            Run runObject = runs.get(0);
//            runs.remove(0);
//            buffer.add(findRun(runObject.symbol, runObject.runLen).codeword);
//        }
//        /**
//         * while there remains bytes to read in the file
//         *  recognise a run;
//         *  find the codeword for the run;
//         *  pack the codeword into the buffer;
//         *  if the buffer becomes full
//         *      write the buffer into the compressed file;
//         * */
//        /**
//         *  if buffer is not empty
//         *      append 0s  into the buffer;
//         *      write the buffer into the compressed file;
//         * */
//    }
//
//    public void decompressFile(String inFileName, RandomAccessFile fIn) throws IOException{
//
//        String outFileName = new String(inFileName + ".dec");
//
//        RandomAccessFile fOut = new RandomAccessFile(outFileName, "rw");
//
//        inputFrequencies(fIn, fOut);
//        createHuffmanTree();
//        assignCodeword(theRoot, "0", "0");
//        decode(fIn, fOut);
//    }
//
//    public static void main(String[] args){
//        String fileName = "";
//        HuffmanDecoder app = new HuffmanDecoder();
//        RandomAccessFile fIn;
//        Scanner kb = new Scanner(System.in);
//
//        try{
//            System.out.print("Enter a file name : ");
//            fileName = kb.next();
//            fIn = new RandomAccessFile("sample.txt", "r");
//            app.decompressFile("sample.txt",fIn);
//            fIn.close();
//        }catch (IOException io){
//            System.err.println("Cannot open sample.txt");
//        }
//    }
//
//
//}
