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
                if(grid[i][j] == '0') {
                    continue;
                }
                Pair current = new Pair(i,j);
                parentMap.putIfAbsent(current, current);
                tryUnion(grid, current, new Pair(i-1,j));//up
                // tryUnion(grid, current, new Pair(i+1,j));//down
                tryUnion(grid, current, new Pair(i,j-1));//left
                // tryUnion(grid, current, new Pair(i,j+1));//right
            }
        }

        Set<Pair> parentSet = new HashSet<>();
        for(Pair parent : parentMap.values()) {
            parentSet.add(findParent(parent));
        }
        // System.out.println(parentMap);
        return parentSet.size();
    }

    private void tryUnion(char[][] grid, Pair current, Pair neighbour) {
        int i = neighbour.i;
        int j = neighbour.j;
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j] == '0') {
            return;
        }
        unionByRank(current, neighbour);
    }

    private record Pair(int i, int j) {
        @Override
        public boolean equals(Object o) {
            // 1. Check for reference equality (are they the exact same object in memory?)
            if (this == o) return true;
            
            // 2. Check for null and ensure they belong to the exact same class
            if (o == null || getClass() != o.getClass()) return false;
            
            // 3. Cast the object and compare the actual primitive fields
            Pair pair = (Pair) o;
            return this.i == pair.i && this.j == pair.j;
        }

        @Override
        public int hashCode() {
            // Generates a well-distributed hash value combining both primitives
            return Objects.hash(i, j);
        }
    }
    private Map<Pair, Pair> parentMap = new HashMap<>();
    private Map<Pair, Integer> rankMap = new HashMap<>();

    private Pair findParent(Pair search) {
        Pair parent = parentMap.get(search);
        if(parent == null || parent.equals(search)) {
            return search;
        }
        return parentMap.compute(search, (key, oldValue) -> findParent(parent));
    }

    private void unionByRank(Pair pair1, Pair pair2) {
        Pair parent1 = findParent(pair1);
        Pair parent2 = findParent(pair2);
        if(parent1.equals(parent2)) {
            return;
        }
        int rank1 = rankMap.getOrDefault(parent1,0);
        int rank2 = rankMap.getOrDefault(parent2,0);
        if(rank1 == rank2) {
            parentMap.put(parent2, parent1);
            rankMap.put(parent1, rank1+1);
        } else
            if(rank1 > rank2) {
                parentMap.put(parent2, parent1);
            } else {
                parentMap.put(parent1, parent2);
            }
    }
}
