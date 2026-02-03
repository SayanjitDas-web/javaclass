package MyDB;
package MyDB; // declare this class belongs to the MyDB package

/*
 * Simple file-based database helper.
 * Stores records as CSV lines in a single text file: id,timestamp,data
 * Each operation reads or appends to the file in the workspace `db/` directory.
 */

// import for generating universally unique identifiers for records
import java.util.UUID;
// import for creating timestamp values for each record
import java.util.Date;
// import for file and directory handling
import java.io.File;
// import for writing strings into files
import java.io.FileWriter;
// import for reading files line-by-line
import java.util.Scanner;
// import for general IO exception handling
import java.io.IOException;
// import for the specific case when a file is not found while reading
import java.io.FileNotFoundException;

public class DB {
    // default relative path where DB files are stored
    private String path = "db/";
    // default file name to store the CSV records
    private String fileName = "db.txt";

    /**
     * Constructor that allows overriding the storage path.
     * If the provided path is not empty, use it; then ensure directories and file exist.
     */
    public DB(String path) {
        // if caller provided a non-empty path, override the default path
        if (path.length() != 0) {
            this.path = path;
        }
        try {
            // create a File object pointing to the db file path
            File db = new File(this.path + "/" + this.fileName);
            // make parent directories (no-op if they already exist)
            db.getParentFile().mkdirs();
            // create the file itself if it doesn't already exist; returns true when created
            if (db.createNewFile()) {
                // print a success message when the file was newly created
                System.out.println("Database created successfully!");
            }
        } catch (IOException err) {
            // print an error message if any IO operation fails
            System.err.println("error while creating the database: " + err.getMessage());
        }
    }

    /**
     * Append a new record to the database file.
     * Each record is written as: <uuid>,<timestamp>,<data>
     */
    public void Add(String data) {
        // build the full path to the DB file
        String filePath = this.path + "/" + this.fileName;
        // create a new UUID string to uniquely identify the record
        String id = UUID.randomUUID().toString();
        // get the current date/time for the timestamp
        Date now = new Date();
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // write a newline then the CSV record (id,timestamp,data)
            writer.write("\n" + id + "," + now + "," + data);
        } catch (IOException err) {
            // log failure to append the record
            System.err.println("failed to add data: " + err.getMessage());
        }
    }

    /**
     * Delete a single record by its id.
     * The method reads all lines, filters out the matching id, and rewrites the file.
     */
    public void Delete(String id) {
        // full path to the database file
        String filePath = this.path + "/" + this.fileName;
        // File object used for reading and writing
        File db = new File(filePath);
        try {
            // buffer to accumulate kept records
            StringBuilder updatedData = new StringBuilder();
            try (Scanner reader = new Scanner(db)) {
                // iterate each line in the file
                while (reader.hasNextLine()) {
                    // read the next record line
                    String data = reader.nextLine();
                    // skip empty lines
                    if(data.isEmpty()) continue;
                    // split line into at most 3 parts: id, timestamp, data
                    String[] parts = data.split(",",3);
                    // if the id does not match, keep the line
                    if(!parts[0].equals(id)){
                        updatedData.append(data).append("\n");
                    }else{
                        // report that we removed the matching record
                        System.out.println("Deleted record with Id: " + id);
                    }
                }
            }
            // overwrite the original file with the filtered content
            try(FileWriter writer = new FileWriter(db)){
                writer.write(updatedData.toString());
            }
        } catch (FileNotFoundException e) {
            // file not found when attempting to read
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // generic IO exception while writing
            System.err.println(e.getMessage());
        }
    }

    /**
     * Update the 'data' field of an existing record identified by id.
     * Preserves id and timestamp, replaces the third CSV field.
     */
    public void Update(String id, String newdata) {
        // compute the DB file path
        String filePath = this.path + "/" + this.fileName;
        // File handle for reading/writing
        File db = new File(filePath);
        try {
            // accumulator for the rewritten file content
            StringBuilder updatedData = new StringBuilder();
            try (Scanner reader = new Scanner(db)) {
                while (reader.hasNextLine()) {
                    // read next line
                    String data = reader.nextLine();
                    // skip blank lines
                    if(data.isEmpty()) continue;
                    // split into id, timestamp and the rest (data)
                    String[] parts = data.split(",",3);
                    // if this is the target record, rebuild with new data
                    if(parts[0].equals(id)){
                        String updatedNewData = parts[0] + "," + parts[1] + "," + newdata;
                        updatedData.append(updatedNewData).append("\n");
                    }else{
                        // otherwise keep the original line
                        updatedData.append(data).append("\n");
                    }
                }
            }
            // write the updated content back to the file
            try(FileWriter writer = new FileWriter(db)){
                writer.write(updatedData.toString());
            }
        } catch (FileNotFoundException e) {
            // file missing when reading
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // other IO errors
            System.err.println(e.getMessage());
        }
    }

    /**
     * Retrieve the raw CSV line for a record with the given id.
     * Returns empty string when no matching record exists.
     */
    public String Get(String id) {
        // path to DB file
        String filePath = this.path + "/" + this.fileName;
        // File object pointing to the database file
        File db = new File(filePath);
        // default return value when not found
        String targetData = "";
        try {
            try (Scanner reader = new Scanner(db)) {
                while (reader.hasNextLine()) {
                    // read each line
                    String data = reader.nextLine();
                    // skip empty lines
                    if(data.isEmpty()) continue;
                    // separate into id,timestamp,data
                    String[] parts = data.split(",",3);
                    // when id matches, capture the full CSV line
                    if(parts[0].equals(id)){
                        targetData = data;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // handle missing file scenario
            System.out.println(e.getMessage());
        }
        // return the found line or empty string
        return targetData;
    }
}
