package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0;
        int begin = leftBorder < rightBorder ? leftBorder : rightBorder;
        int end = leftBorder < rightBorder ? rightBorder : leftBorder;
        for(int i = begin; i <= end; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum = 0;
        int begin = leftBorder < rightBorder ? leftBorder : rightBorder;
        int end = leftBorder < rightBorder ? rightBorder : leftBorder;
        for(int i = begin; i <= end; i++){
            if(i % 2 != 0){
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        Integer sum = 0;
        for(Integer i : arrayList){
            sum += i * 3 + 2;
        }
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(i -> {
            if(i % 2 != 0){
                return i * 3 + 2;
            }
            return i;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        Integer sum = 0;
        for(Integer i : arrayList){
            if(i % 2 != 0){
                sum += i * 3 + 5;
            }
        }
        return sum;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenIndexList = new ArrayList<>();
        for(int i = 0; i < arrayList.size(); i++){
            if(i % 2 == 0){
                evenIndexList.add(arrayList.get(i));
            }
        }
        if(evenIndexList.size() % 2 != 0){
            return evenIndexList.get(evenIndexList.size() / 2);
        }
        return (evenIndexList.get(evenIndexList.size() / 2 - 1)
                + evenIndexList.get(evenIndexList.size() / 2)) / 2;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        Integer sum = 0;
        for(Integer i : arrayList){
            if( i % 2 == 0){
                sum += i;
            }
        }
        return sum / 2;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(i -> i % 2 == 0 && i == specialElment)
                .collect(Collectors.toList()).size() > 0;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        return arrayList.stream().sorted((o1, o2) -> {
            if(o1 % 2 == 0 && o2 % 2 == 0){
                return o1 > o2 ? 1 : -1;
            }
            if(o1 % 2 == 0 && o2 % 2 != 0){
                return -1;
            }
            if(o1 % 2 != 0 && o2 % 2 == 0){
                return 1;
            }
            return o1 > o2 ? -1 : 1;
        }).collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for(Integer i = 0; i < arrayList.size() - 1; i++){
            Integer integer = (arrayList.get(i) + arrayList.get(i + 1)) * 3;
            result.add(integer);
        }
        return result;
    }
}
