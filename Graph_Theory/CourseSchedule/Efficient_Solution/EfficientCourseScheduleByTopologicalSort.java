public class EfficientCourseScheduleByTopologicalSort {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        
        Queue<Integer> currentVerticesWithNoInboundEdge = new LinkedList<Integer>();
        
        for(int[] pair:prerequisites){
            indegree[pair[1]]++;
        }
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                currentVerticesWithNoInboundEdge.add(i);
            }
        }
        
        while(!currentVerticesWithNoInboundEdge.isEmpty()){
            numCourses--;
            int course = currentVerticesWithNoInboundEdge.poll();
            for(int[] pair:prerequisites){
                if(pair[0]==course){
                    indegree[pair[1]]--;
                    if(indegree[pair[1]]==0){
                        currentVerticesWithNoInboundEdge.add(pair[1]);
                    }
                }
            }
        }
        
        return numCourses==0;
    }
    
}
