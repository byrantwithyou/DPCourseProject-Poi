package tools.adboard;

public class VideoAdvertisement extends Advertisement {

    public VideoAdvertisement() {
        super();
        System.out.println(this.getClass().getName() + " :: " + "VideoAdvertisement()" + " : " + "Constructor called");
    }

    public VideoAdvertisement(String brand, String slogan) {
        super(brand, slogan);
        System.out.println(this.getClass().getName() + " :: " + "VideoAdvertisement()" + " : " + "Constructor called");
    }

    @Override
    public void show() {
        System.out.println("[This is a video ad]: " + getSlogan());
    }
}
