package tools.AdDisplayBoard;

public class AdTest {
    public static void main(String[] args) {
        AdTerminal adTerminal = AdTerminal.getInstance();
        Advertisement ad = new VideoAdvertisement();
        ad.setBrand("金克拉");
        ad.setSlogan("肥料掺了金克拉，一带能顶两袋撒，肥料掺了金克拉，小麦亩产一千八。");
        ad.setType("Video Ad");
        adTerminal.showAd(ad);
    }
}
