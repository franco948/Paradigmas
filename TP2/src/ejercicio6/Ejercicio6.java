package ejercicio6;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Ejercicio6 {

    public static void merge(String path1, String path2, String destino) throws FileNotFoundException, IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(destino));
        BufferedReader reader1 = new BufferedReader(new FileReader(path1));
        Map<String, String> archivo2 = cargar(path2);
        Set<String> keys = archivo2.keySet();

        String line = reader1.readLine();

        while (line != null) {

            System.out.println(line);

            // BufferedReader reader2 = new BufferedReader(new FileReader(archivo2));

            // String line2 = reader2.readLine();

            String[] claveValor = line.split(",");

            for (String key : keys) {
                if (key.equals(claveValor[0])) {
                    String lineToWrite = key + "," + claveValor[1] + "," + archivo2.get(key) + System.lineSeparator();

                    writer.write(lineToWrite);
                }
            }


            /*while (line2 != null) {

                String[] claveValor2 = line2.split(",");

                if (claveValor[0].equals(claveValor2[0])) {

                    String newLine = claveValor[0] + "," + claveValor[1] + "," + claveValor2[1] + System.lineSeparator();

                    writer.write(newLine);
                }

                line2 = reader2.readLine();
            }

            line = reader1.readLine();

            reader2.close();*/

            line = reader1.readLine();
        }

        writer.flush();

        reader1.close();
        writer.close();
    }

    public static Map<String, String> cargar(String path) throws FileNotFoundException, IOException {

        Map<String, String> archivo = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            archivo.put(split[0], split[1]);

            line = reader.readLine();
        }

        reader.close();

        return archivo;
    }
}
