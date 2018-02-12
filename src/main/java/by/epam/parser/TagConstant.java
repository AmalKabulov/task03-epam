package by.epam.parser;

public final class TagConstant {
    public static final String OPEN_TAG = "<[^/][\\s\\w\\-_=\"']*?>";
    public static final String CLOSE_TAG = "<[/][\\w[-]*]+?>";
    public static final String SELF_CLOSING_TAG = "<[^/][\\w[,|=|+|\\s|.|:|;]*]+?[/]>";
    public static final String TEXT = "(?<![<[\\w\\s]*])[\\w[,|=|+|\\s|.|:|;]*]+(?![[\\w\\s]*>])";
}
