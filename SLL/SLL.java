package SLL;



//**************************  SLL.java  *********************************
//           a generic singly linked list class 
public class SLL<T> {

    protected SLLNode<T> head, tail;

    public SLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(T el) {
        head = new SLLNode<T>(el, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        } 
        else {
            head = tail = new SLLNode<T>(el);
        }
    }

    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) {
            return null;
        }
        T el = head.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } 
        else {
            head = head.next;
        }
        return el;
    }

    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) {
            return null;
        }
        T el = tail.info;
        if (head == tail) // if only one node in the list;
        {
            head = tail = null;
        } 
        else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;        // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }

    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty()) {
            if (head == tail && el.equals(head.info)) // if only one
            {
                head = tail = null;       // node on the list;
            } 
            else if (el.equals(head.info)) // if more than one node on the list;
            {
                head = head.next;    // and el is in the head node;
            } 
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                        tmp != null && !tmp.info.equals(el);
                        pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                    {
                        tail = pred;
                    }
                }
            }
        }
    }

    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.info + " ");
        }
        System.out.println();
    }

    public boolean isInList(T el) {
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        return tmp != null;
    }

    public int length() {
        int count = 0;

        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            count = count + 1;
        }
        return count;
    }

    public void insertBefore(T newElem, T existingElem) {

        if (isInList(existingElem)) {
            for (SLLNode<T> tmp = head; tmp.info != null; tmp = tmp.next) {
                if (existingElem.equals(tmp.info)) {
                    addToHead(newElem);
                    break;
                } 
                else if (existingElem.equals(tmp.next.info)) {
                    
                    SLLNode<T> position = tmp;
                    SLLNode<T> newNode = new SLLNode<T>(newElem, position);
                    newNode.next = position.next;
                    position.next = newNode;
                    break;
                }
            }
        } 
        else {
            System.out.println("-1");
        }
    }

    public void insertAfter(T newElem, T existingElem) {
        
       SLLNode<T> tmp = head;

        if (isInList(existingElem)) {
            
            for (tmp = head; tmp.info != null ; tmp = tmp.next){
           
            if (existingElem.equals(tail.info)) {
                addToTail(newElem);
                break;
            } 
            else if (existingElem.equals(head.info)){
                SLLNode<T> position = tmp;
                System.out.println("1111");
                SLLNode<T> newNode = new SLLNode<T>(newElem, position);
                newNode.next = position.next;
                position.next = newNode;
                break;
            }
            else if (existingElem.equals(tmp.next.info)) {
                SLLNode<T> position = tmp.next;
                SLLNode<T> newNode = new SLLNode<T>(newElem, position);
                newNode.next = position.next;
                position.next = newNode;
                break; 
            } 
            
                 

            }
        }
        
        else {
            System.out.println("existingElem does not exist ");
        }

    }

    public void deleteBefore(T existingElem) {
        if (!isEmpty()) {
            if (head == tail && existingElem.equals(head.info)) // if only one
            {
                System.out.println("It has only one node");
            } 
            else if (existingElem.equals(head.next.info)) // if two node on the list;
            {
                head = head.next;
            } 
            else if (!existingElem.equals(head.info)) {                    // if more than one node in the list
                SLLNode<T> pred, tmp;
                for (pred = head, tmp = head.next;
                        tmp != null && !tmp.next.info.equals(existingElem);
                        pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if existingElem was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                    {
                        tail = pred;
                    }
                }
            } 
            else {
                System.out.println("There is no element before existingElem ");
            }
        }
    }

    public void deleteAfter(T existingElem) {

        if (!isEmpty()) {

                if (head == tail && existingElem.equals(head.info)) // if only one
                {
                    System.out.println("It has only one node");

                } 
                else if (existingElem.equals(tail.info)){ // if select the tail 
                    System.out.println("It is the last element");
                }
                else if (existingElem.equals(head.info)) { // if two node on the list;
                    head.next = head.next.next;
                    System.out.println("done2");
                } 
                else if (isInList(existingElem)) { // if more than one node in the list
                    SLLNode<T> pred, tmp;
                    for (pred = head, tmp = head.next;
                        tmp != null && !pred.info.equals(existingElem);
                        pred = pred.next, tmp= tmp.next) ;
                    if (tmp != null) {   // if el was found;
                            pred.next = tmp.next;
                            if (tmp == tail) // if el is in the last node;
                            {
                                tail = pred;
                            }
                        }
                } 
                else {
                    System.out.println("There is no element after existingElem ");
                }
            }
        }

    }


