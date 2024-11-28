package src;

public class Clear{
    public static void clearTerminal() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                // Si le système d'exploitation est Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Si le système d'exploitation est autre que Windows (Unix/Linux)
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Gérer les exceptions
            e.printStackTrace();
        }
    }
}