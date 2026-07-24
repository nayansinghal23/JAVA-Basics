public class TextJustification {
    // https://leetcode.com/problems/text-justification/description/

    private String justify(String s, int maxWidth, boolean isLast) {
        int spaces = maxWidth - s.length();
        String words[] = s.split(" ");
        int gaps = words.length - 1;
        if(isLast || gaps == 0) return s + " ".repeat(spaces);

        int distribution = spaces / gaps, remainder = spaces % gaps;
        String ans = words[0];
        for(int i = 1; i <= gaps; i++) {
            if(remainder > 0) {
                ans += " ";
                remainder--;
            }
            ans += " ".repeat(distribution + 1) + words[i];
        }
        return ans;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        String s = words[0];
        for(int i = 1; i < words.length; i++) {
            if(s.length() + 1 + words[i].length() <= maxWidth) s += " " + words[i];
            else {
                ans.add(justify(s, maxWidth, false));
                s = words[i];
            }
        }
        if(s.length() > 0) ans.add(justify(s, maxWidth, true));
        return ans;
    }
}
