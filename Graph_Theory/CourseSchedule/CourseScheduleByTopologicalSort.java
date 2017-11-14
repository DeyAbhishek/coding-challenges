/*
https://leetcode.com/problems/course-schedule/description/
207. Course Schedule
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you 
should also have finished course 1. So it is impossible.
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
click to show more hints.
Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists 
and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

class CourseScheduleByTopologicalSort {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return true;
        if (prerequisites.length == 0) return true;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int[] edge : prerequisites) {
            int point1 = edge[0];
            int point2 = edge[1];
            
            graph.computeIfAbsent(point1, x -> new ArrayList<Integer>()).add(point2);
        }
               
        
        for (int i = 0; i < graph.size();) {
            
            Map.Entry<Integer, List<Integer>> pair = new ArrayList<>(graph.entrySet()).get(i);
            int node = pair.getKey();
            int size = graph.size();
            int count = 0;
            for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
                int key = entry.getKey();
                List<Integer> value = entry.getValue();
                if (value.contains(node)) break;
                count++;
            }
            if (count == size) {
                graph.remove(node);
                i = 0;
            } else {
                i++;
            }
        }
        return graph.size() == 0;
        
    }
    
      
}
