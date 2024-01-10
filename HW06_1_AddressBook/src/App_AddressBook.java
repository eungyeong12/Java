import java.util.Set;
import java.util.TreeMap;

public class App_AddressBook {
    public static void main(String[] args) {
        TreeMap<String, Person> addrBook = new TreeMap<String, Person>();
        Person[] persons = {
                new Person("Kim", new TelNum(82, 53, 810, 1000)),
                new Person("Yoon", new TelNum(82, 2, 1234, 5678)),
                new Person("Lee", new TelNum(82, 51, 2579, 1234)),
                new Person("Park", new TelNum(82, 53, 1000, 5678)),
                new Person("Choi", new TelNum(82, 31, 2345, 6789)),
        };
        for (Person p : persons) {
            addrBook.put(p.getName(), p); }
        for (Person p : persons) {
            String nm = p.getName();
            System.out.printf("%5s : %s\n", nm, addrBook.get(nm)); }
        Set<String> keySet_name = addrBook.keySet();
        System.out.printf("keySet_name = %s\n", keySet_name);
        for(String key : keySet_name) {
            System.out.printf("%5s : %s\n", key, addrBook.get(key)); } }
}
