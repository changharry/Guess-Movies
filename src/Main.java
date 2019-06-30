import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File movies = new File("movies.txt");
        Scanner scanner = new Scanner(movies);
        ArrayList list = new ArrayList();
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            list.add(str);
        }
        int random = (int)(Math.random() * list.size());
        String randomName = (String) list.get(random);
        //start game
        Game game = new Game(randomName);
        game.init();
        while (!game.won() && game.getErrorNum() < 10) {
            game.GameStart();
        }
        if (game.getErrorNum() >= 10) {
            System.out.println("Game Over!");
        } else {
            System.out.println("Bingo!");
        }
    }
}
