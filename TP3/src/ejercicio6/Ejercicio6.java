package ejercicio6;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Ejercicio6 {

    public static void trasponer(String pathEntrada, String pathSalida) throws IOException {

        List<String[]> T = new LinkedList<String[]>();

        BufferedReader reader = new BufferedReader(new FileReader(pathEntrada));
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathSalida));

        String line = reader.readLine();

        while (line != null) {

            String[] row = line.split(",");

            T.add(row);

            line = reader.readLine();
        }

        if ( T.isEmpty() ) throw new IllegalStateException("El archivo esta vacio");

        for (int x = 0; x < T.get(0).length; x++) {

            for (int y = 0; y < T.size(); y++) {

                String lineToWrite = T.get(y)[x];

                if (y != 0) lineToWrite = "," + lineToWrite;

                writer.write(lineToWrite);
            }

            writer.write(System.lineSeparator());
        }

        writer.flush();

        reader.close();
        writer.close();
    }
}
