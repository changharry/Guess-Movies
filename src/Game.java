import java.util.Scanner;

public class Game {

    private boolean won = false;
    private String ans;
    private String name = "";
    private String randomName;
    private int errorCounter = 0;
    private String errorString = "";

    Game(String randomName) {
        this.randomName = randomName;
    }

    void GameStart() {
        System.out.print("You are guessing: ");
        System.out.println(name);
        System.out.println("You have guessed " + "(" + errorCounter + ")" + " wrong letter(s): " + errorString);
        System.out.print("Guess a letter: ");
        Scanner input = new Scanner(System.in);
        ans = input.nextLine();
        checkWrongLetter();
        checkInputValidity();
        updateString();
        checkWon();
    }

    private void updateString() {
        for (int i = 0; i < name.length(); i++) {
            if (ans != null && !ans.isEmpty() && randomName.indexOf(ans) == i) {
                name = name.substring(0,i)+ ans + name.substring(i + 1);
                randomName = randomName.substring(0,i) + "@" + randomName.substring(i + 1);
            }
        }
    }

    void init() {
        for (int i = 0; i < randomName.length(); i++) {
            name = name.concat("_");
            if (randomName.indexOf(" ") == i) {
                name = name.substring(0,i)+ " " + name.substring(i + 1);
                randomName = randomName.substring(0,i) + "@" + randomName.substring(i + 1);
            }
        }
    }

    private void checkWon() {
        if (!name.contains("_")) {
            won = true;
            System.out.print("You are guessing: ");
            System.out.println(name);
        }
    }

    boolean won() {
        return won;
    }

    private void checkInputValidity() {
        if (ans.length() != 1) {
            System.out.println("Invalid Inputs!");
            ans = "";
        }
    }

    private void checkWrongLetter() {
        if (!randomName.contains(ans)) {
            errorCounter++;
            errorString = errorString + ans + ",";
        }
    }

    int getErrorNum() {
        return errorCounter;
    }
}
