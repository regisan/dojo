package com.tr.dojo201603;

public class Matriz {
    
    public enum StateEnum {
        UP, RIGHT, DOWN, LEFT;
    }

    public int[][] espiral(int lin, int col) {

        int[][] result = new int[lin][col];
        int element = 1;
        int n = lin * col;

        int rowStart = 0;
        int colStart = 0;
        int currentRow = 0;
        int currentCol = 0;
        
        StateEnum state = StateEnum.LEFT;
        
        while (element <= n) {
            
            switch(state) {
                case LEFT: {
                    for (int colPos = colStart; colPos < col && result[currentRow][colPos] == 0; colPos++) {
                        result[currentRow][colPos] = element++;
                        currentCol = colPos;
                    }
                    currentRow++;
                    rowStart++;
                    colStart = currentCol;
                    state = StateEnum.DOWN;
                    
                    break;
                }
                case DOWN: {
                    for (int rowPos = rowStart; rowPos < lin && result[rowPos][currentCol] == 0; rowPos++) {
                        result[rowPos][currentCol] = element++;
                        currentRow = rowPos;
                    }
                    currentCol--;
                    colStart--;
                    rowStart = currentRow;
                    state = StateEnum.RIGHT;
                    
                    break;
                }
                case RIGHT: {
                    for (int colPos = colStart; colPos >= 0 && result[currentRow][colPos] == 0; colPos--) {
                        result[currentRow][colPos] = element++;
                        currentCol = colPos;
                    }
                    currentRow--;
                    rowStart--;
                    colStart = currentCol;
                    state = StateEnum.UP;
                    break;
                }
                case UP: {
                    for (int rowPos = rowStart; rowPos >= 0 && result[rowPos][currentCol] == 0; rowPos--) {
                        result[rowPos][currentCol] = element++;
                        currentRow = rowPos;
                    }
                    currentCol++;
                    colStart++;
                    rowStart = currentRow;
                    state = StateEnum.LEFT;
    
                    break;
                }
                
            }
        }
        
        
        return result;
    }

}


