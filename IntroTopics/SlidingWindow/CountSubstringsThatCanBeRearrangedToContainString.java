public class CountSubstringsThatCanBeRearrangedToContainString {
    public long validSubstringCount(String word1, String word2) {
        // https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/

        /**
         * Test case to dry run :-
         * word1 = "dcbdcdccb" & word2 = "cdd"
         */

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int l = 0, r = 0, freq = 0;
        long ans = 0;
        while(r < word1.length()) {
            char right = word1.charAt(r);
            if(map.getOrDefault(right, 0) > 0) freq++;
            map.put(right, map.getOrDefault(right, 0) - 1);
            while(freq == word2.length() && l <= r) {
                char left = word1.charAt(l);
                map.put(left, map.getOrDefault(left, 0) + 1);
                if(map.getOrDefault(left, 0) > 0) freq--;
                l++;
            }
            // After shrinking, l is the first index that makes the window invalid.
            // Therefore, all starting indices [0 ... l-1] form valid substrings
            // ending at r, so we add l.
            ans += l;
            r++;
        }
        return ans;
    }
}
