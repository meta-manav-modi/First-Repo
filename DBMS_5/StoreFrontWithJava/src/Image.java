public class Image {
    private String imageUrl;
    private int id;
    private int productId;

    public void setImageurl(String url) {
        this.imageUrl = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImageurl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public String toString(){
        return "Image : " + id +" " + productId + " " + imageUrl;
    }
}