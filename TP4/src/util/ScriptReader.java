package util;

import java.io.*;

public class ScriptReader {

    private BufferedReader reader;

    public ScriptReader(String path) throws FileNotFoundException {
        reader = new BufferedReader( new FileReader(path) );
    }

    public String readStatement() throws IOException {

        StringBuffer sql = new StringBuffer();
        String line = reader.readLine();

        while (line != null) {

            sql.append(line);

            line = reader.readLine();
        }

        return sql.toString();
    }

    public void close() throws IOException {
        reader.close();
    }
}
