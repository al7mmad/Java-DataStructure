package DLL;

import java.util.Random;


public class DLLTest {

    public static void main(String[] args) {
        Random random = new Random();
        
        DLL<Integer> test = new DLL<Integer>();
        for(int i = 0; i < 10; i++) {
            test.addToTail(random.nextInt(100));
        }
        for(int i = 0; i < 11; i++) {
            test.delete7();
            test.printAll();
        } 

        
        

        DLL<Integer> test1 = new DLL<Integer>();
        DLL<Integer> test2 = new DLL<Integer>();
        for (int i = 0; i < 10; i++) {
            test1.addToTail(random.nextInt(100));
        }

        for (int i = 0; i < 10; i++) {
            test2.addToTail(random.nextInt(100));
        }
        System.out.println("List1 : ");
// display the Doubly-linked list list1
        test1.printAll();
        System.out.println("List2 : ");
// display the Doubly-linked list list2
        test2.printAll();
        test1.insertAlternate(test2);
        System.out.println("After call insertAlternate(list2) , the List1 is : ");
        test1.printAll();
    }
}
