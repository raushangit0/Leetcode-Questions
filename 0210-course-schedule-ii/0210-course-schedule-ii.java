class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ;i < numCourses ; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < prerequisites.length ; i++)
        {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            adjList.get(to).add(from);
        }
        int [] degree = new int[numCourses];
        for(int i = 0 ; i < adjList.size() ; i++)
        {
            for(int j = 0 ; j < adjList.get(i).size(); j++)
            {
                int neigh = adjList.get(i).get(j);
                degree[neigh]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++)
        {
            if(degree[i] == 0)q.add(i);
        }
        int []ans = new int[numCourses];
        int index = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            ans[index++] = curr;

            for(int i = 0 ; i < adjList.get(curr).size(); i++)
            {
                int neigh = adjList.get(curr).get(i);
                degree[neigh]--;

                if(degree[neigh] == 0)
                {
                    q.add(neigh);
                }
            }
        }
        if(index != numCourses) return new int[0];
        return ans;
    }
}