// 3 - Approaches :

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // DOUBLE LOOPS
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}

// OR

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HASH TABLE (ONE PASS)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No match"); // since we have to return something for this function
    }
}

// Explanation - Hum array ko ek baar traverse karte hain, aur har element ke liye complement = target - nums[i] nikalte hain. Fir check karte hain ki kya yeh complement pehle se HashMap mein hai (map mein hum number aur uska index store karte hain). Agar mil gaya, matlab dono numbers ka sum target ke equal hai, toh unke indices return kar dete hain. Agar nahi mila, toh current number aur uska index map mein daal dete hain taaki aage use ho sake.

//OR

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HASH TABLE (TWO PASSES)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // building hash table
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { map.get(complement), i };
            }
        }
        throw new IllegalArgumentException("No match"); // since we have to return something for this function
    }
}
// Explanation - Hum array ko ek baar traverse karte hain, aur har element ke liye complement = target - nums[i] nikalte hain. Fir check karte hain ki kya yeh complement pehle se HashMap mein hai (map mein hum number aur uska index store karte hain). Agar mil gaya, matlab dono numbers ka sum target ke equal hai, toh unke indices return kar dete hain. Agar nahi mila, toh current number aur uska index map mein daal dete hain taaki aage use ho sake.
