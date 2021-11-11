package com.flydean;

import jdk.incubator.vector.IntVector;

public class VectorExample {

    public static void main(String[] args) {

        //传统写法
        int[] x = {1, 2, 3, 4};
        int[] y = {4, 3, 2, 1};

        int[] c = new int[x.length];

        for (int i = 0; i < x.length; i++) {
            c[i] =x[i] * y[i];
        }


        var vectorA = IntVector.fromArray(IntVector.SPECIES_128, x, 0);
        var vectorB = IntVector.fromArray(IntVector.SPECIES_128, y, 0);
        var vectorC = vectorA.mul(vectorB);
        vectorC.intoArray(c, 0);

    }
}
