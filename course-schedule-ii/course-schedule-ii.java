class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        for (int[] pre: prerequisites) {
            if (!graph.containsKey(pre[1])) {
                graph.put(pre[1], new ArrayList<Integer>());
            }
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        int[] order = new int[numCourses];
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        
        int i = 0;
        while(!q.isEmpty()) {
            int pre = q.poll();
            order[i++] = pre;
            
            if (graph.containsKey(pre)) {
                List<Integer> nextCourses = graph.get(pre);
                for (Integer course: nextCourses) {
                    indegree[course] --;
                    if (indegree[course] == 0)
                        q.add(course);
                }
            }
        }
        
        if (i == numCourses)
            return order;
        
        return new int[0];
    }
}