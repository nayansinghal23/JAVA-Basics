public class SubstringWithConcatinationOfWords {
    // https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

    public List<Integer> findSubstring(String s, String[] words) {
        int sLen = s.length();
        List<Integer> res = new ArrayList<>();

        int wordsLen = words.length;
        int wLen = words[0].length();
        int totalLen = wordsLen * wLen;

        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (int left = 0; left <= sLen - totalLen; left++) {
            Map<String, Integer> temp = new HashMap<>(freq);
            boolean valid = true;

            for (int i = left; i < left + totalLen; i += wLen) {
                String chunk = s.substring(i, i + wLen);

                if (!temp.containsKey(chunk)) {
                    valid = false;
                    break;
                }

                int count = temp.get(chunk);

                if (count == 1) {
                    temp.remove(chunk);
                } else {
                    temp.put(chunk, count - 1);
                }
            }

            if (valid && temp.isEmpty()) {
                res.add(left);
            }
        }

        return res;
    }
}
