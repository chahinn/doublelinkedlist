/*
 * OrderedLinkedList
 * 
 * This class implements the Java List interface using a doubly-linked list.
 * 
 * Two nested classes are included:  ListNode and OrderedLinkedListIterator.
 * 
 */
import java.util.*;
/*
 * Use this header if T is required to be Comparable
 * public class OrderedLinkedList<T extends Comparable<T>> extends AbstractList<T> {
 */
public class OrderedLinkedList<T> extends AbstractList<T> {
  int size;
  ListNode header, trailer;
  Comparator<T> comparator;
  
  /*
   * ListNode
   * 
   * This class represents one node in a doubly linked list.
   */
  protected class ListNode {
    T datum;
    ListNode prior, next;
    
    ListNode(){
      this(null);
    }
    
    ListNode(T data){
      this(data,null,null);
    }
    
    ListNode(T data, ListNode prior, ListNode next){
      this.datum = data;
      this.prior = prior;
      this.next = next;
    }
  } // end of class ListNode
  
  /*
   * Constructs an empty list without a Comparator.
   */
  OrderedLinkedList(){
    // TODO:  Write a constructor to construct an empty list.
    // The empty list has two sentinel nodes, a header and a trailer, linked to each other
    header = new ListNode(null,null,null);
    trailer = new ListNode(null,header,null);
    header.next = trailer;
  }
  
  /*
   * Constructs an empty list with a Comparator.
   */
  OrderedLinkedList(Comparator<T> comparator){
    this();
    this.comparator = comparator;
  }
  
  /*
   * Returns a reference to the nth node in the list.
   */
  private ListNode getNthNode(int n) {
    // scan left to right for the nth node in the list
    // this is a helper method for add, remove, get, set
    if(n<-1 || n>size)
      throw new IndexOutOfBoundsException();
    
    ListNode node = header;
    for(int i=-1; i<n; i++)
      node = node.next;
    return node;
  }
  
  /*
   * Returns a count of the number of elements in the list.
   */
  public int size() {
    return size;
  }
  
  /*
   * Deletes all elements from the list.
   */
  public void clear() {
    size = 0;
    header.next = trailer;
    trailer.prior = header;
  }
  
  /*
   * Determines if the list is empty.
   */
  public boolean isEmpty() {
    return size==0;
  }
  
  /*
   * Creates an iterator for the list
   */
  public Iterator<T> iterator(){
    return new Iterator<T>(){
      ListNode current = header.next;
      
      public boolean hasNext(){
        return current!=trailer;
      }
      public T next(){
        T item = current.datum;
        current = current.next;
        return item;
      }
      public void remove(){
        ListNode prior = current.prior.prior;
        prior.next = current;
        current.prior = prior;
        size--;
      }
    };
  }
  
  /*
   * Returns the data item at the given position in the list.
   */
  public T get(int position) {
    if(position>=size || position<0)
      throw new NoSuchElementException();
    return getNthNode(position).datum;
  }
  
  /*
   * This method is not valid for ordered lists.
   */
  public T set(int position, T data) {
    throw new UnsupportedOperationException();
  }
  
  /*
   * This method is not valid for ordered lists.
   */
  public void add(int position, T data) {
    throw new UnsupportedOperationException();
  }
  
  /*
   * Inserts the given data item at the end of the list.
   */
  public boolean add(T data) {
    
    T datar = data;
    int tempsize= size;
    
    if(this.comparator!=null){
      int tempsize2=size;
      for(int i=0;i<size;i++){
        ListNode current= getNthNode(i);
        int compared= this.comparator.compare(datar,current.datum);
        if(compared <0){
          ListNode prior=current.prior;
          ListNode new1= new ListNode(datar,prior, current);
          prior.next=new1;
          current.prior=new1;
          size++;
          break;
        }
      }
      if(tempsize2==size){
        ListNode present = getNthNode(size-1);
        ListNode sent= present.next;
        ListNode new1= new ListNode(datar, present, sent);
        present.next=new1;
        sent.prior=new1;
        size++;
      }
      
      return true;
    }
    
    
    /*if(size==0){
     return false; 
     }
     
     else{
     for(int i=0;i<size;i++){
     ListNode current = getNthNode(i);
     if(comparator.compare(datar,current.datum)==-1){
     ListNode prior = current.prior;
     ListNode new1= new ListNode(datar, prior, current);
     prior.next=new1;
     current.prior=new1;
     size++;
     break;
     }
     
     }
     
     }
     if(tempsize==size){
     ListNode present = getNthNode(size-1);
     ListNode sent= present.next;
     ListNode new1= new ListNode(datar, present, sent);
     present.next=new1;
     sent.prior=new1;
     size++;
     }*/
    
    else{
      int tempsize2=size;
      for(int i=0;i<size;i++){
        ListNode current= getNthNode(i);
        int compared=((Comparable)datar).compareTo((Comparable)current.datum);
        if(compared ==-1){
          ListNode prior=current.prior;
          ListNode new1= new ListNode(datar,prior, current);
          prior.next=new1;
          current.prior=new1;
          size++;
          break;
        }
      }
      if(tempsize2==size){
        ListNode present = getNthNode(size-1);
        ListNode sent= present.next;
        ListNode new1= new ListNode(datar, present, sent);
        present.next=new1;
        sent.prior=new1;
        size++;
      }
      
    }
    return true;
    
  }
  
  
  
  
  
  
  /*
   * Removes the element at a given index in the list.
   */
  public T remove(int index) {
    ListNode current = getNthNode(index);
    T answer= current.datum;
    ListNode prior = current.prior;
    ListNode  next= current.next;
    prior.next=next;
    next.prior=prior;
    size--;
    return answer;
    
    
  }
  
  public boolean contains(Object o){
    for(int i=0; i<this.size; i++){
      if(o==  this.get(i)){
        return true; 
      }
      
      
    }
    /*  TODO:  Write the contains method.  */
    return false;  // replace this line
  }
  
  public boolean remove(Object o){
    for(int i=0; i<size;i++){
      ListNode current = getNthNode(i);
      if(o==current.datum){
        ListNode prior= current.prior;
        ListNode next = current.next;
        prior.next=next;
        next.prior=prior;
        size--;
        return true;
        
      }
    }
    return false;  // replace this line
  }
  
  public int indexOf(Object o){
    for(int i=0;i<size;i++){
      ListNode current = getNthNode(i);
      if(o==current.datum){
        return i; 
      }
    }
    
    /*  TODO:  Write the indexOf method.  */
    return -1;  // replace this line
  }
  
}