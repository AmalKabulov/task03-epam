package by.epam.analyzer;

import by.epam.analyzer.impl.XmlAnalyzer;

import java.io.InputStream;

public class AnalyzerFactory {
    private static final AnalyzerFactory instance = new AnalyzerFactory();

     private AnalyzerFactory() {

     }

    public static AnalyzerFactory getInstance() {
        return instance;
    }

    public Analyzer getAnalyzer(final InputStream inputStream) {
         Analyzer analyzer = new XmlAnalyzer(inputStream);
         return analyzer;
    }

}
