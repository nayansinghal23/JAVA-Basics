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


public class BasicCalculator2 {
    // https://leetcode.com/problems/basic-calculator-ii/

    public int calculate(String s) {
        int res = 0, n = 0;
        Stack<Integer> st = new Stack<>();
        s += '+';
        char op = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;

            if(Character.isDigit(c)) {
                n = n * 10 + (c - '0');
                continue;
            }

            if(op == '+') st.push(n);
            else if(op == '-') st.push(-n);
            else if(op == '*') st.push(st.pop() * n);
            else if(op == '/') st.push(st.pop() / n);

            op = c;
            n = 0;
        }
        while(!st.isEmpty()) res += st.pop();
        return res;
    }
}

public class BasicCalculator3 {
    // https://www.lintcode.com/problem/849/

    int idx = 0;

    public int calculate(String s) {
        idx = 0;
        return helper(s);
    }

    private int helper(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';

        while (idx < s.length()) {
            char c = s.charAt(idx);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                idx++;
                num = helper(s);
            }

            if ((!Character.isDigit(c) && c != ' ') || idx == s.length() - 1) {

                switch (sign) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop() * num);
                        break;
                    case '/':
                        st.push(st.pop() / num);
                        break;
                }

                if (c == ')')
                    break;

                sign = c;
                num = 0;
            }

            idx++;
        }

        int ans = 0;
        while (!st.isEmpty())
            ans += st.pop();

        return ans;
    }
}