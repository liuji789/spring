package com.example;

public class aaaaa {

    //aaba  1
    //bbaabaaaab  0
    public static void main(String[] args) {
        String aCountStr = "aabaabaaaaab";
        int a = aCountStr.lastIndexOf("a");

        char[] chars = aCountStr.toCharArray();

        int m = 1;

        for (int i = a - 1; i >= 0; i--) {
            if (chars[i] == 'a') {
                m++;
            } else {
                break;
            }
        }

        System.out.println("m = " + m);

    }

}
