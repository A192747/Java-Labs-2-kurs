import Translator.*;
import Exceptions.*;
public class Main {
    public static void main(String[] args) {
        try {
            Translator translator = new Translator("Files/dictionary.txt");
            String translatedFile = translator.translateFile("Files/input.txt");
            System.out.println(translatedFile);
        } catch (InvalidFileFormatException | FileReadException e) {
            System.out.println(e);
        }

    }

}