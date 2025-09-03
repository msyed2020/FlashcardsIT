import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);

    }

    void readFile(HashMap<String, String> map) {
        try {
            File it = new File("italian.txt");
            File en = new File("english.txt");
            Scanner itScan = new Scanner(it);
            Scanner enScan = new Scanner(en);
            while ((itScan.hasNextLine()) && (enScan.hasNextLine())) {
                String line = itScan.nextLine();

            }
            itScan.close();
            enScan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
