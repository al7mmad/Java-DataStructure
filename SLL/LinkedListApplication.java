package SLL;

public class LinkedListApplication {
	public static void main(String[] args) {
		SLL<String> fruitList = new SLL<String>(); 
                System.out.print("After inserting Mango : ");
                fruitList.addToTail("Mango");
                fruitList.printAll();
                
                System.out.print("After inserting Avocado : ");
                fruitList.addToTail("Avocado");
                fruitList.printAll();
                
                System.out.print("After inserting Lime : ");
                fruitList.addToTail("Lime");
                fruitList.printAll();
                
                System.out.print("After inserting Peach : ");
                fruitList.addToTail("Peach");
                fruitList.printAll();
                
                System.out.print("After inserting Apple : ");
                fruitList.addToTail("Apple");
                fruitList.printAll();
                
                System.out.println("");
                System.out.println("The orgianl list:  ");
		fruitList.printAll();
                
                System.out.print("After insertBefore the list is >>  ");
                fruitList.insertBefore("Avocado", "Apple");
                fruitList.printAll();
                
                
                System.out.print("After insertBefore the list is >>  ");
                fruitList.insertBefore("502", "Avocado2");
                fruitList.printAll();

                
                System.out.println("\n");
                System.out.print("After insertAfter the list is >>  ");
                fruitList.insertAfter("Watermelon", "Lime");
                fruitList.printAll();

                
//                fruitList.printAll();
                
        }
}


