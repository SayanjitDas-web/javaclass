import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class class17 {
    public static void main(String[] args) {
        // try{
        // File file = new File("example.txt");
        // if(file.createNewFile()){
        // System.out.println("file created: "+file.getName());
        // }else{
        // System.out.println("file already existed!");
        // }
        // }catch(IOException e){
        // System.out.println("Error to create file");
        // }
        // try{
        // FileWriter writer = new FileWriter("example.txt",true);
        // writer.write("\nthis is test text using java 5");
        // writer.close();
        // System.out.println("content write to the file");
        // }catch(IOException e){
        // System.out.println("Error to create file");
        // }
        File file = new File("example.txt");

        String newData = "";
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                newData +=(data + "\n");
            }
            if (newData.contains("this is test text using java 3")) {
                String updatedData = newData.replace("this is test text using java 3","");
                newData = updatedData;
            }
            System.out.println(newData);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(newData);
                System.out.println("data updated successfully!");
            } catch (IOException e) {
                System.err.println("Error while updating the data!");
            }
        } catch (FileNotFoundException e) {
            System.err.println("error while reading the file!");
        }
        // File file = new File("example.txt");
        // if(file.delete()){
        // System.out.println("file is deleted: " + file.getName());
        // }else{
        // System.err.println("file not deleted!");
        // }
    }
}
