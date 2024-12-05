package JAVA;

import java.util.Scanner;

interface Games {

    void startStoryMode(String playerName);
    void startSurvivalMode(String playerName);
}

interface Accept {
    boolean isOption(String input);
}

interface GameActions {
    void startGame(String playerName, int mode);
}

public class MyGame implements Games, Accept, GameActions {  
    private static final Scanner ally = new Scanner(System.in);  

    public static void main(String[] args) {
        MyGame game = new MyGame();

     
        System.out.print("Enter your name: ");
        String playerName = ally.nextLine();  

        String modeInput;
        do {
            
            System.out.println("Press 1 or 2 to select your game mode:");
            System.out.println("1 - Story");
            System.out.println("2 - Survival");
            modeInput = ally.nextLine(); 
            
        
            if (!game.isOption(modeInput)) {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        } while (!game.isOption(modeInput));

       
        int mode = Integer.parseInt(modeInput);

        
        System.out.println("Press P to start playing, " + playerName + ".");
        String startInput = ally.nextLine(); 
        if (startInput.equalsIgnoreCase("P")) {
            game.startGame(playerName, mode);
        } else {
            System.out.println("Invalid input. Game exiting.");
        }
    }

    @Override
    public void startStoryMode(String playerName) {
        System.out.println("Starting Story Mode for " + playerName + "...");
    }

    @Override
    public void startSurvivalMode(String playerName) {
        System.out.println("Starting Survival Mode for " + playerName + "...");
    }

    @Override
    public boolean isOption(String input) {
        return input.equals("1") || input.equals("2");
    }

    @Override
    public void startGame(String playerName, int mode) {
        if (mode == 1) {
            startStoryMode(playerName);
        } else if (mode == 2) {
            startSurvivalMode(playerName);
        }
    }
}
