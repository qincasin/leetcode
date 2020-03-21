package com.qjx.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 编译出现问题 ，通过不了  List<int[]> 转换成 List<List<Integer>>
 * 大西洋和太平洋水流问题
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * <p>
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * <p>
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * 示例：
 * 给定下面的 5x5 矩阵:
 * <p>
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * 大西洋
 * <p>
 * 返回:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
public class PacificAtlanticWaterFlow {
    //定义上下左右四个方向
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();

        int m = matrix.length;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int n = matrix[0].length;
        //大西洋数组 和太平洋数组
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        //大西洋数组和太平洋数组赋值初始值 false
        //执行dfs操作
        for (int i = 0; i < m; i++) {
            //pac的 最左边  出发可以到达 太平洋
            DFS(i, 0, matrix, pac);
        }

        for (int j = 0; j < n; j++) {
            //pac的 最上面  出发可以到达 太平洋
            DFS(0, j, matrix, pac);
        }

        for (int i = 0; i < m; i++) {
            //atl 最右边  出发可以到达 大西洋
            DFS(i,  n- 1, matrix, atl);
        }

        for (int j = 0; j < n; j++) {
            //atl 做下边 出发可以到达 大西洋
            DFS(m - 1, j, matrix, atl);
        }

        //最后遍历一波
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    /**
     * @param i      横坐标
     * @param j      纵坐标
     * @param matrix 传入的二维数组
     * @param sea    两个洋
     */
    private void DFS(int i, int j, int[][] matrix, boolean[][] sea) {
        int m = matrix.length;
        int n = matrix[0].length;
        sea[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (sea[x][y]) {
                continue;
            }
            if (matrix[x][y] < matrix[i][j]) {
                continue;
            }
            DFS(x, y, matrix, sea);
        }
    }


    public static void main(String[] args) {
        //大西洋数组 和太平洋数组
        int[][] pac = new int[2][2];
        int[][] atl = new int[3][3];
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        List<int[]> res= solution.pacificAtlantic(matrix);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
        System.out.println(res);

//[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
        System.out.println(Arrays.toString(pac));
        System.out.println(Arrays.toString(atl));
    }


}
