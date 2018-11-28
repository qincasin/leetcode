package array;

import java.util.Arrays;

/**
 * 重新改造矩阵
 *
 * 给定一个二维数组，给定一个行 r 和列 c，按照行排序进行重新组装成r*c 的新矩阵
 *
 * @author casin
 * @create 2018-09-14 17:17
 **/
public class ReshapeTheMatrix {

    /**
     * 矩阵->一维数组 -> 赋值
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        int[][] result = new int[r][c];
        int row = nums.length;
        int col = nums[0].length;
        if(r*c!=row*col){
            return nums;
        }
        //二维数组变为一维数组
        int index=0;
        int[] oneArray = new int[row*col];
        for (int[] array : nums) {
            for (int e : array) {
                oneArray[index++]=e;
            }
        }
        //组装矩阵获取
        int index2 = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                result[i][j]=oneArray[index2++];
            }
        }

        return result;
    }

    /**
     * 矩阵 转 矩阵
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape2(int[][] nums,int r,int c){
        int[][] res = new int[r][c];
        //原数组行、列
        int row = nums.length;
        int col = nums[0].length;
        if(r*c!=row*col){
            return nums;
        }
        for(int i=0;i<row*col;i++){
            res[i/c][i%c] = nums[i/col][i%col];
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        int[][] result = matrixReshape2(nums,1,4);
        System.out.println(Arrays.deepToString(result));
    }

}
