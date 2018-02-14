package by.epam.analyzer;

import by.epam.analyzer.entity.Node;
import by.epam.analyzer.impl.exception.ParseException;
import by.epam.analyzer.reader.exeption.ReaderCloseException;

public interface Analyzer {
    Node next() throws ParseException, ReaderCloseException;
    boolean hasNext() throws ParseException, ReaderCloseException;

}
