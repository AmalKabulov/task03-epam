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
    private final List<Pattern> conditions;


    {
        conditions = List.of(Pattern.compile(NodeType.OPEN_TAG.getValue()),
                             Pattern.compile(NodeType.CLOSE_TAG.getValue()),
                             Pattern.compile(NodeType.SELF_CLOSE_TAG.getValue()),
                             Pattern.compile(NodeType.TEXT.getValue()));
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
            conditions.forEach(founder -> parseLine(founder, line));
        } catch (IOException e) {
            throw new ParseException("ERROR WHILE PARSING... " + e);
        }
    }


    private void parseLine(final Pattern founder, final String line) {
        String condition = founder.pattern();
        Matcher m = founder.matcher(line);
        if (m.find()) {
            int startIndex = m.start();
            NodeType nodeType = NodeType.getByValue(condition);
            String result = m.group().replaceAll(OPEN_AND_CLOSE_TAG, EMPTY);
            Node node = new Node(nodeType, result);
            parsedLines.put(startIndex, node);
        }
    }

}
