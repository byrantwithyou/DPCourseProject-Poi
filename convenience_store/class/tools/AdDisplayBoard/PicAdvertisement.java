package tools.AdDisplayBoard;

public class PicAdvertisement extends Advertisement {
    @Override
    public void show() {
        System.out.println("[This is a picture ad]: " + getSlogan());
    }
}
