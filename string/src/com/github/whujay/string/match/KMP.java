package com.github.whujay.string.match;

import com.sun.istack.internal.NotNull;

/**
 * KMP算法
 *
 * @author Created by lijie.li at 2021/4/20
 */
public class KMP {


    /**
     * @param p 被匹配的字符串
     * @return 返回next数组
     */
    public static int[] getNext(@NotNull String p) {
        int[] next = new int[p.length()];
        if (p.length() == 0) return next;
        next[0] = -1;
        int j = -1;
        for (int i = 0; i < p.length() - 1; ) {
            if (j == -1 || p.charAt(j) == p.charAt(i)) {
                j++;
                i++;
                next[i] = j;
            } else {
                j = next[j];
            }
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
        for (int i = 0, j = -1; i < s.length(); ) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                j++;
                i++;
            } else {
                j = next[j];
            }
            if (j == p.length()) {
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
