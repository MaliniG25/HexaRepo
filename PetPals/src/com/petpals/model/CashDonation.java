package com.petpals.model;

import java.time.LocalDate;

public class CashDonation extends Donation {
    private LocalDate donationDate;

    public CashDonation(String donorName, double amount, LocalDate donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    @Override
    public void recordDonation() {
        System.out.println("Cash donation recorded:");
        System.out.println("Donor: " + donorName);
        System.out.println("Amount: $" + amount);
        System.out.println("Date: " + donationDate);
    }
}

