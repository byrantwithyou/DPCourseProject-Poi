package tools.AdDisplayBoard;

/**
 * @author Hou Xianda
 */
public abstract class Advertisement {
    private String brand;
    private String slogan;
    private String type;

    public Advertisement() {
    }

    public Advertisement(String brand, String slogan) {
        this.brand = brand;
        this.slogan = slogan;
    }

    public abstract void show();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
