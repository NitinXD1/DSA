class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> ans = new ArrayList<>();
        int base = 1;
        while(n > 0){
            int num = (n % 10) * base;
            base *= 10;
            if(num != 0)ans.add(num);
            n /= 10;
        }

        int[] arr = new int[ans.size()];
        int index = 0;
        for(int i=ans.size()-1;i>=0;i--){
            arr[index++] = ans.get(i);
        }

        return arr;
    }
}