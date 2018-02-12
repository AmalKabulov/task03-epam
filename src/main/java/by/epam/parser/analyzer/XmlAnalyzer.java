package by.epam.parser.analyzer;

import by.epam.parser.entity.Node;
import by.epam.parser.entity.Tag;
import by.epam.parser.exception.ParseException;
import by.epam.parser.exception.ReaderCloseException;
import by.epam.parser.reader.XmlReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlAnalyzer {
    private XmlReader reader;

    private TreeMap<Integer, Node> parsedLines = new TreeMap<>();
    private final List<String> conditions;


    {
        conditions = List.of(Tag.OPEN.getValue(),
                Tag.CLOSE.getValue(),
                Tag.SELF_CLOSE.getValue(),
                Tag.TEXT.getValue());
    }

    public XmlAnalyzer(final InputStream inputStream) {
        reader = new XmlReader(inputStream);
    }


    public Node next() throws ParseException, ReaderCloseException {
        Node node = null;
        if (hasNext()) {
            Integer fistParsedResult = parsedLines.firstKey();
            node = parsedLines.get(fistParsedResult);
            parsedLines.remove(fistParsedResult);
            return node;
        }
        return node;
    }


    public boolean hasNext() throws ParseException, ReaderCloseException {
        if (parsedLines.isEmpty()) {
            if (!reader.isClosed()) {
                parseNext();
            }
        }
        return !parsedLines.isEmpty();
    }

    private void parseNext() throws ParseException, ReaderCloseException {
        try {
            String line = reader.readLine();
            if (line == null) {
                reader.close();
                return;
            }
            conditions.forEach(condition -> parseLine(condition, line));
        } catch (IOException e) {
            throw new ParseException("ERROR WHILE PARSING... " + e);
        }
    }


    private void parseLine(final String condition, final String line) {
        Pattern pattern = Pattern.compile(condition);
        Matcher m = pattern.matcher(line);
        if (m.find()) {
            int startIndex = m.start();
            Tag tag = Tag.getByValue(condition);
            String result = m.group().replaceAll("[</>]", "");
            Node node = new Node(tag, result);
            parsedLines.put(startIndex, node);
        }
    }

    public static void main(String[] args) throws ParseException, ReaderCloseException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("sport_equipment_db.xml");
        XmlAnalyzer xmlAnalyzer = new XmlAnalyzer(inputStream);

//        XmlAnalyzer xmlAnalyzer = ReaderFactory.getInstance().getReader("XML", inputStream);

        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());
        System.out.println(xmlAnalyzer.next().toString());


    }


}
