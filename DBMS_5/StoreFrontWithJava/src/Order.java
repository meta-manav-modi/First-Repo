
public class Order {
    private String date;
    private int id;
    private double total;

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public Double getTotal() {
        return total;
    }

    public String toString(){
        return "Order : " + id +" " + date + " " + total;
    }
}
