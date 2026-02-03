import java.util.*;

public class class09 {
    public static void main(String[] args) {
        // // Map - Hash Map, Tree Map, Linked Hash Map
        // HashMap<Integer,String> student = new HashMap<>();
        // student.put(3, "Sayan");
        // student.put(1, "Niladri");
        // student.put(2, "Ritam");
        // for (Integer key : student.keySet()) {
        //     System.out.println(key+" : "+student.get(key));
        // }
        // // System.out.println(student.values());
        // // System.out.println(student.keySet());
        HashSet<String> cityName = new HashSet<>();
        cityName.add("Kolkata");
        cityName.add("Mumbai");
        cityName.add("delhi");
        cityName.add("hydrabad");
        cityName.add("Kolkata");
        System.out.println(cityName);
        System.out.println(cityName.contains("delhi"));
        cityName.remove("delhi");

        HashSet<String> cityName2 = new HashSet<>();
        cityName2.add("Surat");
        cityName2.add("Grurugram");
        cityName2.add("Noida");
        cityName2.add("Kolkata");
        cityName2.add("Mumbai");

        HashSet<String> intersection = new HashSet<>(cityName);
        intersection.retainAll(cityName2);
        System.out.println(intersection);

        HashSet<String> union = new HashSet<>(cityName);
        union.addAll(cityName2);
        System.out.println(union);
    }
}

// 1) Create a HashSet<String> for storing unique city names:
// Add 5 cities (with some duplicates).
// Print the set.
// Check if a city exists.
// Remove a city.

// 2)Write a program to find the union and intersection of two sets.

