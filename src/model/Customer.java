package model;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Customer {
    
    private String name;
    private String document;
    private String address;
    private String zipCode;
    
    public Customer(String name, String document, String address, String zipCode) {
        this.name = name;
        this.document = document;
        this.address = address;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }
    
}
