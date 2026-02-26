class Solution {
    public class pair implements Comparable<pair>{
        int node;
        double prob;

        pair(int node,double prob){
            this.node=node;
            this.prob=prob;
        }

        public int compareTo(pair p){
            if(this.prob==p.prob) return this.node-p.node;
            return Double.compare(this.prob,p.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }

        double[] ans = new double[n];
        ans[start_node] = 1.0;

        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new pair(start_node, 1.0));

        while(pq.size() != 0){
            pair top = pq.poll();
            int node = top.node;
            double prob = top.prob;

            for(int i = 0; i < adj.get(node).size(); i++){
                pair p = adj.get(node).get(i);

                int x = p.node;
                double y = p.prob;

                if(ans[x] < prob * y){
                    ans[x] = prob * y;
                    pq.add(new pair(x, ans[x]));
                }
            }
        }

        return ans[end_node];
    }
}