package CLL;

public class CLL<T> {
    protected CLLNode<T> current;
    public CLL() {
       current = null;
    }
    
    public boolean isEmpty() {
        return current == null;
    }
    
    public void addToEnd(T el) {
        if(isEmpty()) {
            current = new CLLNode(el);
            current.next = current;
        }
        else {
            CLLNode<T> newNode = new CLLNode(el, current);
            CLLNode<T> temp = current; //the "first" node of the Circular Linked List
            while(temp.next != current) 
               temp = temp.next; //reach the last node before current
            temp.next = newNode;
        }
    }
    
    public void addToBeginning(T el) {
         this.addToEnd(el);
         if(current.next == current) return;
         
         CLLNode<T> tmp = current;
         
         while(tmp.next != current)
            tmp = tmp.next;
         current = tmp;
    }
    
    
    
    
    /*
    
    
    NOTE : #ERROR 
    Your method work properly but it does not delete the last element
    and it returns null where it should the deleted node value.
    
    
    ## TRY TO SOLVE IT , THEN REMOVE THIS NOTE ... 
    
    
    */
    
    
    public T deleteFromBeginning() { 
      //QUIZ METHOD
      //Given a CLL printed as "A B C D E", 
      //after a call to deleteFromBeginning 
      //the output should be B C D E
    	
        CLLNode<T> tmp = current;

    	
    	if(isEmpty())
    		return null; 
    	
        while(tmp.next != current)
            tmp = tmp.next;
        
        current = current.next;
        tmp.next = current; 
        tmp = current;
        
		return null;  
   
    }

    public void printTheList() {
        if(current == null) return;
        CLLNode<T> temp = this.current;
        do {
            System.out.print(temp.info + " ");
            temp = temp.next;  
        } 
        while(temp != current);         
        System.out.println();
    }
    
    public int lengthOfTheList() {
    	CLLNode<T> temp = this.current;
    	int count = 0 ; 

	   if(current == null) 
		   return 0 ;
    	 do {
             temp = temp.next; 
             count++;
         } 
         while(temp != current);      

    	
       return count;      
    }

    
}    
