class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        for(int i=0;i<n;i++){
            sort(i,0,grid,false);
        }

        for(int i=1;i<n;i++){
            sort(0,i,grid,true);
        }

        return grid;
    }

    public void sort(int row,int col,int[][] grid,boolean order){
        ArrayList<Integer> arr = new ArrayList<>();

        int rowC = row;
        int colC = col;
        
        while(row < grid.length && col < grid.length){
            arr.add(grid[row][col]);
            row++;
            col++;
        }

        if(arr.size() == 1)return;

        if(!order){
            Collections.sort(arr);
            Collections.reverse(arr);
        }
        else{
            Collections.sort(arr);
        }

        for(int i=0;i<arr.size();i++){
            grid[rowC][colC] = arr.get(i);
            rowC++;
            colC++;
        }
    }
}