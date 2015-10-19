import com.apple.eawt.AppEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;


/**
 * Created by landonkail on 10/19/15.
 */
public class People {
    public static void main(String[] args) throws FileNotFoundException {
        String peopleFile = "people.csv";
        File file = new File(peopleFile);
        Scanner scanner = new Scanner(file);
        HashMap<String, ArrayList<Person>> table = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            if (!columns[0].equals("id")) {
                String id = columns[0];
                String firstName = columns[1];
                String lastName = columns[2];
                String email = columns[3];
                String country = columns[4];
                String ip = columns[5];

                String countryName = String.valueOf(columns[4]);
                Person newPersonConstructor = new Person(id, firstName, lastName, email, country, ip);

                ArrayList<Person> newPersonList = table.get(countryName);

                if (newPersonList == null) {
                    newPersonList = new ArrayList<>();
                    newPersonList.add(newPersonConstructor);
                    table.put(countryName, newPersonList);
                } else {
                    newPersonList.add(newPersonConstructor);
                }
            }
        }

        for (Map.Entry <String, ArrayList < Person>> list : table.entrySet()) {
            Collections.sort(list.getValue());
            System.out.println(list.getValue());
        }

    }
}


