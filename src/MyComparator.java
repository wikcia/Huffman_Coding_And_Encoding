import java.util.Comparator;

public class MyComparator implements Comparator<TreeNode> {

    @Override
    public int compare(TreeNode o1, TreeNode o2) {
        return Double.compare(o1.probability, o2.probability);
    }
}
