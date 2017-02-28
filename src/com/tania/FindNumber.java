package com.tania;

import java.util.Arrays;

/**
 * Created by tania on 28.02.17.
 */
public class FindNumber {
    int[] arrayX;
    int[] arrayY;
    int[] arrayZ;

    public FindNumber(int p, int q, int r) {
        arrayX = new int[p];
        arrayY = new int[q];
        arrayZ = new int[r];
        fillArrays();
    }

    private void fillArrays() {
        int max = Math.max(arrayX.length, arrayY.length);
        max = Math.max(max, arrayZ.length);
        for (int i = 0; i < max; i++) {
            if (i < arrayX.length - 1)
                arrayX[i] = (int) (Math.random() * 10);
            if (i < arrayY.length - 1)
                arrayY[i] = (int) (Math.random() * 10);
            if (i < arrayZ.length - 1)
                arrayZ[i] = (int) (Math.random() * 10);
        }
    }
    public Integer findNumber(){
        Integer found;
        for (int i = 0; i < arrayX.length; i++) {
            found = arrayX[i];
            for (int j = 0; j < arrayY.length; j++) {
                if (found == arrayY[j]){
                    for (int k = 0; k < arrayZ.length; k++) {
                        if (found == arrayZ[k]){
                            return found;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void printArrays(){
        System.out.println("Z array");
        for (int i = 0; i < arrayZ.length; i++) {
            System.out.print(arrayZ[i] + "-");
        }
        System.out.println("\nX array");
        for (int i = 0; i < arrayX.length; i++) {
            System.out.print(arrayX[i] + "-");
        }
        System.out.println("\nY array");
        for (int i = 0; i < arrayY.length; i++) {
            System.out.print(arrayY[i] + "-");
        }
    }
}
