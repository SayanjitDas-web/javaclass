package MyDB;

import java.util.UUID;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DB {
    private String path = "db/";
    private String fileName = "db.txt";

    public DB(String path) {
        if (path.length() != 0) {
            this.path = path;
        }
        try {
            File db = new File(this.path + "/" + this.fileName);
            db.getParentFile().mkdirs();
            if (db.createNewFile()) {
                System.out.println("Database created successfully!");
            }
        } catch (IOException err) {
            System.err.println("error while creating the database: " + err.getMessage());
        }
    }

    public void Add(String data) {
        String filePath = this.path + "/" + this.fileName;
        String id = UUID.randomUUID().toString();
        Date now = new Date();
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("\n" + id + "," + now + "," + data);
        } catch (IOException err) {
            System.err.println("failed to add data: " + err.getMessage());
        }
    }

    public void Delete(String id) {
        String filePath = this.path + "/" + this.fileName;
        File db = new File(filePath);
        // try (FileWriter writer = new FileWriter(filePath)) {
        // writer.write("");
        // } catch (IOException err) {
        // System.err.println("failed to add data: " + err.getMessage());
        // }
        try {
            StringBuilder updatedData = new StringBuilder();
            try (Scanner reader = new Scanner(db)) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    if(data.isEmpty()) continue;
                    String[] parts = data.split(",",3);
                    if(!parts[0].equals(id)){
                        updatedData.append(data).append("\n");
                    }else{
                        System.out.println("Deleted record with Id: " + id);
                    }
                }
            }
         try(FileWriter writer = new FileWriter(db)){
            writer.write(updatedData.toString());
         }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public void Update(String id, String newdata) {
        String filePath = this.path + "/" + this.fileName;
        File db = new File(filePath);
        try {
            StringBuilder updatedData = new StringBuilder();
            try (Scanner reader = new Scanner(db)) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    if(data.isEmpty()) continue;
                    String[] parts = data.split(",",3);
                    if(parts[0].equals(id)){
                        String updatedNewData = parts[0] + "," + parts[1] + "," + newdata;
                        updatedData.append(updatedNewData).append("\n");
                    }else{
                        updatedData.append(data).append("\n");
                    }
                }
            }
         try(FileWriter writer = new FileWriter(db)){
            writer.write(updatedData.toString());
         }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public String Get(String id) {
        String filePath = this.path + "/" + this.fileName;
        File db = new File(filePath);
        String targetData = "";
        try {
            try (Scanner reader = new Scanner(db)) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    if(data.isEmpty()) continue;
                    String[] parts = data.split(",",3);
                    if(parts[0].equals(id)){
                        targetData = data;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return targetData;
    }
}
