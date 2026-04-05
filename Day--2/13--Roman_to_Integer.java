// 2 - Approaches : 

class Solution {
    public int romanToInt(String s) {
        // USING HASHMAP

        // building the map 
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); // entering key - value pairs in map
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // converting input string to character array to make it iteratable
        char chars[] = s.toCharArray();
        int res = 0;
        int i,j; // declared globally to be able to access last symbol 
        for ( i = 0, j = 1; j < chars.length; i++, j++) {
            if(map.get(chars[i]) >= map.get(chars[j])) {
                res += map.get(chars[i]);
            }
            else {
                res -= map.get(chars[i]);
            }
        }
        res += map.get(chars[i]);
        return res;
    }
}

// Explanation - Hum pehle ek HashMap banate hain jisme Roman symbols aur unki values store hoti hain. Phir string ko traverse karte hain aur har character ko next character se compare karte hain. Agar current value ≥ next value hai, toh usse result mein add kar dete hain; lekin agar current value < next value ho (jaise IV, IX cases), toh usse subtract kar dete hain. Loop ke baad last character ko separately add karte hain kyunki uska comparison nahi hota. Is tarah hum efficiently poora Roman number integer mein convert kar lete hain.

// OR

  class Solution {
    public int romanToInt(String s) {
        // USING ARRAY MAPPING

        // ASCII array mapping
        int arr[] = new int[128];
        arr['I'] = 1; // entering values in array
        arr['V'] = 5;
        arr['X'] = 10;
        arr['L'] = 50;
        arr['C'] = 100;
        arr['D'] = 500;
        arr['M'] = 1000;

        int res = 0;
        for ( int i = s.length() - 1; i >= 0; i--) { // Traverse from right to left
            int curr = arr[s.charAt(i)];
            // If smaller than next (right side), subtract
            if(i < s.length() - 1 && curr < arr[s.charAt(i+1)]) {
                res -= curr;
            }
            else {
                res += curr;
            }
        }
        return res;
    }
}

// Explanation - Hum ek ASCII array bana lete hain jisme har Roman character ki value store hoti hai, taaki fast lookup ho sake. Phir string ko right se left traverse karte hain. Har character ke liye uski value nikalte hain aur next (right side) character se compare karte hain—agar current value chhoti hai next se, toh usse subtract kar dete hain (jaise IV, IX cases), warna add kar dete hain. Is tarah bina extra space ke efficiently poora Roman number integer mein convert ho jata hai.
// TC = O(n) (Single pass)
// SC = O(1) (ASCII array ka size fixed (128) hai, input size pe depend nahi karta.)
