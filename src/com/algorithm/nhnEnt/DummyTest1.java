package com.algorithm.nhnEnt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class DummyTest1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> storage = new LinkedList<>();
        List<String> output = new ArrayList<>();
        while(st.hasMoreTokens()){

            String newItem = st.nextToken();

            if(storage.contains(newItem)){
                storage.remove(newItem);
                storage.add(newItem);
            }else if(storage.size() < 3){
                storage.add(newItem);
            }else{
                output.add(((LinkedList<String>) storage).getFirst());
                ((LinkedList<String>) storage).removeFirst();
                storage.add(newItem);
            }

        }

        if(output.isEmpty()){
            System.out.print(0);
        }else{
            for(String result: output){
                System.out.println(result);
            }
        }

    }
}
