package DLL;

import DLL.DLLNode;

//****************************  DLL.java  *******************************
//                  generic doubly linked list class
public class DLL<T> {

    private DLLNode<T> head, tail;

    public DLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void setToNull() {
        head = tail = null;
    }

    public T firstEl() {
        if (head != null) {
            return head.info;
        } else {
            return null;
        }
    }

    public void addToHead(T el) {
        if (head != null) {
            head = new DLLNode<T>(el, head, null);
            head.next.prev = head;
        } else {
            head = tail = new DLLNode<T>(el);
        }
    }

    public void addToTail(T el) {
        if (tail != null) {
            tail = new DLLNode<T>(el, null, tail);
            tail.prev.next = tail;
        } else {
            head = tail = new DLLNode<T>(el);
        }
    }

    public T deleteFromHead() {
        if (isEmpty()) {
            return null;
        }
        T el = head.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else {              // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty()) {
            return null;
        }
        T el = tail.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else {              // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }

    public void printAll() {
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.info + " ");
        }
        System.out.println();
    }

    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null) {
            return null;
        } else {
            return tmp.info;
        }
    }

    public void printReverse() {
        DLLNode<T> tmp = head;
        DLLNode<T> newNode;

        if (head == null) {
        } else {

            while (tmp != null) {
                newNode = tmp.next;
                tmp.next = tmp.prev;
                tmp.prev = newNode;
                tmp = newNode;
            }

            tmp = head;
            head = tail;
            tail = tmp;

        }

    }

    public void delete7() {
        int count = 1;
        DLLNode<T> tmp = head;
        DLLNode<T> newNode;
        boolean tmpBoolean = true;
        if (head == null) {
        } else {
            while (count < 7) {

                if (tmp.next == null) {
                    break;
                }

                if (tmpBoolean == true) {
                    tmp = tmp.next;
                } else {
                    tmp = tmp.prev;
                }

                if (tmp.next == null && tmpBoolean == true) {
                    tmpBoolean = !tmpBoolean;
                } else if (tmp.prev == null && tmpBoolean == false) {
                    tmpBoolean = !tmpBoolean;
                }

                count++;
            }

            if (tmp == tail) {
                deleteFromTail();
            } else if (tmp == head) {
                deleteFromHead();
            } else {
                DLLNode<T> tmp2 = tmp.prev;
                tmp2.next = tmp.next;
                tmp.next.prev = tmp2;
                tmp = null;
            }

        }
    }

    /* */
    public void insertAlternate(DLL<T> newList) {
        DLLNode<T> temp1 = head;
        DLLNode<T> temp2 = newList.head;
        if (temp1 == null || temp2 == null) {
            System.out.println("List is empty ");
            return;
        }
        int length1 = 0;
        int length2 = 0;
        while (temp1 != null) {
            length1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            length2++;
            temp2 = temp2.next;
        }
        if (length1 != length2) {
            System.out.println("They are not the same");
            return;
        } else {
            temp1 = head;
            temp2 = newList.head;

            while (temp1.next != null) {
                newList.head = temp2.next;
                temp2.next = temp1.next;
                temp2.prev = temp1;
                temp1.next.prev = temp2;
                temp1.next = temp2;
                temp2 = newList.head;
                temp1 = temp1.next;
                temp1 = temp1.next;
            }
// for last node
            temp1.next = temp2;
            temp2.prev = temp1;
            temp2.next = null;

        }

    }
}
