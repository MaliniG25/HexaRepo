package com.petpals.dao;


import java.util.List;
import com.petpals.model.CashDonation;
import com.petpals.model.Donation;
import com.petpals.model.ItemDonation;

public interface IDonationDao {
	boolean recordCashDonation(CashDonation donation);
    boolean recordItemDonation(ItemDonation donation);
    List<Donation> getAllDonations();
}
