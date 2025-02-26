
/*
 * What is the output of the following code and why?

   public static void main(String[] args) {
       Customer.lastSerialUsed = 100;
       Customer c1 = new Customer("Sal's Deli");
       c1.addSale(100);
       Customer c2 = c1;
       c2.addSale(50);
       System.out.println(c1.getSales());
       System.out.println(c2.getSales());
   }

 * 
 * 
 */

public class PartC {

}


/* 
 The output of the code is: 

 Sal's Deli: 
 100 
 150 

    This is because the lastSerialUsed is set to 100, and then a new Customer object is created with the name "Sal's Deli". The addSale method is then called on c1,
     which adds 100 to the sales total. c2 is then set to c1, so c2 is also pointing to the same Customer object. The addSale method is then called on c2, which adds 50 to the sales total. 
     Since c1 and c2 are both pointing to the same Customer object, the sales total is updated for both c1 and c2.





*/ 
