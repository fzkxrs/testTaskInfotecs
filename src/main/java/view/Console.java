package view;

import java.io.*;

public class Console {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public void write(String str) throws IOException {
        writer.write(str);
        writer.close();
    }

    public String read () throws IOException {
        String s =  reader.readLine();
        reader.close();
        return s;
    }
}
