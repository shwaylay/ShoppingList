import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
*@author Michael Suehle
*/
public class shoppingList{

   Scanner sc = new Scanner(System.in);
   ArrayList<item> items = new ArrayList<>(); //ArrayList CHECK
   String title;
   
   //Constructors
   /**
   *Default constructor sets title to "" and the list is empty
   */
   shoppingList(){
   /**Default*/
      title = "";
   }
   
   /**
   *@param t String for the title
   */
   shoppingList(String t){
      title = t;
   }
   
   /**
   *@param t String for the title 
   *@param i an ArrayList of items
   */
   shoppingList(String t, ArrayList i){
      title = t;                      
      items = i;
   }
   
   //Setters
   /**
   *@param i ArrayList of items
   */
   public void setItems(ArrayList i){
      items = i;
   }
   /**
   *@param t String for the title
   */
   public void setTitle(String t){
      title = t;
   }
   
   //Getters
   /**
   *@return items the ArrayList of item objects
   */
   public ArrayList getItems(){
      return items;
   }
   /**@return title the title given to the shoppingList*/
   public String getTitle(){
      return title;
   }
   
   //Insertion and Deletion Methods
   
   /**Constructs an item and then adds it to the shopping list*/
   public void addItem(){
      System.out.println("What is the name?");
      String n = sc.nextLine();
      System.out.println("What is the category?");
      String c = sc.nextLine();
      System.out.println("What is the price?");
      double p = Double.parseDouble(sc.nextLine());
      System.out.println("What is the url?");
      String u = sc.nextLine();
      items.add(new item(n, c, p, u));  
   }
   
   /**Constructs a gift and then adds it to the shopping list*/
   public void addGift(){
      System.out.println("What is the name?");
      String n = sc.nextLine();
      System.out.println("What is the category?");
      String c = sc.nextLine();
      System.out.println("What is the price?");
      double p = Double.parseDouble(sc.nextLine());
      System.out.println("What is the url?");
      String u = sc.nextLine();
      System.out.println("What is the age range?");
      String ar = sc.nextLine();
      System.out.println("What is the name of the recipient?");
      String r = sc.nextLine();
      items.add(new gift(n, c, p, u, ar, r)); 
   }
   /**
   *Deletes an item from the list
   *@return boolean that tells if item was deleted
   *
   */
   public boolean deleteItem(){
      System.out.println("Delete which item?\n"+toString());
      String remove=sc.nextLine();
      for(item i : items){//For Loop CHECK
         if(remove.equalsIgnoreCase(i.getName())){
         items.remove(i);
         return true;
         }
      }
      System.out.println("Did not find item");
      return false;
   }
   
   // Sorting Methods
     /**
     *Sorts alphabetically by name
     */
   public void sortByName(){ 
      ArrayList<item> sorted = new ArrayList<>();
         while(items.size()!=1&&items.size()!=0){//while CHECK
            if(items.get(0).getName().compareToIgnoreCase(items.get(1).getName())<0){ //If else CHECK
               sorted.add(items.get(0));
               items.remove(0);
            }
            else if(items.get(0).getName().compareToIgnoreCase(items.get(1).getName())==0){ //CompareToIgnoreCase (String Method) CHECK
               sorted.add(items.get(0));
               sorted.add(items.get(1));
               items.remove(0);
               items.remove(1);
            }
            else
            sorted.add(items.get(1));
            items.remove(1);          
         }
        if(items.size()==1){
           sorted.add(items.get(0));
           }
     items=sorted;
   }
   
   /**Sorts alphabetically by category*/
   public void sortByCategory(){
      ArrayList<item> sorted = new ArrayList<>();
         while(items.size()!=1&&items.size()!=0){
            if(items.get(0).getCategory().compareToIgnoreCase(items.get(1).getCategory())<0){
               sorted.add(items.get(0));
               items.remove(0);
            }
            else if(items.get(0).getCategory().compareToIgnoreCase(items.get(1).getCategory())==0){
               sorted.add(items.get(0));
               sorted.add(items.get(1));
               items.remove(0);
               items.remove(1);
            }
            else
            sorted.add(items.get(1));
            items.remove(1);          
         }
        if(items.size()==1){
           sorted.add(items.get(0));
           }
     items=sorted;
   }
   
   /**Sorts prices from least to greatest*/
   public void sortByPrice(){
      double[] prices = new double[items.size()]; //1-D array CHECK
      ArrayList<item> sorted = new ArrayList<>();
         for(item i : items){
            prices[items.indexOf(i)]=i.getPrice();
         }
      Arrays.sort(prices);
         for(int i=0; i<prices.length; i++){
            sorted.addAll(findPrice(prices[i]));
         }
      items=sorted;
   }
   
    /**
   *Sorts alphabetically by url
   *
   */
   public void sortByUrl(){
      ArrayList<item> sorted = new ArrayList<>();
         while(items.size()!=1&&items.size()!=0){
            if(items.get(0).getUrl().compareToIgnoreCase(items.get(1).getUrl())<0){
               sorted.add(items.get(0));
               items.remove(0);
            }
            else if(items.get(0).getUrl().compareToIgnoreCase(items.get(1).getUrl())==0){
               sorted.add(items.get(0));
               sorted.add(items.get(1));
               items.remove(0);
               items.remove(1);
            }
            else
            sorted.add(items.get(1));
            items.remove(1);          
         }
        if(items.size()==1){
           sorted.add(items.get(0));
           }
     items=sorted;
   }
   
   //Searching Methods
   /**@param p the price being searched for
   * @return results an ArrayList of the prices that match the double
   */
   public ArrayList findPrice(double p){
      ArrayList<item> results = new ArrayList<>();
         for(item i : items){
            if(i.getPrice()==p){
            results.add(i);
            }
         }
      return results;
   }
   
   //Saving, Deleting, and Loading File Methods (Adapted from tutorial on http://beginwithjava.blogspot.com/2011/04/java-file-save-and-file-load-objects.html)
   public void saveList(){//File I/O CHECK
      try{
         FileOutputStream savedList = new FileOutputStream(title+".sav");
         ObjectOutputStream save = new ObjectOutputStream(savedList);
         
         save.writeObject((Object)items);
         save.writeObject((Object)title);
         save.close();
      }
      catch(Exception e){
         System.out.print(e);
      }
   }
   
   public void loadList(){
      try{
         FileInputStream loadedList = new FileInputStream(title+".sav");
         ObjectInputStream load = new ObjectInputStream(loadedList);
         
         items=(ArrayList)load.readObject();
         title = (String)load.readObject();
         load.close();
      }
      catch(Exception e){
         System.out.print(e);
      }
   }
   
   public boolean deleteList(){ //Adapted from https://www.geeksforgeeks.org/delete-file-using-java/
      File del = new File (title+".sav");
      return del.delete();
   }
   // Other
   /**@return s a string of all the items on the list*/
   public String toString(){
      String s = "Name\tCategory\tPrice\tUrl\n";
      for(item i:items){
         s+=i.getName()+"\t"+i.getCategory()+"\t\t"+i.getPrice()+"\t\t"+i.getUrl()+"\n";
      }
      return s;
   }
}