package com.thoughtworks.collection;

public class IntegerSingleLinkList<T> implements SingleLink<T> {
    protected Node<T> start;
    protected Node<T> end ;
    public int size ;

    @Override
    public T getHeaderData() {
        return start.data;
    }

    @Override
    public T getTailData() {
        return end.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return start == null;
    }

    @Override
    public boolean deleteFirst() {
        return false;
    }

    @Override
    public boolean deleteLast() {
        return false;
    }

    @Override
    public void addHeadPointer(T item) {
        Node nptr = new Node(item, null);
        size++ ;
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            nptr.setLink(start);
            start = nptr;
        }
    }

    @Override
    public void addTailPointer(T item) {
        Node nptr = new Node(item, null);
        size++ ;
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            end.setLink(nptr);
            end = nptr;
        }
    }

    @Override
    public T getNode(int index) {
        int begin = 0;
        Node<T> head = start;
        while(begin < index){
            head = head.getLink();
            begin++;
        }
        return head.data;
    }
}

