package tools.adboard;

public class VideoAdvertisement extends Advertisement {

    public VideoAdvertisement() {

    }

    public VideoAdvertisement(String brand, String slogan) {
        this.setBrand(brand);
        this.setSlogan(slogan);
    }

    @Override
    public void show() {
        System.out.println("[This is a video ad]: " + getSlogan());
    }
}
