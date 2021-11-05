package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int[][] treasure = new int[5][5];
        int amount = 0;
        String guess;
        int score = 0;

        for(int i = 0; i < treasure.length; i++){
            for(int j = 0; j < treasure[i].length; j++){
                treasure[i][j] = random.nextInt(2);
                amount += treasure[i][j];
            }
        }

        for(int i = 0; i < amount; i++){
            System.out.print("Enter coordinates of treasure x,y: ");
            guess = input.next();
            int x = Integer.parseInt(guess.charAt(0)+"") - 1;
            int y = Integer.parseInt(guess.charAt(2)+"")-1;
            if(treasure[x][y] == 1){
                score += 1;
                treasure[x][y] = 2;
                System.out.println("You found a piece of treasure!");
            }else{
                treasure[x][y] = 3;
                System.out.println("You didn't find anything");
            }
            map(treasure);
        }

        System.out.print("Your score is: " + score + "/" + amount);
    }

    public static void map(int[][] treasure){
        String line = "";
        for(int i = treasure.length-1; i >= 0; i--){
            for(int j = 0; j < treasure.length; j++){
                if(treasure[j][i] == 2){
                    line += "O ";
                }else if(treasure[j][i]==3){
                    line += "U ";
                }else {
                    line += "X ";
                }
            }
            line += "\n";
        }
        System.out.println(line);
    }
}