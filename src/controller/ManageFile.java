
package controller;

import common.Library;
import view.Menu;


public class ManageFile extends Menu<String> {

    static String[] mc = {"Count Word In File", "Find File By Word", "Exit"};
    private Library library = new Library();

    public ManageFile() {
        super("Word Program", mc);
    }

    @Override
    public void executed(int n) {
        switch (n) {
            case 1:
                String path;
                String word;
                path = library.getValue("Enter Path: ");
                word = library.getValue("Enter Word: ");

                int count = library.countWordInFile(path, word);
                System.out.println("Count: " + count);
                break;

            case 2:

                path = library.getValue("Enter Path: ");
                word = library.getValue("Enter Word: ");

                library.getFileNameContainsWordInDirectory(path, word);
                break;
            case 3:
                System.out.println("Program exit");
                System.exit(0);
            default:
                throw new AssertionError();
        }
    }

}
