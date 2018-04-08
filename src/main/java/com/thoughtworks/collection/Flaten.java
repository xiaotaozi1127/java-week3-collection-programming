package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer[]> list = Arrays.asList(this.array);
        List<Integer> result = new ArrayList<>();
        list.stream().forEach(i -> {
            List<Integer> item = Arrays.asList(i);
            result.addAll(item);
        });
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> flatten = this.transformToOneDimesional();
        return flatten.stream().distinct().collect(Collectors.toList());
    }
}
