package tools.adboard;

public class PicAdvertisement extends Advertisement {
    public PicAdvertisement() {
        super();
        System.out.println(this.getClass().getName() + " :: " + "PicAdvertisement()" + " : " + "Constructor called");
    }

    public PicAdvertisement(String brand, String slogan) {
       super(brand, slogan);
        System.out.println(this.getClass().getName() + " :: " + "PicAdvertisement()" + " : " + "Constructor called");
    }

    @Override
    public void show() {
        System.out.println("[This is a picture ad]");
        System.out.println("[Brand]: " + getBrand());
        System.out.println("[Slogan]: " + getSlogan());
    }
}
