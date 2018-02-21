package by.epam.analyzer.reader;

import by.epam.analyzer.reader.ReaderCloseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class XmlReader implements AutoCloseable {
    private static final String XML_VERSION = "<?xml version=\"1.0\"?>";
    private static final String CLOSE_TAG = ">";

    private final List<String> batch = new ArrayList<>();
    private BufferedReader reader;
    private boolean closed;


    public XmlReader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String readLine() throws IOException {
        String line = null;
        fillBatch();
        if (!batch.isEmpty()) {
            StringBuilder correctLine = new StringBuilder();
            batch.forEach(correctLine::append);
            emptyBatch();
            line = correctLine.toString();
        }
        return line;
    }


    private void fillBatch() throws IOException {
        String currentLine = reader.readLine();
        if (currentLine != null) {
            if (currentLine.equalsIgnoreCase(XML_VERSION)) {
                currentLine = reader.readLine();
            }
            batch.add(currentLine.trim());
            if (!currentLine.endsWith(CLOSE_TAG)) {
                fillBatch();
            }
        }
    }

    private void emptyBatch() {
        batch.removeAll(batch);
    }

    @Override
    public void close() throws ReaderCloseException {
        try {
            reader.close();
            closed = true;
        } catch (IOException e) {
            throw new ReaderCloseException();
        }
    }

    public boolean isClosed() {
        return closed;
    }

}
