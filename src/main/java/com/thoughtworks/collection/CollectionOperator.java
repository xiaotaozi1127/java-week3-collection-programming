package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if(left <= right){
            for(int i = left; i <= right; i++){
                result.add(i);
            }
        }else{
            for(int i = left; i >= right; i--){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if(left <= right){
            for(int i = left; i <= right; i++){
                if(i % 2 == 0) {
                    result.add(i);
                }
            }
        }else{
            for(int i = left; i >= right; i--){
                if(i % 2 == 0) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> result = new ArrayList<>();
        for(int i: array){
            if(i % 2 == 0){
                result.add(new Integer(i));
            }
        }
        return result;
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        int[] output = Arrays.stream(firstArray)
                .filter(i -> Arrays.stream(secondArray).anyMatch(j -> j == i))
                .toArray();
        List<Integer> result = new ArrayList<>();
        for(int i : output){
            result.add(new Integer(i));
        }
        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> first = Arrays.asList(firstArray);
        List<Integer> second = Arrays.asList(secondArray);
        List<Integer> output = second.stream().filter(i -> !first.contains(i)).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        result.addAll(first);
        result.addAll(output);
        return result;
    }
}
