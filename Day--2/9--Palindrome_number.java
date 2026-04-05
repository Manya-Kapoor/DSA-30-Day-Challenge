// 2 - Approaches :

class Solution {
    public boolean isPalindrome(int x) {
        //  REVERSE DIGITS APPROACH
        if (x < 0)
            return false;
        int og_num = x;
        int reversed = 0;
        while (x != 0) {
            int lastDigit = x % 10;     // Get last digit
            reversed = reversed * 10 + lastDigit;  // Build reversed number
            x /= 10;      // Remove last digit
        }
        return reversed == og_num;
    }
}
// Explanation - Hum check karte hain ki number palindrome hai ya nahi (matlab ulta likhne par same rahe). Negative numbers kabhi palindrome nahi hote, toh unhe direct false return kar dete hain. Fir number ka reverse banate hain (last digit nikal ke new number mein add karte hue). End mein original number aur reversed number compare karte hain—agar dono same hain, toh palindrome hai, warna nahi.

// OR

class Solution {
    public boolean isPalindrome(int x) {
        //  HALF REVERSE DIGITS (optimized approach)

        // Negative numbers & numbers ending with 0 (except 0 itself) are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int og_num = x;
        int reversedHalf = 0;
        // only reverse half of the number
        while (x > reversedHalf) {
            int lastDigit = x % 10; // Get last digit
            reversedHalf = reversedHalf * 10 + lastDigit; // Build reversed number
            x /= 10; // Remove last digit
        }
        // For even digits: x == reversedHalf
        // For odd digits: x == reversedHalf / 10 (middle digit ignore)
        return ((x == reversedHalf) || (x == reversedHalf / 10));
    }
}

// Explanation - Hum number ka poora reverse nahi banate, sirf uska half reverse karte hain. Har step pe last digit nikal ke reversedHalf mein add karte hain aur original number ko chhota karte jaate hain. Jab reversedHalf >= x ho jata hai, tab loop stop kar dete hain (matlab half process ho chuka hai). End mein check karte hain: agar x == reversedHalf (even digits) ya x == reversedHalf/10 (odd digits, middle ignore) ho, toh number palindrome hai.
