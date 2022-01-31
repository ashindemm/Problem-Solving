class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int[] prereq: prerequisites) {
            if (!graph.containsKey(prereq[1])) {
                graph.put(prereq[1], new ArrayList<Integer>());
            }
            graph.get(prereq[1]).add(prereq[0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i, graph, visited, checked)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isCyclic(int course, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] checked) {
        if (checked[course]) {
            return false;
        }
        
        if (visited[course]) {
            return true;
        }
        
        if (!graph.containsKey(course)) {
            return false;
        }
        
        visited[course] = true;
        
        boolean cyclic = false;
        for (Integer nextCourse: graph.get(course)) {
            cyclic = isCyclic(nextCourse, graph, visited, checked);
            if (cyclic)
                break;
            
        }
        visited[course] = false;
        checked[course] = true;
        return cyclic;
    }
    
}