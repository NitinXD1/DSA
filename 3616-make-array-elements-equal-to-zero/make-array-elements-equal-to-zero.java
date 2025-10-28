class Solution {
    public int countValidSelections(int[] nums) {
        int cnt = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                int[] a = nums.clone();
                int[] b = nums.clone();

                if(isValid(i,true,a))cnt++;
                if(isValid(i,false,b))cnt++;
            }
        }

        return cnt; 
    }

    public boolean isValid(int index,boolean dir,int[] temp){
        
        while(index >= 0 && index < temp.length){
            if(dir){
                index++;
            }
            else{
                index--;
            }

            if(index < 0 || index == temp.length)break;

            if(temp[index] > 0){
                temp[index]--;
                dir = !dir;
            }
        }

        for(int i:temp){
            if(i != 0)return false;
        }

        return true;
    }
}