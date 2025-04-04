package virtualCommandPrompt;

import java.util.ArrayList;
import java.util.List;

/**
 * class VirtualCommandPrompt, used to define all the methods for panel
 * like mkdir, ls, cd, bk, tree etc.
 */
public class VirtualCommandPrompt {
    private DirectoryNode root;
    private DirectoryNode current;

    public VirtualCommandPrompt() {
        root = new DirectoryNode("R", null);
        current = root;
    }

    // Method used to add new directory
    public void mkdir(String name) {
        for (DirectoryNode dir : current.getChildren()) {
            if (dir.getName().equals(name)) {
                System.out.println("Directory already exists");
                return;
            }
        }
        current.setChildren(new DirectoryNode(name, current));
    }

    // Method helps to move to other directory from current directory
    public void cd(String name) {
        for (DirectoryNode dir : current.getChildren()) {
            if (dir.getName().equals(name)) {
                current = dir;
                return;
            }
        }
        System.out.println("Directory not found");
    }

    // Method helps to move to its parent directory from current directory
    public void back() {
        if (current.getParent() != null) {
            current = current.getParent();
        } else {
            System.out.println("Already at the root directory");
        }
    }

    // Method helps to print all the directories available
    public void ls() {
        for (DirectoryNode dir : current.getChildren()) {
            System.out.println(dir.getName() + " " + dir.getCreatedAt());
        }
        System.out.println("Total subdirectories" + current.getChildren().size());
    }

    // Method helpd to find a file along with its path
    public void find(String name) {
        List<String> paths = new ArrayList<>();
        recursive(current, name, "", paths);
        if (paths.isEmpty()) {
            System.out.println("Directory not found");
        } else {
            paths.forEach(System.out::println);
        }
    }

    // Method help to print the tree of all directories
    public void tree(){
        printTree(current, "", true);
    }

    // Method used to print the path of directories
    public String getPrompt() {
        StringBuilder path = new StringBuilder();
        DirectoryNode dir = current;
        while (dir != null) {
            path.insert(0, "\\" + dir.getName());
            dir = dir.getParent();
        }
        return path.substring(1) + ">";
    }

    // Recursive function to find directory among all childrens
    private void recursive(DirectoryNode dir, String name, String path, List<String> paths) {
        if (dir.getName().equals(name)) {
            paths.add(path + "\\" + dir.getName());
        }
        for (DirectoryNode child : dir.getChildren()) {
            recursive(child, name, path + "\\" + dir.getName(), paths);
        }
    }

    // Recursive function to print the tree for virtual command prompt
    private void printTree(DirectoryNode current, String path, boolean isLast){
        String branch = isLast ? "\u2514\u2500\u2500 " : "\u251C\u2500\u2500 ";
        System.out.println(path + branch + current.getName());
        for(int index = 0; index < current.getChildren().size(); index++){
            boolean lastChild = (index == current.getChildren().size() - 1);
            printTree(current.getChildren().get(index), path + (isLast ? "    " : "\u2502   "), lastChild);
        }
    }
}
