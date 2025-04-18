package com.petpals.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.petpals.model.Pet;
import com.petpals.util.DbConnectionsUtil;

public class PetDaoImpl {
	public boolean addPet(Pet pet) {
        String sql = "INSERT INTO pets (name, age, breed) VALUES (?, ?, ?)";
        try (Connection conn = DbConnectionsUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pet.getName());
            ps.setInt(2, pet.getAge());
            ps.setString(3, pet.getBreed());
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error adding pet: " + e.getMessage());
            return false;
        }
    }

    public boolean removePetByName(String name) {
        String sql = "DELETE FROM pets WHERE name = ?";
        try (Connection conn = DbConnectionsUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error removing pet: " + e.getMessage());
            return false;
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";

        try (Connection conn = DbConnectionsUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String breed = rs.getString("breed");
                pets.add(new Pet(name, age, breed));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving pets: " + e.getMessage());
        }

        return pets;
    }

    public Pet getPetByName(String name) {
        String sql = "SELECT * FROM pets WHERE name = ?";
        try (Connection conn = DbConnectionsUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int age = rs.getInt("age");
                String breed = rs.getString("breed");
                return new Pet(name, age, breed);
            }

        } catch (SQLException e) {
            System.out.println("Error finding pet: " + e.getMessage());
        }

        return null;
    }
}