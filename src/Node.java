import java.util.*;

public class Node {
    private String name;
    private int index;
    private String nClass;
    private int totalExcitement;
    private NodeType type;
    private Set<Integer> receptorsIndexes = new HashSet<>();
    private List<Node> receptors = new ArrayList<>();
    private final int level = receptors.size();
    private List<Node> conceptors = new ArrayList<>();
    private Set<Integer> upperIndexes = new HashSet<>();
    private Set<Integer> downIndexes = new HashSet<>();

    public Node() {}

    public Node(String name, String nClass) {
        this.name = name;
        this.nClass = nClass;
    }

    public Node(String name, NodeType type, List<Node> conceptors) {
        this.name = name;
        this.type = type;
        this.conceptors = conceptors;
    }

    public Node(String name, NodeType type, List<Node> receptors, Set<Integer> receptorsIndexes) {
        this.name = name;
        this.type = type;
        this.receptors = receptors;
        this.receptorsIndexes = receptorsIndexes;
    }

    public static Node getNode(String name, List<Node> nodes) {
        for (Node node : nodes) {
            if (node.name.equals(name)) {
                return node;
            }
        }

        return null;
    }

    public static Node getNode(int index, List<Node> nodes) {
        for (Node node : nodes) {
            if (node.index == index) {
                return node;
            }
        }

        return null;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public NodeType getType() {
        return this.type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getnClass() {
        return nClass;
    }

    public void setnClass(String nClass) {
        this.nClass = nClass;
    }

    public void resetExcitement() {
        this.totalExcitement = 0;
    }

    public void addExcitement() {
        this.totalExcitement++;
    }

    public int getTotalExcitement() {
        return this.totalExcitement;
    }

    public void setConceptors(List<Node> conceptors) {
        this.conceptors = conceptors;
    }

    public List<Node> getConceptors() {
        return this.conceptors;
    }

    public void setReceptors(List<Node> receptors) {
        this.receptors = receptors;
    }

    public List<Node> getReceptors() {
        return this.receptors;
    }

    public void setReceptorsIndexes(Set<Integer> receptorsIndexes) {
        this.receptorsIndexes = receptorsIndexes;
    }

    public Set<Integer> getReceptorsIndexes() {
        return receptorsIndexes;
    }
}
