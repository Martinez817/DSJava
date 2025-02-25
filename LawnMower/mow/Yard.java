package mow;

public class Yard {
    
    char yard[][]; 
    
    public Yard(int height, int width) {
        yard = new char[height + 2][width + 2]; 
        
        for (int r = 0; r < yard.length; r++) {
            for (int c = 0; c < yard[r].length; c++) {
                if (r == 0 || r == yard.length - 1 || c == 0 || c == yard[r].length - 1) {
                    yard[r][c] = 'R'; 
                } else {
                    yard[r][c] = '+'; 
                }
            }
        }
    }

    public char getValue(int r, int c) {
        return yard[r][c];
    }

    public void setValue(char value, int r, int c) {
        yard[r][c] = value; 
    }

    public int getHeight() {
        return yard.length; 
    }

    public int getWidth() {
        return yard[0].length; 
    }

    public void print() {
        for (int r = 0; r < getHeight(); r++) {
            for (int c = 0; c < getWidth(); c++) {
                System.out.print(yard[r][c]); 
            }
            System.out.println();
        }
    }

    public void print(Mower m) {
        for (int r = 0; r < getHeight(); r++) {
            for (int c = 0; c < getWidth(); c++) {
                if (c == m.getX() && r == m.getY()) {
                    System.out.print(m.getArrow()); 
                } else {
                    System.out.print(yard[r][c]); 
                }
            }
            System.out.println();
        }
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < getHeight() && col >= 0 && col < getWidth() && yard[row][col] != 'R'; 
    }

    public boolean isCleared() {
        for (int r = 0; r < getHeight(); r++) {
            for (int c = 0; c < getWidth(); c++) {
                if (yard[r][c] == '+') {  
                    return false; 
                }
            }
        }
        return true; 
    }

    public boolean isClearAround(Mower m) {
        int x = m.getX();
        int y = m.getY();
        return yard[y - 1][x] == '+' && yard[y + 1][x] == '+' && yard[y][x - 1] == '+' && yard[y][x + 1] == '+';
    }

    public static void main(String[] args) {
        Yard y = new Yard(6, 7);
        Mower m = new Mower(1, 1, 0); 
        y.print(m); 
    }
}