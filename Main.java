package dev.azmeal;

import java.util.Scanner;

public class Main {
    private static Card[][] cards = new Card[4][4];

    public static void main(String[] args) {
        cards[0][0] = new Card('E');
        cards[0][1] = new Card('A');
        cards[0][2] = new Card('B');
        cards[0][3] = new Card('F');
        cards[1][0] = new Card('G');
        cards[1][1] = new Card('A');
        cards[1][2] = new Card('D');
        cards[1][3] = new Card('H');
        cards[2][0] = new Card('F');
        cards[2][1] = new Card('C');
        cards[2][2] = new Card('D');
        cards[2][3] = new Card('H');
        cards[3][0] = new Card('E');
        cards[3][1] = new Card('G');
        cards[3][2] = new Card('B');
        cards[3][3] = new Card('C');

        gameBoard();
        do {
            gameBoard();
            guess();
        } while (isGameFinished());
    }

    public static void guess() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the indexes: ");
        int i = scanner.nextInt(); // index i
        int j = scanner.nextInt(); // index j
        System.out.print("\nEnter the char: ");
        char car = scanner.next().charAt(0);
        if (cards[i][j].getValue() == car) {
            cards[i][j].setGuess(true);
        } else {
            System.out.println("Wrong guess.");
        }
    }

    public static boolean isGameFinished() {
        for (Card[] kart : cards) {
            for (Card kar : kart) {
                if (!kar.isGuess()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void gameBoard() {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if (cards[i][j].isGuess()) {
                    System.out.print(" | " + cards[i][j].getValue() + " | ");
                } else {
                    System.out.print(" | x | ");
                }
            }
            System.out.println();
        }
    }


}
