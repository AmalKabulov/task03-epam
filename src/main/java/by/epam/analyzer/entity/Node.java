package by.epam.analyzer.entity;

import java.util.Objects;

public class Node {
    private NodeType type;
    private String name;

    public Node() {
    }

    public Node(NodeType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return type == node.type &&
                Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, name);
    }

    @Override
    public String toString() {
        return "Node{" +
                "type=" + type +
                ", name='" + name + '\'' +
                '}';
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
