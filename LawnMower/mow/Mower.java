package mow;

import java.util.Random;

public class Mower {
    int x;
    int y;
    int dir;
    Random rand = new Random();

    public Mower(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getDir() { return dir; }
    public void setDir(int dir) { this.dir = dir; }

    public void move(Yard yard) {
        int nextX = x, nextY = y;
        if (dir == 0) nextY--;
        else if (dir == 1) nextX++;
        else if (dir == 2) nextY++;
        else if (dir == 3) nextX--;

        if (yard.isValidPosition(nextY, nextX) && yard.getValue(nextY, nextX) != 'R') {
            x = nextX;
            y = nextY;
            mow(yard);
        }
    }

    public boolean checkInFront(Yard yard) {
        int nextX = x, nextY = y;
        if (dir == 0) nextY--;
        else if (dir == 1) nextX++;
        else if (dir == 2) nextY++;
        else if (dir == 3) nextX--;

        return yard.isValidPosition(nextY, nextX) && yard.getValue(nextY, nextX) == '+';
    }

    public char getArrow() {
        return (dir == 0) ? '^' : (dir == 1) ? '>' : (dir == 2) ? 'v' : '<';
    }

    public void mow(Yard yard) {
        yard.setValue(' ', this.y, this.x);
    }

    public void right() {
        dir = (dir + 1) % 4;
    }

    public void left() {
        dir = (dir + 3) % 4;
    }

    private boolean checkDirection(Yard yard, int direction) {
        int nextX = x, nextY = y;
        if (direction == 0) nextY--;
        else if (direction == 1) nextX++;
        else if (direction == 2) nextY++;
        else if (direction == 3) nextX--;

        return yard.isValidPosition(nextY, nextX) && yard.getValue(nextY, nextX) == '+';
    }

    public boolean checkForGrassAround(Yard yard) {
        for (int i = 0; i < 4; i++) {
            if (checkDirection(yard, i)) {
                dir = i;
                return true;
            }
        }
        return false;
    }

    public boolean isSafeToMoveForward(Yard yard) {
        int nextX = x, nextY = y;
        if (dir == 0) nextY--;
        else if (dir == 1) nextX++;
        else if (dir == 2) nextY++;
        else if (dir == 3) nextX--;

        return yard.isValidPosition(nextY, nextX) && yard.getValue(nextY, nextX) != 'R';
    }

    public void wanderUntilGrass(Yard yard) {
        while (!yard.isCleared()) {
            printYard(yard);
            delay(500); // Add delay here
            if (checkInFront(yard)) {
                move(yard);
                continue;
            }

            if (isSafeToMoveForward(yard)) {
                move(yard);
                if (checkForGrassAround(yard)) {
                    mow(yard);
                    continue;
                }
            } else {
                if (checkForGrassAround(yard)) {
                    move(yard);
                    mow(yard);
                    continue;
                } else {
                    right();
                }
            }
        }
        printYard(yard); // Print final state
    }

    private void printYard(Yard yard) {
        clearScreen(); // Clear the screen before printing
        for (int i = 0; i < yard.getHeight(); i++) {
            for (int j = 0; j < yard.getWidth(); j++) {
                if (i == y && j == x) {
                    System.out.print(getArrow());
                } else {
                    System.out.print(yard.getValue(i, j));
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Error: Interrupted while sleeping!");
        }
    }
}