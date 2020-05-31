package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Stamp> stamps = new ArrayList<>();
    private List<Calendar> calendars = new ArrayList<>();
    private List<Banner> banners = new ArrayList<>();
    private List<BusinessCard> businessCards = new ArrayList<>();
    private int totalPrice;

    public void addProduct(Stamp stamp) {
        this.stamps.add(stamp);
        this.totalPrice += stamp.getPrice();
    }

    public void removeProduct(Stamp stamp) {
        this.stamps.remove(stamp);
    }

    public void addProduct(Calendar calendar) {
        this.calendars.add(calendar);
        this.totalPrice += calendar.getPrice();
    }

    public void removeProduct(Calendar calendar) {
        this.calendars.remove(calendar);
        this.totalPrice -= calendar.getPrice();
    }

    public void addProduct(Banner banner) {
        this.banners.add(banner);
        this.totalPrice += banner.getPrice();
    }

    public void removeProduct(Banner banner) {
        this.banners.remove(banner);
        this.totalPrice -= banner.getPrice();
    }

    public void addProduct(BusinessCard businessCard) {
        this.businessCards.add(businessCard);
        this.totalPrice += businessCard.getPrice();
    }

    public void removeProduct(BusinessCard businessCard) {
        this.businessCards.remove(businessCard);
        this.totalPrice -= businessCard.getPrice();
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public List<Stamp> getStamps() {
        return stamps;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public List<BusinessCard> getBusinessCards() {
        return businessCards;
    }
}
