package program;

// Клас Product (Продукт)
public class Product {
    private int productId;
    private String name;
    private ProductType productType;
    private double price;

    public Product(int productId, String name, ProductType productType, double price) {
        this.productId = productId;
        this.name = name;
        this.productType = productType;
        this.price = price;
    }

    // Геттери і сеттери
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}