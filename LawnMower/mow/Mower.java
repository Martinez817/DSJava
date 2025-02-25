package mow;

public class Mower {
    int x; 
    int y; 
    int dir; 

    public Mower(int x, int y, int dir){
        this.x = x; 
        this.y = y; 
        this.dir = dir; 
    }

    public int getX(){
        return x; 
    }

    public void setX(int x){
        this.x = x; 
    }

    public int getY(){
        return y; 
    }

    public void setY(int y){
        this.y = y; 
    }

    public void getDir(int dir){
        this.dir = dir; 
    }

    public void move(){
        if (dir == 0 ){
            y--; 
        } else if (dir == 1){
            x++; 
        } else if (dir == 2){
            y++; 
        } else if (dir == 3){
            x--; 
        }

        
    }

    public boolean checkInFront(Yard yard){
        int r = y; 
        int c = x; 

        if (dir == 0 ){
            r--; 
        } else if (dir == 1){
            c++; 
        } else if (dir == 2){
            r++; 
        } else if (dir == 3){
            c--; 
        }

        char value = yard.getValue(r,c); 
        if (value == '+'){
            return true; 

        } else {
            return false; 
        }

    }

    public char getArrow(){
        if (dir == 0){
            return '^'; 
        } else if (dir == 1){
            return '>'; 
        } else if (dir == 2){
            return 'v'; 
        } else {
            return '<'; 
        }
    }

    public void mow(Yard yard){
        yard.setValue(' ', this.y, this.x); 
    }






}
