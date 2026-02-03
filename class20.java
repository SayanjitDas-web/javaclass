import MyDB.DB;

public class class20 {
    public static void main(String[] args) {
        DB myDb = new DB("");
        // myDb.Update("7f9f25dc-4cd7-4526-bd4b-82fbde3fc7e3","updated data");
        // myDb.Add("New data added again");
        System.out.println(myDb.Get("d6dc396f-87fa-4fcd-992c-fa13b8ab94d9"));
    }
}
