class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] arr = s.split(" ");

        int n = arr.length;

        for(int i=n-1;i>=0;i--){
            if(arr[i].trim().length() > 0){
                ans.append(arr[i].trim() + " ");
            }
        }

        ans.deleteCharAt(ans.length()-1);

        return ans.toString();
    }
}