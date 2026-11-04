class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // return kahnTopologicalSort(numCourses, prerequisites);
        return !dfsCycle(numCourses, prerequisites);

    }

    private boolean dfsCycle(int numCourses, int[][] prerequisites) {
        boolean visited[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            List<Integer> courses = adjList.getOrDefault(u, new ArrayList<>());
            courses.add(v);
            adjList.putIfAbsent(u, courses);
        }
        for(int i=0; i<numCourses; i++) {
            if(dfs(adjList, visited, i, path)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Map<Integer,List<Integer>> adjList, boolean visited[], int u, boolean path[]) {
        if(visited[u]) {
            return false;
        }
        visited[u] = true;
        path[u]=true;
        for(int v : adjList.getOrDefault(u, new ArrayList<>())) {
            if(!visited[v]) {
                if(dfs(adjList, visited, v, path)) {
                    return true;
                }
            } else
                if(path[v]) {
                    return true;
                }
        }
        path[u] = false;
        return false;
    }

    private boolean kahnTopologicalSort(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int i=0; i<prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegree[v]++;
            List<Integer> courses = adjList.getOrDefault(u, new ArrayList<>());
            courses.add(v);
            adjList.putIfAbsent(u, courses);
        }
       
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i]==0) {
                queue.add(i);
            }
        }

        List<Integer> courseSchedule = new ArrayList<>();
        while(!queue.isEmpty()) {
            int course = queue.poll();
            courseSchedule.add(course);
            for(int v : adjList.getOrDefault(course, new ArrayList<>())) {
                indegree[v]--;
                if(indegree[v]==0) {
                    queue.add(v);
                }
            }
        }

        return courseSchedule.size()==numCourses;
    }
}
