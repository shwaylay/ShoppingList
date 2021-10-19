import java.util.Scanner;
import java.util.ArrayList;
/**
*@author Michael Suehle
*/
public class shoppingListUsingKeyboardInput{
   static Scanner sc = new Scanner(System.in);
   static ArrayList<shoppingList> lists = new ArrayList<>();
   
   public static void main(String[]args){
   while(true){
      try{
         System.out.println("Menu:\n(1)Load list\n(2)Create list\n"
                       +"(3)Add to list\n(4)Delete from list\n"
                       +"(5)Display list\n(6)Sort list\n(7)Save\n(8)Exit");
         int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
               case 1:  System.out.println("What is the name of the list?");
                  String x = sc.nextLine();
                  shoppingList i = new shoppingList(x);
                  i.loadList();
                  lists.add(i);
                  break;
                  
               case 2:  System.out.println("What is the title of the list?");
                  String title = sc.nextLine();
                  shoppingList newList = new shoppingList(title);
                  lists.add(newList);
                  break;
                  
               case 3:  System.out.println("Add to which list? "+showLists());
                  String list = sc.nextLine();
                     for(shoppingList s:lists){
                        if(list.equals(s.getTitle())){
                           System.out.println("Is is a gift?(y/n)");
                           String ans=sc.nextLine();
                           if(ans.equalsIgnoreCase("n")){
                           s.addItem();
                           }
                           else if(ans.equalsIgnoreCase("y")){
                           s.addGift();
                           }
                        break;
                        }
                     }
                  break;
               case 4:  System.out.println("Delete from which list? "+showLists());
                  String listchoice = sc.nextLine();
                     for(shoppingList s:lists){
                        if(listchoice.equals(s.getTitle())){
                        s.deleteItem();
                        break;
                        }
                     }
                  break;
                  
               case 5:  System.out.println("Display which list? "+showLists());                     
                  String listselection = sc.nextLine();
                     for(shoppingList s:lists){
                        if(listselection.equals(s.getTitle())){
                        System.out.println(s.toString());
                        break;
                        }
                     }
                  break;
                     
               case 6:  System.out.println("Sort which list? "+showLists());                     
                  String chosenlist = sc.nextLine();
                     for(shoppingList s:lists){
                        if(chosenlist.equals(s.getTitle())){
                        System.out.println("Sort by: (1)Name, (2)Category, "+
                                           "(3)Price, or (4)Url?");
                        int n=Integer.parseInt(sc.nextLine());
                           switch(n){
                              case 1: s.sortByName();
                                    break;
                              case 2: s.sortByCategory();
                                    break;
                              case 3: s.sortByPrice();
                                    break;
                              case 4: s.sortByUrl();
                                    break;
                           }
                        }
                     break;
                     }
                  break;
               case 7:  
                     for(shoppingList s:lists){
                        s.saveList();
                     }
                  break;
               case 8: System.exit(0);
            }
         }
      catch(Exception e){
         System.out.println(e);
      }
      }
   }
   
   public static String showLists(){
      String sL="";
      for(shoppingList s:lists){
         sL+=s.getTitle()+", ";
      }
      return sL;
   }
}