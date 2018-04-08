package com.thoughtworks.collection;

public class Node<T>
{
    protected T data;
    protected Node<T> link;

    public Node()
    {
        link = null;
        data = null;
    }
    public Node(T d, Node n)
    {
        data = d;
        link = n;
    }
    public void setLink(Node n)
    {
        link = n;
    }
    public void setData(T d)
    {
        data = d;
    }
    public Node getLink()
    {
        return link;
    }
    public T getData()
    {
        return data;
    }
}
