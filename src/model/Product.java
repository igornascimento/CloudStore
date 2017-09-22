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
    private float value;
    private String unityOfMeasure;
    
    public Product(int id, String name, String description, int quantity, float value, String unityOfMesure) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.value = value;
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

    public float getValue() {
        return value;
    }
    
    public String getUnityOfMeasure() {
        return unityOfMeasure;
    }
    
}
