import java.util.ArrayList;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class ReadNet {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void readConceptors(ArrayList<Conceptor> conceptorslist) {
        try {
           /* File inputFile = new File("graph2.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Node");
            System.out.println("----------------------------");*/

            Reader reader =  new InputStreamReader( new FileInputStream("graph2.xml"),"Windows-1251");
            InputSource is = new InputSource(reader);
            is.setEncoding("Windows-1251");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Conceptor");
            System.out.println("----------------------------");
            //----------------//

            List<String> node2list = new ArrayList<String>();
            int i;

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                // System.out.println("\nCurrent Element :"+ nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String node1 = eElement.getAttribute("node1");

                    i = temp;
                    while (eElement.getAttribute("node1").equals(node1)) {
                        node2list.add(eElement.getAttribute("node2"));
                        i++;
                        temp = i;
                        if (temp < nList.getLength()) {
                            nNode = nList.item(i);
                            eElement = (Element) nNode;
                        } else {
                            break;
                        }
                    }
                    temp -= 1;

                    conceptorslist.add(new Conceptor(node1, new ArrayList(node2list)));
                    node2list.clear();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	//Node tmp_n = null;
    //------------------------------readConceptors-----------------------------------//
    @SuppressWarnings("unused")
	public static void readNodes(ArrayList<Node> nodeslist) {
        try {
            File inputFile = new File("graph2.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Node");
            System.out.println("----------------------------");


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                //Net p = Net.getInstance( );

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String guid = eElement.getAttribute("guid");
                    String nodeName = eElement.getAttribute("nodeName");
                    String nclass = eElement.getAttribute("nclass");
                    
                    nodeslist.add(new Nodes(nodeName, guid, nclass));
                    //-------------------------------//
                    //if(nodeName.startsWith("$")){}
                    if(!nodeName.contains("Class") && !nodeName.startsWith("$")){
                    	int size = nodeslist.size();
                    	Nodes node = (Nodes) nodeslist.get(size - 1);
                    	node.downNodeSet.add(null); 				
                    }
                    //Node temp_n = nNode;
                    //---------------------------------//
                    
                }
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-------------------------------readNodes---------------------------------------//
    public static void readEdges(ArrayList<Edge> edgeslist) {
        try {
            File inputFile = new File("graph2.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Edge");
            System.out.println("----------------------------");

            //----------------//


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :"+ nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String guid = eElement.getAttribute("guid");
                    String node1 = eElement.getAttribute("node1");
                    String node2 = eElement.getAttribute("node2");
                    String group = eElement.getAttribute("group");

                    edgeslist.add(new Edge(guid, node1, node2, group));
                }
            }
            /*for (int temp = 0; temp < edgeslist.size(); temp++) {
                System.out.println("Guid : "+edgeslist.get(temp).getGuid()+" node1 : "+edgeslist.get(temp).getNode1()
                        +" node2 : "+edgeslist.get(temp).getNode2()+" group : "+edgeslist.get(temp).getGroup());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-------------------------------readEdges---------------------------------------//
	}	
