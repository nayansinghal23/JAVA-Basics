public class MinimumWindowSubstring {
    // https://leetcode.com/problems/minimum-window-substring/description/

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (end < s.length()) {
            char endChar = s.charAt(end);

            if (map.containsKey(endChar) && map.get(endChar) > 0) {
                count++;
            }

            map.put(endChar, map.getOrDefault(endChar, 0) - 1);

            while (count == t.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    sIndex = start;
                }

                char startChar = s.charAt(start);

                map.put(startChar, map.get(startChar) + 1);

                if (map.get(startChar) > 0) {
                    count--;
                }

                start++;
            }

            end++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
