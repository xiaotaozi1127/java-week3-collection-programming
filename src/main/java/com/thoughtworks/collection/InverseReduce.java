package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new ArrayList<>();
        do {
            int nextInt = this.random.nextInt(3);
            if(nextInt > 0) {
                number -= nextInt;
                if(number > 0) {
                    result.add(number);
                }
            }
        }
        while(number > 0);
        return result;
    }
}
