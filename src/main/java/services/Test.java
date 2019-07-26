package services;

import util.Operations;

public class Test {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        Operations<Integer> rev = new Operations<>();

        for(int n : arr){
            System.out.print(n);
        }

        Integer[] res = rev.reverse(arr);

        System.out.println("");


        for (int n : arr) {
            System.out.print(n);
        }


    }
}
