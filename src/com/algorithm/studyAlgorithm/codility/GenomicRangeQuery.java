package com.algorithm.studyAlgorithm.codility;

public class GenomicRangeQuery {
    private static final int IMPACT_FACTOR_OF_A = 1;
    private static final int IMPACT_FACTOR_OF_C = 2;
    private static final int IMPACT_FACTOR_OF_G = 3;
    private static final int IMPACT_FACTOR_OF_T = 4;

    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        for(int i=0; i < P.length; i++){

            int min = Integer.MAX_VALUE;

            for(int j=P[i]; j <= Q[i]; j++){

                if(min > getImpactFactor(String.valueOf(S.charAt(j)))){

                    min = getImpactFactor(String.valueOf(S.charAt(j)));
                }

            }

            result[i] = min;
        }

        return result;
    }

    private int getImpactFactor(String matchString){

        switch (matchString){
            case "A":
                return IMPACT_FACTOR_OF_A;
            case "C":
                return IMPACT_FACTOR_OF_C;
            case "G":
                return IMPACT_FACTOR_OF_G;
            case "T":
                return IMPACT_FACTOR_OF_T;
            default:
                return Integer.MAX_VALUE;
        }

    }



    public static void main(String[] args) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        String S = "CAGCCTA";
        int[] P = new int[]{2,5,0};
        int[] Q = new int[]{4,5,6};

        int[] output = genomicRangeQuery.solution(S,P,Q);
        for(int out: output){
            System.out.print(out + " ");
        }

    }
}
