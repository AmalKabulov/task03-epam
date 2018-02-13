package by.epam;

import by.epam.analyzer.Analyzer;
import by.epam.analyzer.AnalyzerFactory;
import by.epam.analyzer.exception.ParseException;
import by.epam.analyzer.exception.ReaderCloseException;

import java.io.InputStream;

public class Runner {
    public static void main(String[] args) throws ParseException, ReaderCloseException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("books.xml");

        AnalyzerFactory analyzerFactory = AnalyzerFactory.getInstance();
        Analyzer analyzer = analyzerFactory.getAnalyzer(inputStream);
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());
        Print.print(analyzer.next());

    }
}
