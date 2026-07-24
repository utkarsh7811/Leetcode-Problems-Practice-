class Solution {
    public void topo(int V,ArrayList<ArrayList<Integer>> adj ,ArrayList<Integer> list,int[] ind){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int p = q.poll();
            list.add(p);
            for(int node:adj.get(p)){
                ind[node]--;
                if(ind[node]==0){
                    q.add(node);
                }
            }
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] ind = new int[numCourses];
        for(int[] edge:prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            ind[u]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        topo(numCourses,adj,list,ind);
        int[] arr = new int[numCourses];
        if(list.size()<numCourses)return new int[0];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}