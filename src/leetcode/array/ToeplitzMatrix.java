package array;

/**
 * Toeplitz矩阵
 * A matrix is Toeplitz if every diagonal （对角线）from top-left to bottom-right has the same element.
 *
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 *
 *
 * Input:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 *
 *
 * @author casin
 * @create 2018-09-14 16:09
 **/
public class ToeplitzMatrix {


    public static boolean isToeplitzMatrix(int[][] matrix) {
        //行
        int row=matrix.length;
        //列
        int col = matrix[0].length;
        /**
         * 反面情况
         *
         */
        for (int i = 0; i < row-1; i++) {
            for (int j=0;j<col-1;j++){
                if(matrix[i][j]!=matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] matrix= {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));

    }

}
