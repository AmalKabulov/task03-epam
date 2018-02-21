package by.epam.analyzer.node;

import java.util.HashMap;
import java.util.Map;

public enum NodeType {
    OPEN_TAG("<[^/][\\s\\w\\-_=\"']*?>"),
    CLOSE_TAG("<[/][\\w[-]*]+?>"),
    SELF_CLOSE_TAG("<[^/][\\w[,|=|+|\\s|.|:|;|\"]*]+?[/]>"),
    TEXT("(?<![<[\\w\\s]*])[\\w[,]*[=]*[+]*[\\s]*[.]*[:]*[;]*[-]*[']*[`]*]+(?![[\\w\\s\"]*>])");


    private static final Map<String, NodeType> tags = new HashMap<>();

    static {
        for (NodeType nodeType : values()) {
            tags.put(nodeType.getValue(), nodeType);
        }
    }

    private String value;
    NodeType(String value) {
        this.value = value;
    }


    public static NodeType getByValue(final String value) {
        return tags.get(value);
    }

    public String getValue() {
        return value;
    }
}
