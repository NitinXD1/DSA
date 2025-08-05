class Solution {
    String[] arr = new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        helper(0,new StringBuilder(),ans,digits);
        return ans;
    }

    public void helper(int index,StringBuilder str,List<String> ans,String digits){
        if(index == digits.length()){
            if(str.length() > 0)ans.add(str.toString());
            return;
        }

        for(char ch:arr[digits.charAt(index) - '0'].toCharArray()){
            str.append(ch);
            helper(index+1,str,ans,digits);
            str.deleteCharAt(str.length()-1);
        }

    }
}