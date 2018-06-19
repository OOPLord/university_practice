import java.util.List;

public class Receptor extends Node {
    public Receptor(String name, int index) {
        super.setName(name);
        super.setIndex(index);
    }

    public Receptor(String name, int index, List<Node> conceptors) {
        this(name, index);
        super.setConceptors(conceptors);
    }
}
