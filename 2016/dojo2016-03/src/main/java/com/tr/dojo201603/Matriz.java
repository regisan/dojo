package com.tr.dojo201603;

public class Matriz {

    public int[][] espiral(int lin, int col) {

        int[][] result = new int[lin][col];

        int elemento = 1;
        
        int total = lin * col;
        int i = 0;
        int j = 0;
        //int direcao = 1;
        //int posl = 0;
        
        while (elemento <= total) {
            for (;j < col; j++) {
                if (result[i][j] == 0)
                    result[i][j] = elemento++;
            }
            j--;
            i++;
            
            for (;i < lin; i++) {
                if (result[i][j] == 0)
                    result[i][j] = elemento++;
            }
            i--;
            
            for (;j >= 0; j--) {
                if (result[i][j] == 0)
                    result[i][j] = elemento++;
            }
            j++;
            
            for (;i >= 0; i--) {
                if (result[i][j] == 0)
                    result[i][j] = elemento++;
            }
            i++;
        }
        
//        for (int elemento = 1; elemento <= total; elemento++) {
//           
//            int limite = col-1;
//            for (int i = 0; i < limite; i++) {
//                result[posl][i] = elemento++;
//            }
//            posl ++;
//
//            for (int i = linhaAtual; i < lin; i++) {
//                result[i][col] = elemento++;
//            }
//            col--;
//            
//            for (int i = col-1; i >= 0; i--) {
//                result[lin-1][i] = elemento++;
//            }
//            
//        }

//        for (int i = 0; i < lin; i++) {
//
//            if (i % 2 == 0) {
//                for (int j = 0; j < col; j++) {
//                    result[i][j] = elemento++;
//                }
//            } else {
//                for (int j = col - 1; j >= 0; j--) {
//                    result[i][j] = elemento++;
//                }
//            }
//        }

        // result[0][0] = 1;
        // result[0][1] = 2;
        // result[1][0] = 4;
        // result[1][1] = 3;

        return result;
    }

}
