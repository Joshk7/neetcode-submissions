public class Solution {
    public bool hasDuplicate(int[] nums) {
        var seen = new HashSet<int>();
        foreach (int num in nums) {
            if (!seen.Add(num)) {
                return true;
            }
        }
        return false;
    }
}