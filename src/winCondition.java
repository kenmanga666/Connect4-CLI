package src;
public class winCondition {
    //Méthode de vérification de victoire
    public static boolean winCheck(Grid gameGrid, String player, char playerToken) {
    
        // Vérification des lignes
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLUMNS - 3; j++) {
                if (gameGrid.grid[i][j] == playerToken && gameGrid.grid[i][j + 1] == playerToken &&
                    gameGrid.grid[i][j + 2] == playerToken && gameGrid.grid[i][j + 3] == playerToken) {
                    return true;
                }
            }
        }
    
        // Vérification des colonnes
        for (int i = 0; i < Grid.COLUMNS; i++) {
            for (int j = 0; j < Grid.ROWS - 3; j++) {
                if (gameGrid.grid[j][i] == playerToken && gameGrid.grid[j + 1][i] == playerToken &&
                    gameGrid.grid[j + 2][i] == playerToken && gameGrid.grid[j + 3][i] == playerToken) {
                    return true;
                }
            }
        }
    
        // Vérification des diagonales (\)
        for (int i = 0; i < Grid.ROWS - 3; i++) {
            for (int j = 0; j < Grid.COLUMNS - 3; j++) {
                if (gameGrid.grid[i][j] == playerToken && gameGrid.grid[i + 1][j + 1] == playerToken &&
                    gameGrid.grid[i + 2][j + 2] == playerToken && gameGrid.grid[i + 3][j + 3] == playerToken) {
                    return true;
                }
            }
        }
    
        // Vérification des diagonales (/)
        for (int i = 0; i < Grid.ROWS - 3; i++) {
            for (int j = 3; j < Grid.COLUMNS; j++) {
                if (gameGrid.grid[i][j] == playerToken && gameGrid.grid[i + 1][j - 1] == playerToken &&
                    gameGrid.grid[i + 2][j - 2] == playerToken && gameGrid.grid[i + 3][j - 3] == playerToken) {
                    return true;
                }
            }
        }
        return false;
    }

    // Méthode pour vérifier si la grille est pleine
    public static boolean gridFull(Grid gameGrid) {
        for (int i = 0; i < Grid.ROWS; i++) {
            for (int j = 0; j < Grid.COLUMNS; j++) {
                if (gameGrid.grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void gameEnded(Player playerinturn, Player player1, Player player2) {
        player1.gamesPlayed += 1;
        player2.gamesPlayed += 1;
        if (playerinturn.number == 1) {
            player1.score += 1;
        } else {
            player2.score += 1;
        }
    }
}