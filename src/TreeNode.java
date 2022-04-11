import java.util.Map;

public class TreeNode {
    double probability;
    char c;

    public TreeNode right;
    public TreeNode left;

    public void fillEncodingMap(Map<Character, String> map, String prefix) {
        if (left == null) { // it's a leaf

            map.put(c, prefix);
        }
        else {
            left.fillEncodingMap(map, prefix + "0");
            right.fillEncodingMap(map, prefix + "1");
        }
    }
}
