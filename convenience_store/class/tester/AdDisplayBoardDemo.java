package tester;

import tools.AdDisplayBoard.*;

import java.util.Scanner;

public class AdDisplayBoardDemo {
    public static void main(String[] args) {
        AdTerminal adTerminal = AdTerminal.getInstance();
        adTerminal.addAdDisplayBoard(new AdDisplayBoard());
        adTerminal.addAdDisplayBoard(new AdDisplayBoard());
        System.out.println("Please enter the brand of Ad:");
        Advertisement advertisement;
        String brand;
        String slogan;
        String type;
        Scanner scanner = new Scanner(System.in);
        brand = scanner.nextLine();
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
