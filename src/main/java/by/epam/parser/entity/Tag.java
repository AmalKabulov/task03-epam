package by.epam.parser.entity;

import java.util.HashMap;
import java.util.Map;

public enum Tag {
    OPEN("<[^/][\\s\\w\\-_=\"']*?>"),
    CLOSE("<[/][\\w[-]*]+?>"),
    SELF_CLOSE("<[^/][\\w[,|=|+|\\s|.|:|;]*]+?[/]>"),
    TEXT("(?<![<[\\w\\s]*])[\\w[,]*[=]*[+]*[\\s]*[.]*[:]*[;]*[-]*[']*[`]*]+(?![[\\w\\s\"]*>])");


    private static final Map<String, Tag> tags = new HashMap<>();

    static {
        for (Tag tag : values()) {
            tags.put(tag.getValue(), tag);
        }
    }

    private String value;
    Tag(String value) {
        this.value = value;
    }


    public static Tag getByValue(final String value) {
        return tags.get(value);
    }

    public String getValue() {
        return value;
    }
}
