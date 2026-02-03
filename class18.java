import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

//{"this is test text using java 1","this is test text using java 2"}

public class class18 {
    public static void main(String[] args) {
        File file = new File("example.txt");
        ArrayList<String> newData = new ArrayList<>();
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                newData.add(data);
            }
            newData.remove("this is test text using java 4");
            try (FileWriter writer = new FileWriter("example.txt")) {
               writer.write("");
            } catch (IOException e) {
                System.err.println("error while empty the file");
            }
            newData.forEach((data) -> {
                try (FileWriter writer = new FileWriter("example.txt", true)) {
                   writer.write(data+"\n");
                } catch (IOException e) {
                    System.err.println("error while adding the data");
                }
            });
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }
}
