package src;

import java.util.Scanner;

public class Player {
    public String name;
    public char token;
    public String color;
    public int score = 0;
    public int gamesPlayed = 0;
    public int number;

    public Player(String name, char token, String color, int number) {
        this.name = name;
        this.token = token;
        this.color = color;
        this.number = number;
    }

    public static void playerCreation(Scanner scanner, Player player, int number) {
        //choix du pseudo du joueur
        System.out.print("chose player " + number + " pseudonym : ");
        player.name = scanner.nextLine();
        //choix de la couleur du joueur
        player.color = Color.colorChoice(player);
        //choix du jeton du joueur
        System.out.print("chose " + player.name + " token (only one character: a letter or a number): ");
        player.token = scanner.nextLine().charAt(0);
        Clear.clearTerminal();
    }
}
