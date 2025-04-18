package com.petpals.main;

import java.time.LocalDate;
import java.util.List;

import com.petpals.dao.DonationDaoImpl;
import com.petpals.dao.PetDaoImpl;
import com.petpals.model.CashDonation;
import com.petpals.model.Donation;
import com.petpals.model.ItemDonation;
import com.petpals.model.Pet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetDaoImpl petDAO = new PetDaoImpl();
        DonationDaoImpl donationDAO = new DonationDaoImpl();

        System.out.println("PetPals");

        Pet pet1 = new Pet("Rocky", 4, "Labrador");
        Pet pet2 = new Pet("Tiger", 5, "Persian Cat");

        System.out.println("\nInsertion");
        petDAO.addPet(pet1);
        petDAO.addPet(pet2);
        
        System.out.println("\nDeleting");
        if (petDAO.removePetByName("Tiger")) {
            System.out.println("Pet deleted successfully.");
        } else {
            System.out.println("Failed to delete pet.");
        }

        System.out.println("\nAvailable Pets:");
        List<Pet> allPets = petDAO.getAllPets();
        for (Pet pet : allPets) {
            System.out.println(pet);
        }

        CashDonation cashDonation = new CashDonation("Priya", 50.0, LocalDate.now());
        donationDAO.recordCashDonation(cashDonation);

        ItemDonation itemDonation = new ItemDonation("Ramya", 100.0, "Dog Food Pack");
        donationDAO.recordItemDonation(itemDonation);

        System.out.println("\nAll Donations:");
        List<Donation> allDonations = donationDAO.getAllDonations();
        for (Donation donation : allDonations) {
            System.out.println(donation);
        }
    }
}