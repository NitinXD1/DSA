class NumArray {
    int[] arr;
    int[] org;
    int N;

    public NumArray(int[] nums) {
        N = nums.length;
        arr = new int[N+1];
        this.org = new int[N];

        for(int i=0;i<N;i++){
            update(i,nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - org[index];
        org[index] = val;

        index++;
        while(index <= N){
            arr[index] += diff;
            index += (index & (-index));
        }
    }
    
    public int sumRange(int left, int right) {
        int a = findVal(left);
        int b = findVal(right+1);

        return b-a;
    }

    public int findVal(int x){
        int sum = 0;
        while(x > 0){
            sum += arr[x];
            x -= (x & (-x));
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */