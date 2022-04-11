import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanDecoding {
    private static Node root;

    public HuffmanDecoding(Map<Character, Double> frequencies) {
        PriorityQueue<Node> nodes = new PriorityQueue<Node>();
        for (char ch : frequencies.keySet()) {
            Node newNode = new Node();
            newNode.character = ch;
            newNode.frequency = frequencies.get(ch);
            nodes.add(newNode);
        }

        while (nodes.size() > 1) {
            Node smallest = nodes.remove();
            Node nextSmallest = nodes.remove();
            Node newNode = new Node();
            newNode.frequency = smallest.frequency + nextSmallest.frequency;
            newNode.left = smallest;
            newNode.right = nextSmallest;
            nodes.add(newNode);
        }

        root = nodes.remove();
    }

    public static void decode(String input) {
        String result = "";
        Node n = root;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '0') {
                n = n.left;
            }
            else {
                n = n.right;
            }
            if (n.left == null){ // n is a leaf
                result = result + n.character;
                n = root;
            }
        }
        System.out.println(result);
    }

    public Map<Character, String> getEncodingMap() {
        Map<Character, String> map = new HashMap<Character, String>();
        if (root != null) { root.fillEncodingMap(map, ""); }
        return map;
    }

    static class Node implements Comparable<Node> {
        public char character;
        public double frequency;
        public Node left;
        public Node right;

        public void fillEncodingMap(Map<Character, String> map, String prefix) {
            if (left == null) {// it's a leaf
                map.put(character, prefix);
            } else {
                left.fillEncodingMap(map, prefix + "0");
                right.fillEncodingMap(map, prefix + "1");
            }

        }
        @Override
        public int compareTo(Node other) { return (int) (frequency - other.frequency); }
    }
}

