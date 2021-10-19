/**
*@author Michael Suehle
*/
public class gift extends item {//Inheritance CHECK
   String ageRange;
   String recipient;
   
   //Constructors
   
   /**
   * Constructs first as an item and then a gift
   * @param n name of item
   * @param c category of item
   * @param p price of item
   * @param u url of item
   * @param ar age range of item
   *
   */
   gift(String n, String c, double p, String u, String ar){
      super(n, c, p, u);
      ageRange=ar;
   }
   /**
   * Constructs first as an item and then a gift
   * @param n name of item
   * @param c category of item
   * @param p price of item
   * @param u url of item
   * @param ar age range of item
   * @param r name recipient
   *
   */
   gift(String n, String c, double p, String u, String ar, String r){
      super(n, c, p, u);
      ageRange = ar;
      recipient = r;
   }
   
   //Getters
   /**
   * Returns age range
   * @return age range
   */
   public String getAgeRange(){
      return ageRange;   
   }  
   
   /*
   * Returns the name of the recipient
   * @return recipient
   */
   public String getRecipient(){
      return recipient;
   }
   
   //Setters
   /*
   * sets the age range 
   * @param age range
   */
   public void setAgeRange(String ar){
      ar = ageRange;   
   }
   
   /*
   * sets the recipient name
   * @param recipient name
   */
   public void setRecipient(String r){
      recipient = r;
   }
}