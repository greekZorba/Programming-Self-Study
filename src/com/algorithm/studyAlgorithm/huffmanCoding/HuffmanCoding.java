package com.algorithm.studyAlgorithm.huffmanCoding;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class HuffmanCoding {

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

    public void compressFile(RandomAccessFile fIn) throws IOException{

        collectionRuns(fIn);
        createHuffmanTree();
        assignCodeword(theRoot, "0", "0");
        storeRunsIntoArray(theRoot);
    }

    /** 배열 chars에서 (symbol, length)에 해당하는 run을 찾아 반환한다. */
    public Run findRun(byte symbol, int length){

    }

    public static void main(String[] args){
        HuffmanCoding app = new HuffmanCoding();
        RandomAccessFile fIn;
        try{
            fIn = new RandomAccessFile("sample.txt", "r");
            app.compressFile(fIn);
            fIn.close();
        }catch (IOException io){
            System.out.println("Cannot open sample.txt");
        }
    }


}
