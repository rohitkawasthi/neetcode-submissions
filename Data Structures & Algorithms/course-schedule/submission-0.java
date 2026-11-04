class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
