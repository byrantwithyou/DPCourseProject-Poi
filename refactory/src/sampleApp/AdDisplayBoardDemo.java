package sampleApp;

import tools.adboard.AdDisplayBoard;
import tools.adboard.AdTerminal;
import tools.adboard.Advertisement;
import tools.adboard.PicAdvertisement;
import tools.adboard.VideoAdvertisement;

import java.util.Scanner;

public class AdDisplayBoardDemo {
    public static void main(String[] args) {
        AdTerminal adTerminal = AdTerminal.getInstance();
        //加入广告板
        adTerminal.addAdDisplayBoard(new AdDisplayBoard());
        adTerminal.addAdDisplayBoard(new AdDisplayBoard());
        System.out.println("Please enter the brand of Ad:");
        Advertisement advertisement;
        String brand;
        String slogan;
        String type;
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        brand = scanner.nextLine();
        //广告的内容
        System.out.println("Please enter the slogan of Ad:");
        slogan = scanner.nextLine();
        System.out.println("Please enter the type of Ad:");
        type = scanner.nextLine();
        if (type.equalsIgnoreCase("PicAd")) {
            advertisement = new PicAdvertisement(brand, slogan);
            adTerminal.showAd(advertisement);
        } else if (type.equalsIgnoreCase("VideoAd")) {
            advertisement = new VideoAdvertisement(brand, slogan);
            adTerminal.showAd(advertisement);
        } else {
            System.out.println("Error! Invalid Type of Advertisement");
        }
    }
}
