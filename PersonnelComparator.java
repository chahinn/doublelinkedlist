import java.util.*;

class PersonnelComparator implements Comparator<Personnel> {
  public int compare(Personnel p1, Personnel p2){
  
    //System.out.println(p1.last + " " + p2.last + " compareTo value: " + p1.last.compareTo(p2.last));      
    
    if(p1.last.compareTo(p2.last)==0){
      if(p1.first.compareTo(p2.first)==0){
        return p1.compareTo(p2); 
      }
      else{
        return p1.first.compareTo(p2.first); 
      }
      
    }  
    
    else{
      return p1.last.compareTo(p2.last);
    }   
    
    
  }
  
}
