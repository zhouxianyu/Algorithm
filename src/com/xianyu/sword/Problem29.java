package com.xianyu.sword;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Problem29 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return list;
        }
        int columns = matrix[0].length;
        int rows = matrix.length;
        int start = 0;
        while (start * 2 < columns && start * 2 < rows) {
            printMatrixCore(matrix, start, columns, rows, list);
            start++;
        }
        return list;
    }

    public void printMatrixCore(int[][] matrix, int start, int columns, int rows, ArrayList<Integer> data) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        for (int x = start; x <= endX; x++) {
            data.add(matrix[start][x]);
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                data.add(matrix[i][endX]);
            }
        }
        if (endX > start && endY > start) {
            for (int i = endX - 1; i >= start; i--) {
                data.add(matrix[endY][i]);
            }
        }
        if (endX > start  && endY > start + 1) {
            for (int i = endY - 1; i > start; i--) {
                data.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][2];
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = number;
                number++;
            }
        }
        ArrayList<Integer> list = new Problem29().printMatrix(matrix);
        System.out.println(list);

//        int[][] matrix2 = new int[1][4];
//        int number = 1;
//        for (int i = 0; i < matrix2.length; i++) {
//            for (int j = 0; j < matrix2[0].length; j++) {
//                matrix2[i][j] = number;
//                number++;
//            }
//        }
//        ArrayList<Integer> list = new Problem29().printMatrix(matrix2);
//        System.out.println(list);

    }

}


