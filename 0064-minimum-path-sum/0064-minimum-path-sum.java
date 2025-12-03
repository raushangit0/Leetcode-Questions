class Solution {
     static int[][] t = new int[200][200];
    //  Memoization Technique
    /* static int solve(int arr[][],int i,int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length){
            return 201*200*200;
        }
        if(i==arr.length-1 && j==arr[0].length-1){
            return arr[i][j];
        }
         if (t[i][j] != -1) {
            return t[i][j];
        }
        int right=arr[i][j]+solve(arr,i,j+1);
        int down=arr[i][j]+solve(arr,i+1,j);
        return t[i][j]=Math.min(right,down);
    }*/

    static int tebulation(int arr[][]){
        for(int i=1;i<arr.length;i++){
           arr[i][0]=arr[i][0]+arr[i-1][0];
        }
        for(int i=1;i<arr[0].length;i++){
           arr[0][i]=arr[0][i]+arr[0][i-1];
        }

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                arr[i][j]=arr[i][j]+(Math.min(arr[i][j-1],arr[i-1][j]));
            }
        }
        return arr[arr.length-1][arr[0].length-1];
    }
    public int minPathSum(int[][] grid) {
        // for (int i = 0; i < grid.length; i++) {
        //     Arrays.fill(t[i], -1);
        // }
        // return solve(grid,0,0);
        return tebulation(grid);
    }
}