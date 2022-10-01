package FamilyTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class FileOutput {

        public static void fileWrite(Collection<Person> coll) {
            File output = new File("output.txt");
            try {
                FileWriter writer = new FileWriter(output);
                for (Person p: coll) {
                    writer.write(p.toString() + " ; ");
                }
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println( e.getMessage());
            }
        }
    }

