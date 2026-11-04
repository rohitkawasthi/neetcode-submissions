class Solution {
    /*
        questions
            - diagonal 1s are not the same island
        
        edge cases
            - single 1s
        
        pseudo code

        visited[][] - initially all false
        count - number of islands
        for (i from 0 to m) {
            for (j from 0 to n) {
                if(!visited[i][j] && numIslands(grid, i, j, count)) {
                    count++;
                }
            }
        }

        void numIslands(char[][] grid, i, j, visited) {
            //check boundary conditions and return
            
            if(!visited[i][j] && grid[i][j] == '1') {
                visited[i][j] = true;
                numIslands(grid, i, j+1, visited);//right
                numIslands(grid, i, j-1, visited);//left
                numIslands(grid, i+1, j, visited);//down
                numIslands(grid, i-1, j, visited);//up

            }

        }
        time complexity - O(m*n)
        space comlexity - O(m*n)
    
    */
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    numIslands(grid, i, j);
                    count++;
                }
            }
        }
       
        return count;
    }   

    void numIslands(char[][] grid, int i, int j) {
        //check boundary conditions and return
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length) {
            return;
        }

        //return if already visited or it is not a part of island
        if(grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = '2';
        numIslands(grid, i-1, j);//up
        numIslands(grid, i, j+1);//right
        numIslands(grid, i+1, j);//down
        numIslands(grid, i, j-1);//left
    }
}
