package com.petpals.dao;
import java.util.List;
import com.petpals.model.Pet;

public interface IPetDao {
	boolean addPet(Pet pet);
    boolean removePetByName(String name);
    List<Pet> getAllPets();
    Pet getPetByName(String name);
}
