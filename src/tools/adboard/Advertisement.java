package tools.adboard;

/**
 * @author Hou Xianda
 */
public abstract class Advertisement {
    private String brand;
    private String slogan;

    public Advertisement() {
        System.out.println(this.getClass().getName() + " :: " + "PicAdvertisement()" + " : " + "Constructor called");
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
}
