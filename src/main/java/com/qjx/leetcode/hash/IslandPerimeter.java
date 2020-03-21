package com.qjx.leetcode.hash;

import java.util.Date;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Output: 16
 * <p>
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * <p>
 * 463. Island Perimeter
 *
 * @ClassName IslandPerimeter
 * @Description 岛屿的周长
 * @Author qincasin
 * @Date 2019/1/10 9:28
 * @Version 1.0
 **/
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //row
        int row = grid.length;
        //col
        int col = grid[0].length;
        int sum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int k = 0;
                if (grid[i][j] == 1) {
                    //check left
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        k++;
                    }
                    //check right
                    if (j + 1 < col && grid[i][j + 1] == 1) {
                        k++;
                    }
                    //check top
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        k++;
                    }
                    //check down
                    if (i + 1 < row && grid[i + 1][j] == 1) {
                        k++;
                    }
                    sum += (4 - k);
                }
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        IslandPerimeter solution = new IslandPerimeter();

        //{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}
        int[][] grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};

        int result = solution.islandPerimeter(grid);
        System.out.println(result);
        System.out.println(new Date());


    }

}
