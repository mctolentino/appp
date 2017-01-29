import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static void displayPathtoPrincess(int n, String [] grid){
        // convert grid to grid
        String[][] convertedGrid = new String[n][n];
        for (int ctr = 0; ctr < grid.length; ctr++) {
            convertedGrid[ctr] = grid[ctr].split("");
        }

        // get bot position
        int botX = n / 2;
        int botY = n / 2;

        // get peach's position
        int peachX = 0;
        int peachY = 0;
        for(int y = 0; y < n; y++) {
            for(int x = 0 ; x < n; x++) {
                if(convertedGrid[y][x].equalsIgnoreCase("p")) {
                    peachX = x;
                    peachY = y;
                    break;
                }
            }
        }

        System.out.println("peachX = " + peachX);
        System.out.println("peachY = " + peachY);
        System.out.println("botX = " + botX);
        System.out.println("botY = " + botY);

        // device movement
        if(botX < peachX) {
            // RIGHT
            while (botX < peachX) {
                System.out.println("RIGHT");
                botX++;
            }
        } else {
            // LEFT
            while (botX > peachX) {
                System.out.println("LEFT");
                botX--;
            }
        }

        if(botY > peachY) {
            // UP
            while (botY > peachY) {
                System.out.println("UP");
                botY--;
            }
        } else {
            // DOWN
            while (botY < peachY) {
                System.out.println("DOWN");
                botY++;
            }
        }



    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        displayPathtoPrincess(m,grid);
    }
}