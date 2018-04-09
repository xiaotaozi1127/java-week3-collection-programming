package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(i -> i * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        List<String> result = new ArrayList<>();
        this.array.stream().forEach(i -> result.add(this.letterList.get(i -1)));
        return result;
    }

    public List<String> mapLetters() {
        List<String> result = new ArrayList<>();
        this.array.stream().forEach(i -> {
            int i1 = i - 1;
            if(i <= 26){
                result.add(this.letterList.get(i1));
            }else{
                int first = i1 / 26;
                int second = i1 % 26;
                result.add(this.letterList.get(first - 1)
                        + this.letterList.get(second));
            }
        });
        return result;
    }

    public List<Integer> sortFromBig() {
//        return this.array.stream().sorted((o1, o2) -> o1 < o2 ? 1: -1).collect(Collectors.toList());
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return this.array.stream().sorted().collect(Collectors.toList());
    }
}
