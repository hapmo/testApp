package ru.hapmo.testapp.models;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("point_distance")
    private int pointDistance;

    @SerializedName("shop_logo")
    private String shopLogo;

    @SerializedName("shop_rank")
    private float shopRank;

    @SerializedName("item_name")
    private String itemName;

    @SerializedName("item_price")
    private String itemPrice;

    @SerializedName("item_image")
    private String itemImage;

    @SerializedName("shop_name")
    private String shopName;

    public int getPointDistance() {
        return pointDistance;
    }

    public void setPointDistance(int pointDistance) {
        this.pointDistance = pointDistance;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public float getShopRank() {
        return shopRank;
    }

    public void setShopRank(float shopRank) {
        this.shopRank = shopRank;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}