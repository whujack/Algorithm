package com.github.whujay.string.match;

/**
 * @author Created by lijie.li at 2021/4/20
 */
public class KMP2 {

    public static int[] getNext(String p) {
        int[] next = new int[p.length()];

        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int match(String s, String p) {
        if (s == null || p == null) {
            return -1;
        }
        if (p.length() == 0) {
            return 0;
        }
        int[] next = getNext(p);
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == s.length()) {
                return i - j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String[][] cases = {{"abababab", "aba"}, {"mississippi", "issip"}};
        for (String[] item : cases) {
            System.out.println(match(item[0], item[1]));
        }
    }
}
