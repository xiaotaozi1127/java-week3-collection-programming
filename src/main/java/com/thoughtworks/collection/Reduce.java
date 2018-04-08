package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream().max(Integer::compare).get();
    }

    public double getMinimum() {
        return this.arrayList.stream().min(Integer::compare).get();
    }

    public double getAverage() {
        Integer sum = 0;
        for(Integer i : arrayList){
            sum += i;
        }
        return (double)sum / this.arrayList.size();
    }

    public double getOrderedMedian() {
        List<Integer> sort = this.arrayList.stream().sorted().collect(Collectors.toList());
        if(sort.size() % 2 != 0) {
            return sort.get(sort.size() / 2);
        }
        return (double)(sort.get(sort.size() / 2 - 1) + sort.get(sort.size() / 2)) / 2;
    }

    public int getFirstEven() {
        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
