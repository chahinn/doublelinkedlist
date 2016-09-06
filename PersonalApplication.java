import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PersonalApplication{
  
  public static void main(String[] args) throws FileNotFoundException{
    
    OrderedLinkedList<Personnel> arr1= new OrderedLinkedList<Personnel>(new PersonnelComparator());
    OrderedLinkedList<Personnel> arr2= new OrderedLinkedList<Personnel>();
    
    File given =new File("personnel.txt");
  
    Scanner scanner = new Scanner(given); 
    
    String ssn="";
    String last="";
    String first="";
    //int count =1;
    String str;
    

    while(scanner.hasNext()){
      
      ssn = scanner.next();
      last = scanner.next();
      first = scanner.next();
      
  
      
      Personnel human= new Personnel(ssn, first, last);
      arr1.add(human);
      arr2.add(human);
      
      
     /*
       if(count==1){
       ssn=str;
       count++;
       }
       else if(count==2){
       last=str;
       count++;
       }
       else{
       first=str;
       Personnel human= new Personnel(ssn, first,last);
       arr1.add(human);
       arr2.add(human);
       count=1;
       
       }
       
       */
    }
    
    System.out.println("The following is a list by last name with a length of: " + arr1.size);
    for(Personnel p:arr1){
      System.out.println(p);
    }
 
    System.out.println("The following is a list by SSN");
    for(Personnel s:arr2){
     System.out.println(s);
    }
    
 
   
  }
}