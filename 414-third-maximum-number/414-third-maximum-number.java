class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        int index = 0;
        if (numSet.size() >= 3) {
            index = numSet.size() - 3;
        } else {
            index = numSet.size() - 1;
        }
        System.out.println(numSet.size());
        int[] result = new int[numSet.size()];
        int cnt = 0;
        for (int i : numSet) {
            result[cnt++] = i;
        }
        Arrays.sort(result);
        return result[index];
        
    }
}