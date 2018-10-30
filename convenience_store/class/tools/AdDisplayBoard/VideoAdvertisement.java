package tools.AdDisplayBoard;

public class VideoAdvertisement extends Advertisement {
    @Override
    public void show() {
        System.out.println("[This is a video ad]: " + getSlogan());
    }
}
