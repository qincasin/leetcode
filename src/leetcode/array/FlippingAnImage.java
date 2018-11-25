package leetcode.array;

/**
 * 翻转图像
 * @author casin
 * @create 2018-09-11 15:49
 **/

/**
 * 832. Flipping an Image
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 */

/**
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */


/**
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */

public class FlippingAnImage{
    /**
     *  翻转数组 当传入的数组为基数个位时则判断中间位置是否取反
     * @param array
     * @return
     */
    public static int[] invertArray(int[] array){
        int len = array.length;
        int mid = len/2;
        for(int i=0;i<mid;i++){
            int temp = array[i]^1;
            array[i]=array[len-1-i]^1;
            array[len-1-i]=temp;
        }
        if(array.length%2==1){
            array[mid] = array[mid] ^ 1;
        }
        return array;
    }

    public static int[][] result(int[][] array){
        for(int i=0;i<array.length;i++){
            array[i]=invertArray(array[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] array ={{1},{1},{1},{1},{1}};
        int[][] array1 = result(array);
        for(int i=0;i<array1.length;i++){
            for(int j=0;j<array1[i].length;j++){
                System.out.println(array1[i][j]);
            }
        }
    }



}
