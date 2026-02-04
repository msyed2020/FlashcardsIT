import java.util.*;
import java.io.*;

// ohhh

// me my pouch n my kan

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        readFile(map);
        System.out.println("Benvenuti! Study your flashcards here.");
        System.out.println("1. Add new flashcard");
        System.out.println("2. Print flashcards");
        System.out.println("3. Word Quiz");

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
        if (choice == 2) {
            printFlashcards(map);
        }
        if (choice == 3) {
            studyWord(map);
        }
        scan.close();
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
        if (map.containsKey(it)) {
            System.out.println("Word already in flashcards");
            inp.close();
            return;
        }
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
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    static void studyWord(HashMap<String, String> map) {
        int length = 0;
        for (String key : map.keySet()) {
            length++;
        }
        int random = (int) (Math.random() * length);
        // convert to arraylist
        ArrayList<String> ital = new ArrayList<String>();
        for (String key : map.keySet()) {
            ital.add(key);
        }
        // grab key then value
        Collection<String> values = map.values();
        ArrayList<String> eng = new ArrayList<String>(values);
        System.out.println("Translate " + ital.get(random));
        Scanner scan = new Scanner(System.in);
        String ans = scan.nextLine();
        if (ans.equals(eng.get(random))) {
            System.out.println("Correct!");
        }
        else {
            System.out.println("Incorrect! It is actually " + eng.get(random));
        }
        scan.close();
    }
}
