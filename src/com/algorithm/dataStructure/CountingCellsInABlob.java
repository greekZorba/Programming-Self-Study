package com.algorithm.dataStructure;

/********************************************************************
 *
 *
 * Blob은 서로 연결된 이미지 pixel들의 집합을 말한다.
 *
 * 출처: inflearn 권오흠 교수님 알고리즘 강좌
 *
 *********************************************************************/
public class CountingCellsInABlob {
    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_COLOR = 1;
    private static int ALREADY_COUNTED = 2;

    static int[][] map;
    public static void main(String[] args){

        map = new int[][]{
                {1,0,0,0,0,0,0,1},
                {0,1,1,0,0,1,0,0},
                {1,1,0,0,1,0,1,0},
                {0,0,0,0,0,1,0,0},
                {0,1,0,1,0,1,0,0},
                {0,1,0,1,0,1,0,0},
                {1,0,0,0,1,0,0,1},
                {0,1,1,0,0,1,1,1}
        };

        System.out.println("Blob의 셀 수: "+countCells(3, 5));
    }

    static int countCells(int x, int y){
        if(x < 0 || x > map.length-1 || y < 0 || y > map[x].length-1 ){
            return 0;
        }else if(map[x][y] != 1 ){ // 벽이거나 이미 카운팅한 셀
            return 0;
        }else{
            map[x][y] = ALREADY_COUNTED;
            return 1 + countCells(x-1, y) + countCells(x-1, y+1) + countCells(x, y+1)
                    + countCells(x+1, y+1) + countCells(x+1, y) + countCells(x+1, y-1)
                    + countCells(x, y-1) + countCells(x-1, y-1);
        }

    }
}
