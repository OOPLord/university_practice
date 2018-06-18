public class Edge {
    private String firstNodeName; // node1
    private String secondNodeName; // node2
    private String group;

    public Edge(String firstNodeName, String secondNodeName) {
        this(firstNodeName, secondNodeName, "Part_of");
    }

    public Edge(String firstNodeName, String secondNodeName, String group) {
        this.firstNodeName = firstNodeName;
        this.secondNodeName = secondNodeName;
        this.group = group;
    }

    public String getFirstNodeName() {
        return firstNodeName;
    }

    public void setFirstNodeName(String firstNodeName) {
        this.firstNodeName = firstNodeName;
    }

    public String getSecondNodeName() {
        return secondNodeName;
    }

    public void setSecondNodeName(String secondNodeName) {
        this.secondNodeName = secondNodeName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
