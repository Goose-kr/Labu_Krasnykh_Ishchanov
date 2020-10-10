package ru.ssau.tk.Goose_kr_Gumirishche.Labu_Krasnykg_Ishanov.functions;


public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {
    private int count;
    private Node head;
    private Node last;

    private void addNode(double x, double y) {
        Node node = new Node();
        node.x = x;
        node.y = y;
        if (head == null) {
            head = node;
            node.prev = node;
            node.next = node;
            last = node;

        } else {
            last.next = node;
            head.prev = node;
            node.prev = last;
            node.next = head;
            last = node;
        }
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        this.count=xValues.length;
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        this.count=count;
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
        return last.x;
    }

    public Node getNode(int index) {
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
        }
        else {
            iNode = last;
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
        return getNode(index).x;
    }

    @Override
    public double getY(int index) {
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double value) {
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
        if (x < head.x) {
            return 0;
        }
        Node node = head;
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
        if (head.x == last.x) {
            return head.y;
        }
        return interpolate(x, head.x, head.next.x, head.y, head.next.y);
    }

    protected double extrapolateRight(double x) {
        if (head.x == last.x) {
            return head.y;
        }
        return interpolate(x, last.prev.x, last.x, last.prev.y, last.y);
    }

    protected double interpolate(double x, int floorIndex) {
        if (head.x == last.x) {
            return head.y;
        }
        return interpolate(x, getNode(floorIndex).x, getNode(floorIndex+1).x, getNode(floorIndex).y, getNode(floorIndex+1).y);
    }

    protected Node floorNodeOfX(double x) {
        Node node = head;
        if (node.x > x) {
            return head;
        }
        for (int i = 0; i < count; i++) {
            if (node.x < x) {
                node = node.next;
            } else {
                return node.prev;
            }
        }
        return last;
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
}