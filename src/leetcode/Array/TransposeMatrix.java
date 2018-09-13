package leetcode.Array;

import java.util.Arrays;

/**
 * 矩阵的转置
 *
 * @author casin
 * @create 2018-09-13 13:24
 **/
public class TransposeMatrix {
    /**
     *Given a matrix A, return the transpose of A.
     *
     * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
     * @param A
     * @return
     */
    /**
     * Input: [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[1,4,7],[2,5,8],[3,6,9]]
     *
     * Input: [[1,2,3],[4,5,6]]
     * Output: [[1,4],[2,5],[3,6]]
     * @param A
     * @return
     */
    public static int[][] transpose(int[][] A) {
        int row =A.length;
        int column = A[0].length;
        int[][] result=new int[column][row];
        System.out.println(row+" "+column);
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                result[i][j]=A[j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] A ={{1},{4}};
        System.out.println(Arrays.deepToString(transpose(A)));

    }

}
