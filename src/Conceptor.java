import java.util.ArrayList;
import java.util.List;

public class Conceptor extends Node {
    private String firstNodeName; // node1
    private List<String> receptorsStr = new ArrayList<>();

    public Conceptor(String firstNodeName, List<String> receptorsStr) {
        this.firstNodeName = firstNodeName;
        this.receptorsStr = receptorsStr;
    }

    public String getFirstNodeName() {
        return firstNodeName;
    }

    public void setFirstNodeName(String firstNodeName) {
        this.firstNodeName = firstNodeName;
    }

    public List<String> getReceptorsStr() {
        return receptorsStr;
    }

    public void setReceptorsStr(List<String> receptorsStr) {
        this.receptorsStr = receptorsStr;
    }
}
