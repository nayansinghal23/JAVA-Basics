public class FirstOccurenceInString {
    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

    private boolean compareStrings(String haystack, String needle, int start) {
        int j = 0;
        for (int i = start; i <= start + needle.length() - 1; i++) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                return false;
            }
            j++;
        }
        return true;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int needleCode = 0;
        int haystackCode = 0;

        for (int i = 0; i < needle.length(); i++) {
            needleCode += needle.charAt(i) - 'a';
            haystackCode += haystack.charAt(i) - 'a';
        }

        if (needleCode == haystackCode && compareStrings(haystack, needle, 0)) {
            return 0;
        }

        for (int i = 1; i <= haystack.length() - needle.length(); i++) {
            haystackCode = haystackCode
                    - (haystack.charAt(i - 1) - 'a')
                    + (haystack.charAt(i + needle.length() - 1) - 'a');

            if (needleCode == haystackCode && compareStrings(haystack, needle, i)) {
                return i;
            }
        }

        return -1;
    }
}
