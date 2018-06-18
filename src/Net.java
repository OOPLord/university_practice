import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Net {
    private static volatile Net instance;
    private Set<Node> nodes = new HashSet<>();
    private Set<Node> classNodes = new HashSet<>();
    private Set<Node> layerNodes = new HashSet<>();
    private List<List<Node>> levelNodes = new ArrayList<>();

    public static Net getInstance() {
        if (instance == null) {
            synchronized (Net.class) {
                if (instance == null) {
                    instance = new Net();
                }
            }
        }

        return instance;
    }

    public boolean addNode(Node node) {
        return this.nodes.add(node);
    }

    public boolean addClassNode(Node node) {
        return this.classNodes.add(node);
    }

    public String getNodeName(int index) {
        for (Node node : this.nodes) {
            if (node.getIndex() == index) {
                return node.getName();
            }
        }

        return null;
    }
}
