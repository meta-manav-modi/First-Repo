package virtualCommandPrompt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * class DirectoryNode , used to store the info about any directory
 * values like, name, time of creation, parent node, and list of children nodes
 */
public class DirectoryNode {
    private String name;
    private DirectoryNode parent;
    private LocalDateTime createdAt;
    private List<DirectoryNode> children;

    public DirectoryNode(String name, DirectoryNode parent) {
        this.name = name;
        this.parent = parent;
        this.createdAt = LocalDateTime.now();
        this.children = new ArrayList<>();
    }

    // Getters of DirectoryNode class
    public String getName() {
        return name;
    }

    public DirectoryNode getParent() {
        return parent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<DirectoryNode> getChildren() {
        return children;
    }

    // Setters of DirectoryNode class
    public void setChildren(DirectoryNode child) {
        this.children.add(child);
    }
}
