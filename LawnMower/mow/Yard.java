
/*
 * 2/25/25
 * Jonathan Martinez 
 * Sw Design with java 
 * 
 */
package mow; 

public class Yard {
    
    char yard[][]; 
    public Yard(int height, int width) {

        int realHeight = height + 2; 
        int realWidth = width + 2; 

        yard = new char[height + 2][width + 2];
        

        for (int r = 0; r < realHeight;r++){
            for (int c = 0; c < realWidth; c++){
                if (r == 0 || r == realHeight - 1){
                    yard[r][c] = 'R';
                } else if (c == 0 || c == realWidth - 1 ){
                    yard[r][c] = 'R'; 
                } else {
                    yard[r][c] = '+'; 
                }
            }
        }
        
    }



    public char getValue(int r, int c){
       return yard[r][c];
    }

    public void setValue(char value, int r, int c ){
        yard[r][c] = value; 
    }

    public int getHeight(){
        return yard.length; 
    }

    public int getWidth(){
        return yard[0].length; 
    }

    public void print(){
        for (int r = 0; r < getHeight(); r++){
            for (int c = 0; c < getWidth(); c++){
                System.out.print(yard[r][c]); 
            }
            System.out.println();
        }
    }

    public void print(Mower m){
        for (int r = 0; r < getHeight(); r++){
            for (int c = 0; c < getWidth(); c++){
                if (c == m.getX() && r == m.getY() ){
                    System.out.print(m.getArrow()); 
                    
                } else {
                    System.out.print(yard[r][c]); 
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Yard y = new Yard(6,7);
        Mower m = new Mower (1, 1, 0); 
        y.print(m); 




    }
 }

 




 