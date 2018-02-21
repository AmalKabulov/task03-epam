package by.epam.analyzer;

import by.epam.analyzer.node.Node;
import by.epam.analyzer.impl.ParseException;
import by.epam.analyzer.reader.ReaderCloseException;

public interface Analyzer {
    Node next() throws ParseException, ReaderCloseException;
    boolean hasNext() throws ParseException, ReaderCloseException;

}
