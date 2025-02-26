
/*
 * What is the output of the following program (and why)?

class Item {
   private int value;
   public void setValue(int value) {
       alue = value;
   }
   public int getValue() {
       return value;
   }
}

public class ThisDemo {
   public static void main(String[] args) {
       Item myItem = new Item();
       System.out.print(myItem.getValue() + " | ");
       myItem.setValue(13);
       System.out.println(myItem.getValue());
   }
}

How would you change the program so that the output becomes  0 | 13 ?
 * 
 * 
 * 
 */

 
 /*
  * The output of the program is 0 | 0. This is because the setValue method is setting the value of the parameter value to itself, rather thing using "this.value" to set the value of the instance variable.
    To change the program so that the output becomes 0 | 13, you would need to change the setValue method to use "this.value" to set the value of the instance variable. 
  */

