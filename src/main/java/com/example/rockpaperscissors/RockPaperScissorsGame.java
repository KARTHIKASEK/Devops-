package com.example.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    // Enum for the game choices
    enum Choice {
        ROCK, PAPER, SCISSORS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock, Paper, Scissors Game!");
        System.out.println("Choose one: ROCK, PAPER, SCISSORS");

        // Loop until the user wants to exit
        while (true) {
            // User's input
            System.out.print("Enter your choice (or 'exit' to quit): ");
            String userInput = scanner.nextLine().toUpperCase();

            // If the user wants to exit
            if (userInput.equals("EXIT")) {
                System.out.println("Thank you for playing!");
                break;
            }

            // Validate user input
            Choice userChoice;
            try {
                userChoice = Choice.valueOf(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input, please choose ROCK, PAPER, or SCISSORS.");
                continue;
            }

            // Computer's random choice
            Choice computerChoice = Choice.values()[random.nextInt(3)];

            // Display choices
            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner
            String result = getResult(userChoice, computerChoice);
            System.out.println(result);
        }

        scanner.close();
    }

    // Method to determine the result
    private static String getResult(Choice userChoice, Choice computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a draw!";
        }

        switch (userChoice) {
            case ROCK:
                return (computerChoice == Choice.SCISSORS) ? "You win!" : "You lose!";
            case PAPER:
                return (computerChoice == Choice.ROCK) ? "You win!" : "You lose!";
            case SCISSORS:
                return (computerChoice == Choice.PAPER) ? "You win!" : "You lose!";
            default:
                return "Invalid choice!";
        }
    }
}
