package ejercicio6;

import java.io.*;

public class Ejercicio6 {

    public static void merge(String archivo1, String archivo2, String destino) throws FileNotFoundException, IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(destino));
        BufferedReader reader1 = new BufferedReader(new FileReader(archivo1));

        String line = reader1.readLine();

        while (line != null) {

            System.out.println(line);

            BufferedReader reader2 = new BufferedReader(new FileReader(archivo2));

            String line2 = reader2.readLine();

            String[] claveValor = line.split(",");

            while (line2 != null) {

                String[] claveValor2 = line2.split(",");

                if (claveValor[0].equals(claveValor2[0])) {

                    String newLine = claveValor[0] + "," + claveValor[1] + "," + claveValor2[1] + System.lineSeparator();

                    writer.write(newLine);
                }

                line2 = reader2.readLine();
            }

            line = reader1.readLine();

            reader2.close();
        }

        writer.flush();

        reader1.close();
        writer.close();
    }
}
