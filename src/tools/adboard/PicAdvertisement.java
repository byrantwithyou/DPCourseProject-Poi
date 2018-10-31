package tools.adboard;

public class PicAdvertisement extends Advertisement {
    public PicAdvertisement() {

    }

    public PicAdvertisement(String brand, String slogan) {
       this.setBrand(brand);
       this.setSlogan(slogan);
    }

    @Override
    public void show() {
        System.out.println("[This is a picture ad]");
        System.out.println("[Brand]: " + getBrand());
        System.out.println("[Slogan]: " + getSlogan());
    }
}
