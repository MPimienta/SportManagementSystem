package views;

import java.util.Scanner;

public class Input {
    private static final int MAX_LENGTH = 2;
    public static String[] readCommand(){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if(input.length > MAX_LENGTH){
            Error.TOO_MANY_ARGUMENTS.writeln();
            return (new String[]{""});
        } else {
            return input;
        }
    }
}
