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

    public record Pair(int i, int j) {}

    void numIslands(char[][] grid, int i, int j) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        grid[i][j] = '2';

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            
            addToQueue(queue, grid, p.i-1, p.j);//up
            addToQueue(queue, grid, p.i, p.j+1);//right
            addToQueue(queue, grid, p.i+1, p.j);//down
            addToQueue(queue, grid, p.i, p.j-1);//left
        }        
    }

    void addToQueue(Queue<Pair> queue, char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        queue.add(new Pair(i,j));
    }
}
