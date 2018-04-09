package com.thoughtworks.collection;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
//        return this.arrayList.stream().max(Integer::compare).get();
        return Collections.max(arrayList);
    }

    public double getMinimum() {
//        return this.arrayList.stream().min(Integer::compare).get();
        return Collections.min(arrayList);
    }

    public double getAverage() {
//        Integer sum = 0;
//        for(Integer i : arrayList){
//            sum += i;
//        }
//        return (double)sum / this.arrayList.size();
        return (double)arrayList.stream().mapToInt(n -> n).sum() / arrayList.size();
    }

    public double getOrderedMedian() {
        List<Integer> sort = this.arrayList.stream().sorted().collect(Collectors.toList());
        if(sort.size() % 2 != 0) {
            return sort.get(sort.size() / 2);
        }
        return (double)(sort.get(sort.size() / 2 - 1) + sort.get(sort.size() / 2)) / 2;
    }

    public int getFirstEven() {
        return this.arrayList.stream().filter(i -> i % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        return this.arrayList.indexOf(this.getFirstEven());
    }

    public boolean isEqual(List<Integer> arrayList) {
//        if(arrayList.size() != this.arrayList.size())
//            return false;
//        return this.arrayList.stream()
//                .filter(i -> !arrayList.contains(i))
//                .collect(Collectors.toList())
//                .size() > 0 ?
//                false: true;
        return this.arrayList.toString().equals(arrayList.toString());
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        singleLink = new IntegerSingleLinkList<Integer>();
        for(Integer i : this.arrayList){
            singleLink.addTailPointer(i);
        }
        int size = singleLink.size();
        if(size % 2 == 0){
            Integer node = (Integer) singleLink.getNode(size / 2 - 1);
            Integer node1 = (Integer) singleLink.getNode(size / 2);
            return (double)(node + node1) / 2;
        }
        return Double.parseDouble(singleLink.getNode(size / 2).toString());
    }

    public int getLastOdd() {
        List<Integer> collect = this.arrayList.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        return collect.get(collect.size() - 1);
    }

    public int getIndexOfLastOdd() {
        return this.arrayList.lastIndexOf(getLastOdd());
    }
}
