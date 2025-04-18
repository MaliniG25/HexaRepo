package com.petpals.model;

public class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, double amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public void recordDonation() {
        System.out.println("Item donation recorded:");
        System.out.println("Donor: " + donorName);
        System.out.println("Item Type: " + itemType);
        System.out.println("Estimated Value: $" + amount);
    }
}
