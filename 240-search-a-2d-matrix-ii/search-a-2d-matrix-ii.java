class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;

        for(int[] i : matrix){
            if(check(i,target))return true;
        }

        return false;
    }

    public boolean check(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return false;
    }
}