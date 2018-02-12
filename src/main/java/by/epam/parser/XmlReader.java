package by.epam.parser;

import by.epam.parser.exception.CouldNotReadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class XmlReader implements AutoCloseable {
    private BufferedReader reader;
    private List<String> batch = new ArrayList<>();


    public XmlReader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String readLine() throws CouldNotReadException {
        fillBatch();
        if (!batch.isEmpty()) {
            StringBuilder correctLine = new StringBuilder();
            batch.forEach(correctLine::append);
            emptyBatch();
            return correctLine.toString();
        }
        else {
            return null;
        }
    }

    private void fillBatch() throws CouldNotReadException {
        try {
            String s = reader.readLine();
            if (s != null) {
                batch.add(s);
                if (!s.endsWith(">")) {
                    fillBatch();
                }
            }
        } catch (IOException e) {
            throw new CouldNotReadException("ERROR WHILE READING... PLEASE SEE LOG FILES: " + e);
        }
    }

    private void emptyBatch() {
        batch.removeAll(batch);
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }


}
