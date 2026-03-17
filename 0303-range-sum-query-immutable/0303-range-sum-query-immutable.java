class NumArray {
    class segmentTree
    {
        int segTree[];

        segmentTree(int n )
        {
            segTree = new int[4*n];

        }
        void buildTree(int arr[] , int idx , int start , int end)
        {
            if(start == end)
            {
                segTree[idx] = arr[start];
                return;
            }
            int mid = (start+end)/2;

            buildTree(arr , 2*idx+1 , start , mid);
            buildTree(arr , 2*idx+2 , mid+1 , end);

            segTree[idx] = segTree[idx*2 +1] + segTree[idx*2 +2];
        }
        void update(int idx , int i , int val , int start , int end)
        {
            if(start == end)
            {
                segTree[idx] = val;
                return;
            }
            int mid = (start + end )/2;
            if(i <= mid)
                update(2*idx+1 , i , val , start , mid);
            else
                update(2*idx+2 , i , val , mid+1 , end);
            
            segTree[idx] = segTree[2*idx+1] + segTree[2*idx+2];
        }

        int query(int idx , int start , int end , int qstart , int qend)
        {
            if(start >= qstart && end <= qend) return segTree[idx];

            if(end < qstart || start > qend)return 0;

            int mid = (start+end)/2;

            int left = query(2*idx+1 , start , mid , qstart , qend);
            int right = query(2*idx+2 , mid+1 , end , qstart , qend);

            return left + right;
        }
    }
    segmentTree st;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        st = new segmentTree(n);
        st.buildTree(nums , 0 , 0 , n-1);    
    }

    public void update(int index , int val)
    {
        st.update(0 , index , val , 0 , n-1);
    }
    
    public int sumRange(int left, int right) {
        return st.query(0 , 0 , n-1 , left , right);    
    }
}