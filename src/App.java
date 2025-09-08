import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        readFile(map);
        // for (String key : map.keySet()) {
        //     System.out.println(key + ": " + map.get(key));
        // }
        System.out.println("Benvenuti! Study your flashcards here.");
        System.out.println("1. Add new flashcard");
        System.out.println("2. Print flashcards");

        int choice = scan.nextInt();
        if (choice > 3) {
            System.out.println("Invalid choice");
        }
        if (choice <= 0) {
            System.out.println("Invalid choice");
        }
        if (choice == 1) {
            addEntry(map);
        }
    }

    static void readFile(HashMap<String, String> map) {
        try {
            File it = new File("italian.txt");
            File en = new File("english.txt");
            Scanner itScan = new Scanner(it);
            Scanner enScan = new Scanner(en);
            while ((itScan.hasNextLine()) && (enScan.hasNextLine())) {
                String itLine = itScan.nextLine();
                String enLine = enScan.nextLine();
                map.put(itLine, enLine);
            }
            itScan.close();
            enScan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void addEntry(HashMap<String, String> map) {
        System.out.println("Parola in italiano: ");
        Scanner inp = new Scanner(System.in);
        String it = inp.nextLine();
        System.out.println("Parola in inglese: ");
        String en = inp.nextLine();
        try (BufferedWriter write = new BufferedWriter(new FileWriter("italian.txt", true))) {
            write.newLine();
            write.write(it);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter write = new BufferedWriter(new FileWriter("english.txt", true))) {
            write.newLine();
            write.write(en);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        inp.close();
        map.put(it, en);
    }

    static void printFlashcards(HashMap<String, String> map) {

    }
}
