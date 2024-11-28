package src;

import java.util.Scanner;

public class Color {
    // Codes ANSI pour les couleurs du texte
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static String colorChoice(Player player){
        // affichage des couleurs disponibles
        Scanner colorScanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Available colors :");
        System.out.println(Color.RED + "1. Red" + Color.RESET);
        System.out.println(Color.GREEN + "2. Green" + Color.RESET);
        System.out.println(Color.YELLOW + "3. Yellow" + Color.RESET);
        System.out.println(Color.BLUE + "4. Blue" + Color.RESET);
        System.out.println(Color.PURPLE + "5. Purple" + Color.RESET);
        System.out.println(Color.CYAN + "6. Cyan" + Color.RESET);
        System.out.print("chose " + player.name + " color : ");
        int color = colorScanner.nextInt();
        if (color == 1){
            return Color.RED;
        } else if (color == 2){
            return Color.GREEN;
        } else if (color == 3){
            return Color.YELLOW;
        } else if (color == 4){
            return Color.BLUE;
        } else if (color == 5){
            return Color.PURPLE;
        } else if (color == 6){
            return Color.CYAN;
        } else {
            System.out.println("Please enter a valid number.");
            return colorChoice(player);
        }
    }

    //debug affichage des couleurs
    public static void colorDebug(String[] args) {
        System.out.println(RED + "Texte en rouge" + RESET);
        System.out.println(GREEN + "Texte en vert" + RESET);
        System.out.println(YELLOW + "Texte en jaune" + RESET);
        System.out.println(BLUE + "Texte en bleu" + RESET);
        System.out.println(PURPLE + "Texte en violet" + RESET);
        System.out.println(CYAN + "Texte en cyan" + RESET);
    }
}
