package by.epam;

import by.epam.analyzer.entity.Node;

public class Print {

    public static void print(Object object) {
        if (object.getClass() == Node.class) {
            Node node = (Node) object;
            String nodePrint = new StringBuilder("[NAME: ").append(node.getName()).append("]")
                    .append(" [TYPE: ").append(node.getType()).append("]").toString();
            System.out.println(nodePrint);
        }
    }
}
