package com.xianyu.sword;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Problem38 {

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        PermutationCore(str.toCharArray(), 0, result);
        Collections.sort(result);
        return result;
    }

    public void PermutationCore(char[] chars, int start, ArrayList<String> result) {
        if (start >= chars.length - 1) {
            if (!result.contains(String.valueOf(chars))) {
                result.add(String.valueOf(chars));
            }
            return;
        }
        for (int i = start; i < chars.length; i++) {
            char temple = chars[i];
            chars[i] = chars[start];
            chars[start] = temple;

            PermutationCore(chars, start + 1, result);

            temple = chars[i];
            chars[i] = chars[start];
            chars[start] = temple;
        }

    }

    public static void main(String[] args) {
        ArrayList<String> sorts = new Problem38().Permutation("abc");
        for (String s : sorts) {
            System.out.println(s);
        }
    }

}
