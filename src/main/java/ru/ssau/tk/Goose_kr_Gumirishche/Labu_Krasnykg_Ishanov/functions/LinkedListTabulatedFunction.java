package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;


import ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions.exceptions.InterpolationException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {
    private int count;
    private Node head;

    private static class Node {
        public Node next;
        public Node prev;
        public double x;
        public double y;
    }

    private void controlIndex(int index) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("index left bounds");
        }
    }


    private void addNode(double x, double y) {
        Node newNode = new Node();
        if (head == null) {
            newNode.x = x;
            newNode.y = y;
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;

        } else {
            newNode.x = x;
            newNode.y = y;
            Node last = head.prev;
            last.next = newNode;
            head.prev = newNode;
            newNode.prev = last;
            newNode.next = head;
        }
        count++;
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        checkLengthIsTheSame(xValues, yValues);
        checkSorted(xValues);
        if (xValues.length < 2) {
            throw new IllegalArgumentException("Length < 2");
        }
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count < 2) {
            throw new IllegalArgumentException("Length < 2");
        }
        if (xFrom >= xTo) {
            throw new IllegalArgumentException("bounds left");
        }
        double step = (xTo - xFrom) / (count - 1);
        for (int i = 0; i < count; i++) {
            addNode(xFrom, source.apply(xFrom));
            xFrom += step;
        }
    }

    public int getCount() {
        return count;
    }

    public double leftBound() {
        return head.x;
    }

    public double rightBound() {
        return head.prev.x;
    }

    public Node getNode(int index) {
        controlIndex(index);
        Node iNode;
        if (index < count / 2) {
            iNode = head;
            for (int i = 0; i <= count / 2; i++) {
                if (i == index) {
                    return iNode;
                } else {
                    iNode = iNode.next;
                }

            }
        } else {
            iNode = head.prev;
            for (int i = count - 1; i >= count / 2; i--) {
                if (i == index) {
                    return iNode;
                } else {
                    iNode = iNode.prev;
                }
            }
        }
        return iNode;
    }

    @Override
    public double getX(int index) {
        controlIndex(index);
        return getNode(index).x;
    }

    @Override
    public double getY(int index) {
        controlIndex(index);
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double value) {
        controlIndex(index);
        getNode(index).y = value;
    }

    public int indexOfX(double x) {
        Node xNode = head;
        for (int i = 0; i < count; i++) {
            if (xNode.x == x) {
                return i;
            }
            xNode = xNode.next;
        }
        return -1;
    }

    public int indexOfY(double y) {
        Node yNode = head;
        for (int i = 0; i < count; i++) {
            if (yNode.y == y) {
                return i;
            }
            yNode = yNode.next;
        }
        return -1;
    }

    public int floorIndexOfX(double x) {
        Node node = head;
        if (x < head.x) {
            throw new IllegalArgumentException("X out left bound");
        }
        for (int i = 0; i <= count; i++) {
            if (node.x < x) {
                node = node.next;
            } else {
                return i - 1;
            }
        }
        return getCount();
    }

    protected double extrapolateLeft(double x) {
        if (head.x == head.prev.x) {
            return head.y;
        }
        return interpolate(x, head.x, head.next.x, head.y, head.next.y);
    }

    protected double extrapolateRight(double x) {
        if (head.x == head.prev.x) {
            return head.y;
        }
        return interpolate(x, head.prev.prev.x, head.prev.x, head.prev.prev.y, head.prev.y);
    }

    protected double interpolate(double x, int floorIndex) {
        if (head.x == head.prev.x) {
            return head.y;
        }
        if (x < getNode(floorIndex).x || x > getNode(floorIndex + 1).x) {
            throw new InterpolationException("x is out of bounds of interpolation");
        }
        return interpolate(x, getNode(floorIndex).x, getNode(floorIndex + 1).x, getNode(floorIndex).y, getNode(floorIndex + 1).y);
    }

    protected Node floorNodeOfX(double x) {
        Node node = head;
        if (node.x > x) {
            return head;
        }
        if (x < head.x) {
            throw new IllegalArgumentException("X out left bound");
        }
        for (int i = 0; i < count; i++) {
            if (node.x < x) {
                node = node.next;
            } else {
                return node.prev;
            }
        }
        return head.prev;
    }

    @Override
    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else {
            Node node = floorNodeOfX(x);
            if (node.x == x) {
                return node.y;
            } else {
                return interpolate(x, node.x, node.next.x, node.y, node.next.y);
            }
        }
    }

    @Override
    public Iterator<Point> iterator() {
        Iterator<Point> it = new Iterator<>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                return node != head.prev && node !=null;
            }

            @Override
            public Point next() {
                if (!hasNext()){
                    throw new NoSuchElementException();
                }else {
                    Point point = new Point(node.x, node.y);
                    if(node == head.prev){
                        node = null;
                    }else {
                        node = node.next;
                    }
                    return point;
                }
            }
            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
