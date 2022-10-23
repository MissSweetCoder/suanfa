class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }

        int maxValue = 0;
        int minLen = 0;
        for(Map.Entry<Integer,int[]> entry : map.entrySet()){
            int[] entryArray = entry.getValue();
            int thisLen = entryArray[2] - entryArray[1] + 1;
            if(maxValue < entryArray[0]){
                maxValue = entryArray[0];
                minLen = thisLen;
            }else if(maxValue == entryArray[0] && minLen > thisLen){
                minLen = thisLen;
            }
        }
        return minLen;
    }
}