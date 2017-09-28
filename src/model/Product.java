package model;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Product {
    
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String unityOfMeasure;
    
    public Product(int id, String name, String description, int quantity, double price, String unityOfMesure) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.unityOfMeasure = unityOfMeasure;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getValue() {
        return price;
    }
    
    public String getUnityOfMeasure() {
        return unityOfMeasure;
    }
    
}
