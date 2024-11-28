package src;

import java.util.Scanner;

public class Puissance4 {
    // Méthode principale
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Création des joueurs
        Player player1 = new Player("", ' ', "", 1);
        Player player2 = new Player("", ' ', "", 2);
        // Appel de la méthode de jeu
        playGame(scanner, player1, player2);
        // Fermer le scanner à la fin du programme
        scanner.close();
    }

    // Méthode de jeu
    public static void playGame(Scanner scanner, Player player1, Player player2) {
        Clear.clearTerminal();
        System.out.println("Welcome to this connect 4 game !");
        System.out.println();
        if (player1.name != "") { // vérifie si le joueur existe déjà, si oui propose de changer ses informations
            System.out.println("Do you want to change player 1 informations ?");
            System.out.println("current player 1 : " + player1.color + player1.name + Color.RESET);
            System.out.println(Color.RED + "Be careful" + Color.RESET + ", changing players informations will erase current scores");
            System.out.print("respond by yes or no (y/n) : ");
            if (scanner.nextLine().equalsIgnoreCase("y")) { // si oui, appel de la méthode de création de joueur
                Player.playerCreation(scanner, player1, 1);
            }else { // si non, nettoyage de l'écran et passe à la suite
                Clear.clearTerminal();
            }
        }else { // si le joueur n'existe pas, création du joueur
            Player.playerCreation(scanner, player1, 1);
        }
        if (player2.name != "") { // vérifie si le joueur existe déjà, si oui propose de changer ses informations
            System.out.println("Do you want to change player 2 informations ?");
            System.out.println("current player 2 : " + player2.color + player2.name + Color.RESET);
            System.out.println(Color.RED + "Be careful" + Color.RESET + ", changing players informations will erase current scores");
            System.out.print("respond by yes or no (y/n) : ");
            if (scanner.nextLine().equalsIgnoreCase("y")) { // si oui, appel de la méthode de création de joueur
                Player.playerCreation(scanner, player2, 2);
            }else { // si non, nettoyage de l'écran et passe à la suite
                Clear.clearTerminal();
            }
        }else { // si le joueur n'existe pas, création du joueur
            Player.playerCreation(scanner, player2, 2);
        }
        
        // création et affichage de la grille
        System.out.println("Let's start the game !");
        System.out.println(player1.color + player1.name + "'s turn" + Color.RESET);
        Grid grille = new Grid(); 
        Grid.gridDisplay(grille, player1, player2);
       
        // initialisation du 1er tour
        int playerturn = 1;
        Player player;
        // boucle de jeu
        while (true) {
            // initialisation du joueur en fonction du tour
            if (playerturn == 1) {
                player = player1;
            } else {
                player = player2;
            }
            int column = Grid.columnChoice(scanner); // choix de la colonne
            
            while (Grid.columnCheck(grille, column) == false) { // vérification de la colonne
                System.out.println("This column is full, please try another one.");
                column = Grid.columnChoice(scanner);
            }
            Clear.clearTerminal(); // nettoyage de l'écran
            
            Grid.addToken(grille, column, player.token); // ajout du pion

            Grid.gridDisplay(grille, player1, player2); // affichage de la grille puis du coup joué par le joueur précédent
            System.out.println(player.color + player.name + Color.RESET + " played in column " + column);
           
            // vérification de la victoire du joueur en cours
            if (winCondition.winCheck(grille, player.color, player.token)) {
                System.out.println("The player " + player.color + player.name + Color.RESET + " won ! \n Game ended");
                winCondition.gameEnded(player, player1, player2); //ajout des scores
                break;
            }

            if (winCondition.gridFull(grille)) { // vérifie si la grille est pleine (égalité)
                System.out.println("It's a tie ! \n  Game ended");
                // Ajout des scores
                player1.gamesPlayed += 1;
                player2.gamesPlayed += 1;
                break;
            }
            
            // changement de joueur
            if (playerturn == 1) {
                System.out.println(player2.color + player2.name + "'s turn" + Color.RESET);
                playerturn = 2;
            } else {
                System.out.println(player1.color + player1.name + "'s turn" + Color.RESET);
                playerturn = 1;
            }
        }

        // Propose aux joueurs de rejouer
        System.out.println("Do you want to play again ? (y/n) : ");
        scanner.nextLine(); // Consomme la dernière ligne en attente
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")) { // Si oui
            playGame(scanner, player1, player2); // Relance le jeu
        } else { // Sinon
            // Met fin au programme et affiche les scores
            System.out.println("Thank you for playing !");
            Grid.scoreBoard(player1, player2);
        }
    }
}