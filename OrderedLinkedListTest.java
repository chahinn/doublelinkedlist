import junit.framework.TestCase;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class OrderedLinkedListTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testAdd() {
    
    OrderedLinkedList<Double> orderedList= new OrderedLinkedList<Double>();
    ArrayList<Double> aList = new ArrayList<Double>();
    for(int i=0; i<100;i++){
      double num=Math.random();
      assertTrue(orderedList.add(num));
      assertTrue(aList.add(num));
      
    }
    System.out.println(orderedList);
    Collections.sort(aList);
    assertEquals("Test add", orderedList, aList);
    
    for (int j=0;j<100;j++){
     Double geti2 = orderedList.get(j);
     Double geti3 = aList.get(j);
     
     assertEquals("Test add", geti2, geti3);
      
    }
    
  }
  
  
   public void testRemove() {
     OrderedLinkedList<Double> orderedList2= new OrderedLinkedList<Double>();
     orderedList2.add(1.1);
     orderedList2.add(10.1);
     orderedList2.add(100.1);
     assertEquals("Test remove equals 100",100.1,orderedList2.remove(2));
     assertEquals("Test remove equals 100",10.1,orderedList2.get(1));
     
     
   }
   
   
   public void testContains() {
     
     OrderedLinkedList<Double> orderedList3= new OrderedLinkedList<Double>();
     
     orderedList3.add(1.1);
     orderedList3.add(10.1);
     orderedList3.add(100.1);
   
     assertEquals("Index must equal 1",1,orderedList3.indexOf(10.1));
  
}
}
