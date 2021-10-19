import java.io.*;
/**
*@author Michael Suehle
*/
public class item implements Serializable{ //class with fields, constructors, and methods CHECK
                                           //Serializable needed for file I/O
   String name;     //Instance Variables (fields)
   String category;
   double price;
   String url;
   
   /**
   *Default constructor that sets all strings to "" and price to 0.0
   */                 //Constructors
   item(){
   /**Default*/
      name="";
      category="";
      price=0.0;
      url="";
   }
   /**
   * 
   * @param n name of item
   *
   */
   item(String n){
      name=n;
      category="";
      price=0.0;
      url="";
   }
   /**
   *
   * @param n name of item
   * @param c category of item
   *
   */
   item(String n, String c){
      name=n;
      category=c;
      price=0.0;
      url="";
   }
   /**
   *
   * @param n name of item
   * @param c category of item
   * @param p price of item
   *
   */
   item(String n, String c, double p){
      name=n;
      category=c;
      price=p;
      url="";
   }
   /**
   * 
   * @param n name of item
   * @param c category of item
   * @param p price of item
   * @param u url of item
   *
   */
   item(String n, String c, double p, String u){
      name=n;
      category=c;
      price=p;
      url=u;
   }
   /**
   * 
   * @param i item object
   *
   */
   item(item i){
      this(i.name, i.category, i.price, i.url);
   }
   /**
   *@return name 
   */                                       //Getters
   public String getName(){
      return name;
   }                                   
   /**
   *@return category 
   */ 
   public String getCategory(){
      return category;
   }
   /**
   *@return price 
   */ 
   public double getPrice(){
      return price;
   }
   /**
   *@return url 
   */  
   public String getUrl(){
      return url;   
   }
                                    //Mutators
   /**
   *@param n name
   */ 
   public void setName(String n){
      n = name;
   }                                   
   /**
   *@param c category
   */ 
   public void setCategory(String c){
      c = category;
   }
   /**
   *@param p price
   */ 
   public void setPrice(double p){
      p = price;
   }
   /**
   *@param u url 
   */ 
   public void getUrl(String u){
      u = url;
   }
   

   /**
   *@return a string with name, category, price, and url of item
   */
   public String toString(){
      return "Name: "+name+"\nCategory: "+category+"\nPrice: "+price+"\nUrl:"+url;
   }

}