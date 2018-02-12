package by.epam.parser;

import by.epam.parser.exception.CouldNotReadException;
import by.epam.parser.exception.ParseException;

import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser {
    private XmlReader reader;

    private Map<Integer, String> parsedLines = new TreeMap<>();
    private final List<String> condtitons;

    {
        condtitons = List.of(TagConstant.OPEN_TAG, TagConstant.CLOSE_TAG, TagConstant.SELF_CLOSING_TAG, TagConstant.TEXT);
    }

    public XmlParser(InputStream inputStream) {
        reader = new XmlReader(inputStream);
    }

    public void parse() throws ParseException {
        try {
            String line = reader.readLine();
            if (line != null) {

            }
        } catch (CouldNotReadException e) {
            throw new ParseException("ERROR WHILE PARSING... " + e);
        }
//        String openTagCond = "<[^/][\\s\\w\\-_=\"']*?>";
//        String selfClosingTag = "<[^/][\\w[,|=|+|\\s|.|:|;]*]+?[/]>";
//        String closingTag = "<[/][\\w[-]*]+?>";
//        String text = "(?<![<[\\w\\s]*])[\\w[,|=|+|\\s|.|:|;]*]+(?![[\\w\\s]*>])";
//        while (line.length() > 0) {
//            if (line.length() > 0) {
//                line = checkLine(openTagCond, line);
//            }
//            if (line.length() > 0) {
//                line = checkLine(selfClosingTag, line);
//            }
//            if (line.length() > 0) {
//                line = checkLine(closingTag, line);
//            }
//            if (line.length() > 0) {
//                line = checkLine(text, line);
//            }
//            System.out.println("ОСТАТОК: " + line);
//        }


    }
//
//    public List<SMTH> find(String cond, String line) {
//        List<SMTH> list = null;
//        Pattern pattern = Pattern.compile(cond);
//        Matcher m = pattern.matcher(line);
//        while (m.find()) {
//            list = new ArrayList<>();
//            list.add(new SMTH(m.start(), m.end()));
//        }
//        return list;
//    }
//
    private void parseLine(final String cond, final String line) {
        Pattern pattern = Pattern.compile(cond);
        Matcher m = pattern.matcher(line);
        if (m.find()) {
            String found = m.group();
            int start = m.start();
            int end = m.end();

            System.out.println("By condition: " + cond + " found line:" + found);
            parsedLines.put(parsedIndex, found);
            parsedIndex++;

            return line.delete(start, end);
//            System.out.println(line);
//            return found;
        }
    }


}
