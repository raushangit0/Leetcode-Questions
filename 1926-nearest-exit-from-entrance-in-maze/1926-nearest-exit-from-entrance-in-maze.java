class Solution {
    int bfs(char [][] maze , int[] entrance)
    {
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            level++;

            for(int i = 0 ; i < size; i++)
            {
                int[] arr = q.poll();
                int row = arr[0];
                int col = arr[1];

                for(int newX = row-1 ; newX <= row+1 ; newX++)
                {
                    for(int newY = col-1 ; newY <= col+1 ; newY++)
                    {
                        if(newX == row-1 && newY == col-1 ||
                           newX == row-1 && newY == col+1 ||
                           newX == row+1 && newY == col-1 ||
                           newX == row+1 && newY == col+1 ||
                           newX == row &&  newY == col)
                           {
                            continue;
                           }
                        if(newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length)
                        {
                            continue;
                        }
                        if(maze[newX][newY] == '.')
                        {
                            if(newX == 0 || newY == 0 || newX == maze.length-1 || newY == maze[0].length-1)
                            {
                                return level;
                            }
                            maze[newX][newY] ='+';
                            q.offer(new int[]{newX , newY});
                        }
                    }
                }
            }
        }
        return -1;
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        return bfs(maze , entrance);
    }
}