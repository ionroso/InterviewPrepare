package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    private class TreeNode {
        int id = -1;
        Employee e;
        List<TreeNode> children = new ArrayList<>();
    }


    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, TreeNode> idToTreeNode = new HashMap<>();
        for(Employee e : employees){
            TreeNode node = idToTreeNode.getOrDefault(e.id, new TreeNode());
            node.id=e.id;
            node.e=e;
            idToTreeNode.put(e.id, node);

            for(Integer child : e.subordinates){
                TreeNode childNode = idToTreeNode.getOrDefault(child, new TreeNode());
                if(childNode.id == -1){
                    childNode.id=child;
                }

                node.children.add(childNode);
                idToTreeNode.put(child, childNode);
            }
        }

        TreeNode ouput = idToTreeNode.get(id);
        idToTreeNode.clear();
        return sumUpImport(ouput);
    }

    public int sumUpImport(TreeNode root) {
        if(root == null) return 0;

        int sum = 0;
        for(TreeNode n : root.children) {
            sum+=sumUpImport(n);
        }

        return root.e.importance + sum;
    }
}
