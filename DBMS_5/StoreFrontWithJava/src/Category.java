public class Category {
    private String title;
    private int count;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return "Category : " + title + " " + count;
    }
}
