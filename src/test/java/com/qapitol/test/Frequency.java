package com.qapitol.test;

import java.util.ArrayList;

public class Frequency {
    public static void main(String[] args) {
        int[] input = {10, 20, 12, 18, 14, 14, 17, 18, 19, 15, 20, 17};
        boolean[] bool = new boolean[input.length];
        ArrayList list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            int count = 0;
            if (bool[i] != true) {
                for (int j = 1; j < input.length; j++) {
                    if (input[j] == input[i]) {
                        count++;
                        bool[j] = true;
                    }
                }

                if (count > 1) {
                    list.add(input[i]);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
