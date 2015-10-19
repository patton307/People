import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by landonkail on 10/19/15.
 */
public class Person implements Comparable {
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String country;
    public String ip;

    public Person(String id, String firstName, String lastName, String email, String country, String ip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ip = ip;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        int result = lastName.compareTo(p.lastName);
        return result;

    }
    @Override
    public String toString() {
        return String.format("%s %s from %s", firstName, lastName, country);
    }
}
