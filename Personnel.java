class Personnel implements Comparable<Personnel> {
   String ssn;
   String first;
   String last;
   
   Personnel(String ssn, String first, String last){
      this.ssn = ssn;
      this.first = first;
      this.last = last;
   }
   
   public int compareTo(Personnel other){
     int thisSSN = Integer.parseInt(this.ssn);
     int otherSSN = Integer.parseInt(other.ssn);
     
     if (thisSSN > otherSSN){
       return 1;
     }
     else if (thisSSN == otherSSN){
       return 0;}
     else{
       return -1;
     }

     //return   this.ssn.compareTo(other.ssn) ;
       
      
   }
   
   public String toString(){
      return ssn+" "+last+", "+first;
   }
   
}
   