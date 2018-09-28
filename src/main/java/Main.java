import Parser.DOMParser;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("Person.xml");
        DOMParser parser = new DOMParser();
        parser.getData(file);
    }
}
