package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Author: Hojjat Shabab
 *
 * Created on April 18, 2021, 04:25 PM
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("*******************************welcome to the MergSortAlgotithm progrm*************************************");
        System.out.print("please enter length for Array=");
        int num = input.nextInt();
        int array[] = new int[num];
        Random random = new Random();
        System.out.println("An array was generated randomly");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
            System.out.print(array[i] + " ");
        }
        System.out.println("\n\n"+"Sorted using the mergSort algorithm");
        long timeMillisThird = System.currentTimeMillis();
        mergSort(num, array);
        long timeMillisfourth = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("Time in milliseconds for mergsort: " + (timeMillisfourth - timeMillisThird));
    }

    public static void mergSort(int lengthMainArray, int mainArray[]) {
        int lengthTempArrayFirst, lengthTempArraySecond;
        lengthTempArrayFirst = lengthMainArray / 2;
        lengthTempArraySecond = lengthMainArray - lengthTempArrayFirst;
        int tempArrayFirst[] = new int[lengthTempArrayFirst];
        int tempArraySecond[] = new int[lengthTempArraySecond];
        if (lengthMainArray > 1) {
            for (int i = 0; i < lengthTempArrayFirst; i++)
                tempArrayFirst[i] = mainArray[i];
            for (int i = 0; i < lengthTempArraySecond; i++)
                tempArraySecond[i] = mainArray[i + lengthTempArrayFirst];
            mergSort(lengthTempArrayFirst, tempArrayFirst);
            mergSort(lengthTempArraySecond, tempArraySecond);
            merg(lengthTempArrayFirst, lengthTempArraySecond, tempArrayFirst, tempArraySecond, mainArray);
        }
    }

    public static void merg(int lengthTempArrayFirst, int lengthTempArraySecond, int tempArrayFirst[], int tempArraySecond[], int mainArray[]) {
        int i, j, k;
        i = j = k = 0;
        while (i < lengthTempArrayFirst && j < lengthTempArraySecond) {
            if (tempArrayFirst[i] < tempArraySecond[j]) {
                mainArray[k] = tempArrayFirst[i];
                i++;
            } else {
                mainArray[k] = tempArraySecond[j];
                j++;
            }
            k++;
        }
        if (i > lengthTempArrayFirst - 1) {
            while (j < lengthTempArraySecond)
                mainArray[k++] = tempArraySecond[j++];
        } else {
            while (i < lengthTempArrayFirst)
                mainArray[k++] = tempArrayFirst[i++];

        }
    }
}
