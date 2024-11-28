package src;

import java.util.Scanner;

public class Grid {
    public char[][] grid;
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;

    // Création de la grille
    public Grid() {
        grid = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++){
                grid[i][j] = '-';
            }
        }
    }

    // Affichage de la grille
    public static void gridDisplay(Grid gamegrid, Player player1, Player player2) {
       for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (gamegrid.grid[i][j] == player1.token) {
                    System.out.print(player1.color + gamegrid.grid[i][j] + Color.RESET + " ");
                } else if (gamegrid.grid[i][j] == player2.token) {
                    System.out.print(player2.color + gamegrid.grid[i][j] + Color.RESET + " ");
                } else {
                    System.out.print(gamegrid.grid[i][j] + " ");
                }
            }
           System.out.println();
        }
        System.out.println("1 2 3 4 5 6 7");
    }

    // Choix de colonne
    public static int columnChoice(Scanner scanner) {
        int chosenColumn;

        do {
            System.out.print("Choose a column (select a number between 1 and 7) : ");

            // Vérifier si l'entrée est un entier
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid column number.");
                scanner.next(); // Consommer l'entrée invalide
            }

            chosenColumn = scanner.nextInt();

            // Vérifier si la colonne est dans la plage valide (1 à 7)
            if (chosenColumn < 1 || chosenColumn > 7) {
                System.out.println("Please enter a valid column number. (between 1 and 7).");
            }

        } while (chosenColumn < 1 || chosenColumn > 7);

        System.out.println("You have chosen the column " + chosenColumn + ".");

        return chosenColumn;
    }

    // Ajout d'un pion
    public static void addToken(Grid gamegrid, int chosencolumn, char playerToken) {
        for (int i = ROWS - 1; i >= 0; i--) {
            for (int j = COLUMNS; j >= 0; j--) {
                if (j == chosencolumn-1 && gamegrid.grid[i][j] == '-') {
                    gamegrid.grid[i][j] = playerToken;
                    return;
                }
            }
        }
    }

    // Méthode pour vérifier si une colonne est remplie
    public static boolean columnCheck(Grid gameGrid, int chosenColumn) {
        for (int i = 0; i < ROWS; i++) {
            if (gameGrid.grid[i][chosenColumn-1] == '-') {
                return true;
            }
        }
        return false;
    }

    // Affichage Tableau des scores
    public static void scoreBoard(Player player1, Player player2) {
        System.out.println("Scoreboard :");
        System.out.println("Player | Victories | Games played");
        System.out.println("--------------------");
        System.out.println(player1.color + player1.name + Color.RESET + " | " + 
                           player1.score + " victories" + " | " + player1.gamesPlayed);
        System.out.println("--------------------");
        System.out.println(player2.color + player2.name + Color.RESET + " | " + 
                           player2.score + " victories" + " | " + player2.gamesPlayed);
        System.out.println("--------------------");
    }
}