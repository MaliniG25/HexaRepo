package com.petpals.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.petpals.model.CashDonation;
import com.petpals.model.Donation;
import com.petpals.model.ItemDonation;
import com.petpals.util.DbConnectionsUtil;

public class DonationDaoImpl {
	private final String dbPropFile = "db.properties";
	 public boolean recordCashDonation(CashDonation donation) {
	        String sql = "INSERT INTO donations (donor_name, amount, donation_type, donation_date) VALUES (?, ?, 'cash', ?)";
	        try (Connection conn = DbConnectionsUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setString(1, donation.getDonorName());
	            ps.setDouble(2, donation.getAmount());
	            ps.setDate(3, Date.valueOf(donation.getDonationDate()));

	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.out.println("Error recording cash donation: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean recordItemDonation(ItemDonation donation) {
	        String sql = "INSERT INTO donations (donor_name, amount, donation_type, item_type) VALUES (?, ?, 'item', ?)";
	        try (Connection conn = DbConnectionsUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setString(1, donation.getDonorName());
	            ps.setDouble(2, donation.getAmount());
	            ps.setString(3, donation.getItemType());

	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.out.println("Error recording item donation: " + e.getMessage());
	            return false;
	        }
	    }

	    public List<Donation> getAllDonations() {
	        List<Donation> donations = new ArrayList<>();
	        String sql = "SELECT * FROM donations";

	        try (Connection conn = DbConnectionsUtil.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            while (rs.next()) {
	                String type = rs.getString("donation_type");
	                String donor = rs.getString("donor_name");
	                double amount = rs.getDouble("amount");

	                if ("cash".equalsIgnoreCase(type)) {
	                    LocalDate date = rs.getDate("donation_date").toLocalDate();
	                    donations.add(new CashDonation(donor, amount, date));
	                } else if ("item".equalsIgnoreCase(type)) {
	                    String item = rs.getString("item_type");
	                    donations.add(new ItemDonation(donor, amount, item));
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Error retrieving donations: " + e.getMessage());
	        }

	        return donations;
	    }
}