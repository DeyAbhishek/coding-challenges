public class EfficientCourseScheduleByTopologicalSort {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> verticesWithNoInboundEdge = new LinkedList<Integer>();
        for(int[] pair:prerequisites){
            indegree[pair[1]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                verticesWithNoInboundEdge.add(i);
            }
        }
        int select = 0;
        while(!verticesWithNoInboundEdge.isEmpty()){
            numCourses--;
            int course = verticesWithNoInboundEdge.poll();
            for(int[] pair:prerequisites){
                if(pair[0]==course){
                    indegree[pair[1]]--;
                    if(indegree[pair[1]]==0){
                        verticesWithNoInboundEdge.add(pair[1]);
                    }
                }
            }
        }
        return numCourses==0;
    }
    
}
