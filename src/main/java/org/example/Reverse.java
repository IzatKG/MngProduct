package org.example;

import java.util.Arrays;

public class Reverse {


    public static void main(String[] args) {

//        String[] names = {"Izat"};
//        for (int i = names[0].length() - 1; i >= 0; i--) {
//            System.out.print(names[0].charAt(i));
//        }

        String name = "Meder";
        char s[]=name.toCharArray();
        System.out.println(Arrays.toString(s));
        String reversed ="";
        for (int i =s.length-1; i>=0;i--){
            reversed=reversed+s[i];
            System.out.println(reversed);
            System.out.println("============================");
        }
    }


}
