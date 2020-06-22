package com.xianyu.asset;

public class Assets {

    public static boolean assetsArrayEquals(int[] source, int[] target) {
        System.out.println("source: " + getArrayString(source));
        System.out.println("target: " + getArrayString(target));
        if (source == target) {
            return true;
        }
        if (source == null || target == null) {
            return false;
        }
        if (source.length == target.length) {
            for (int i = 0; i < source.length; i++) {
                if (source[i] != target[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String getArrayString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

}
