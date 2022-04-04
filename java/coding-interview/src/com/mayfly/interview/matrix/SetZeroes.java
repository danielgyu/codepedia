package com.mayfly.interview.matrix;

import java.util.ArrayList;
import java.util.List;

public class SetZeroes {
    public class Pair {
        int col;
        int row;

        public Pair(int col, int row) {
            this.col=col;
            this.row=row;
        }
    }

    public void setZeroes(int[][] matrix) {
        int cols = matrix.length;
        int rows = matrix[0].length;
        List<Pair> indices = new ArrayList<>();

        // check indices of zeroes
        for (int i=0; i<cols; i++) {
            for (int j=0; j<rows; j++) {
                if (matrix[i][j] == 0) {
                    indices.add(new Pair(i, j));
                }
            }
        }

        // now spread those zeroes
        for (Pair p : indices) {
            // up
            int col = p.col - 1;
            while (col > -1) {
                matrix[col--][p.row] = 0;
            }
            // down
            col = p.col + 1;
            while (col < cols) {
                matrix[col++][p.row] = 0;
            }

            // left
            int row = p.row - 1;
            while (row > -1) {
                matrix[p.col][row--] = 0;
            }
            // right
            row = p.row + 1;
            while (row < rows) {
                matrix[p.col][row++] = 0;
            }
        }
    }
}
