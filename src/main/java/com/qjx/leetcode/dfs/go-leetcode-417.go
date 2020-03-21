package dfs

import "fmt"

func pacificAtlantic(matrix [][]int) [][]int {

	if matrix == nil || (matrix != nil && len(matrix) < 1) {
		return nil
	}

	result := [][]int{}
	m, n := len(matrix), len(matrix[0])

	pac := make([][]bool, m)
	atl := make([][]bool, m)

	for i := 0; i < m; i++ {
		pac[i] = make([]bool, n)
		atl[i] = make([]bool, n)
	}

	for i := 0; i < m; i++ {
		dfs(i, 0, matrix, pac)
	}
	for j := 0; j < n; j++ {
		dfs(0, j, matrix, pac)
	}
	for i := 0; i < m; i++ {
		dfs(i, n-1, matrix, atl)
	}
	for j := 0; j < n; j++ {
		dfs(m-1, j, matrix, atl)
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if pac[i][j] && atl[i][j] {
				result = append(result, []int{i, j})
			}
		}
	}

	return result

}

func dfs(i int, j int, matrix [][]int, visited [][]bool) {
	dir := [][]int{{0, 1}, {0, -1}, {-1, 0}, {1, 0}}
	m, n := len(matrix), len(matrix[0])
	visited[i][j] = true

	for k := 0; k < 4; k++ {
		x, y := i+dir[k][0], j+dir[k][1]
		if x < 0 || x >= m || y < 0 || y >= n {
			continue
		}
		if visited[x][y] {
			continue
		}
		if matrix[x][y] < matrix[i][j] {
			continue
		}
		dfs(x, y, matrix, visited)
	}

	//for _, d := range dir {
	//	x, y := i+d[0], j+d[1]
	//	if x < 0 || x >= m || y < 0 || y >= n {
	//		continue
	//	}
	//	if visited[x][y] {
	//		continue
	//	}
	//	if matrix[x][y] < matrix[i][j] {
	//		continue
	//	}
	//	dfs(x, y, matrix, visited)
	//}

}
func main() {
	var matrix = [][]int{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}
	atlantic := pacificAtlantic(matrix)
	fmt.Println(atlantic)
}
