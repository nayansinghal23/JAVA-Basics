public class BasicCalculator {
    // https://leetcode.com/problems/basic-calculator/

    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0, num = 0, sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') continue;
            else if(ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            }
            else if(ch == '+' || ch == '-') {
                res += (num * sign);
                sign = ch == '+' ? 1 : -1;
                num = 0;
            }
            else if(ch == ')') {
                res += (num * sign);
                num = 0;
                sign = 1;

                int stSign = st.pop();
                int stRes = st.pop();
                res = (res * stSign) + stRes;
            }
            else num = (num * 10) + (ch - '0');
        }
        res += (num * sign);
        return res;
    }
}
