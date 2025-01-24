/*
 * 1/23/24 
 * Sw Design with java 
 * Jonathan Martinez 
 * 
 */



public class Counter {
    public int look(){
        return count;
    }

    public void click(){
        this.count = this.count +1;
        if (this.count > MAX_COUNT){
            this.count = 0;
        }
    }
    public void reset(){
        count = 0;

    }

    public Counter(){
        
    }
    
    private int count = 0; 
    private int MAX_COUNT = 9999;
}


