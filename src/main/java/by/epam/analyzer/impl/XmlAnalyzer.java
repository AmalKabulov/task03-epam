package by.epam.analyzer.impl;

import by.epam.analyzer.Analyzer;
import by.epam.analyzer.node.Node;
import by.epam.analyzer.node.NodeType;
import by.epam.analyzer.reader.ReaderCloseException;
import by.epam.analyzer.reader.XmlReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlAnalyzer implements Analyzer {
    private static final String OPEN_AND_CLOSE_TAG = "[</>]";
    private static final String EMPTY = "";
    private XmlReader reader;

    private TreeMap<Integer, Node> parsedLines = new TreeMap<>();
    private final List<String> conditions;


    {
        conditions = List.of(NodeType.OPEN_TAG.getValue(),
                NodeType.CLOSE_TAG.getValue(),
                NodeType.SELF_CLOSE_TAG.getValue(),
                NodeType.TEXT.getValue());
    }

    public XmlAnalyzer(final InputStream inputStream) {
        reader = new XmlReader(inputStream);
    }


    @Override
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


    @Override
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
            NodeType nodeType = NodeType.getByValue(condition);
            String result = m.group().replaceAll(OPEN_AND_CLOSE_TAG, EMPTY);
            Node node = new Node(nodeType, result);
            parsedLines.put(startIndex, node);
        }
    }


    public static void main(String[] args) {
        System.out.println(6^3);
    }


}
