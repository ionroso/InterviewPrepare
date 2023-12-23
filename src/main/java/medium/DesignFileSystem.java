package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignFileSystem {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
//        fileSystem.createPath("/a", 1); // return true
//        System.out.println(fileSystem.get("/a")); // return true

        fileSystem.createPath("/leet", 1); // return true
        fileSystem.createPath("/leet/code", 2); // return true
        System.out.println(fileSystem.get("/leet/code")); // return 2
        fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
        System.out.println(fileSystem.get("/c")); // return -1 because this path doesn't exist.
    }

    static
    class FileSystem {
        private class TreeNode {
            private Integer val;
            private String folder;
            private List<TreeNode> paths;

            public TreeNode() {
            }

            public TreeNode(int val, String folder) {
                this();
                this.val = val;
                this.folder = folder;
            }
        }

        private TreeNode root;

        public FileSystem() {
            root=new TreeNode();
        }

        public boolean createPath(String path, int value) {
            String[] temp = getStrings(path);
            return createPath(root, temp, 0, value);
        }

        public int get(String path) {
            return getValueByPath(root, getStrings(path), 0, true);
        }

        public boolean createPath(TreeNode root, String[] path, int idx, int val){
            if (root == null) {
                return false;
            }

            TreeNode foundFolder = null;
            if(root.paths != null){
                foundFolder = getTreeNode(root, path, idx);
            } else {
                root.paths = new ArrayList<>();
            }

            if(foundFolder == null && idx == path.length-1){
                foundFolder = new TreeNode();
                root.paths.add(new TreeNode(val, path[idx]));

                return true;
            }

            if(foundFolder == null && idx != path.length-1){
                return false;
            }

           return createPath(foundFolder, path, idx+1, val);
        }

        public static int getValueByPath(TreeNode root, String[] path, int idx, boolean isRoot){
            if (root == null) {
                return -1;
            }

            if (!isRoot && idx == path.length) {
                return root.val != null ? root.val : -1;
            }


            TreeNode foundFolder = null;
            if(root.paths != null){
                foundFolder = getTreeNode(root, path, idx);
            }

            return getValueByPath(foundFolder, path, idx+1, false);
        }

        private static TreeNode getTreeNode(TreeNode root, String[] path, int idx) {
            TreeNode foundFolder = null;
            for (TreeNode tn : root.paths) {
                if(path[idx].equals(tn.folder)){
                    foundFolder = tn;
                    break;
                }
            }
            return foundFolder;
        }

        private static String[] getStrings(String path) {
            String[] split = path.split("/");
            String[] temp = Arrays.copyOfRange(split, 1, split.length);
            return temp;
        }
    }
}
