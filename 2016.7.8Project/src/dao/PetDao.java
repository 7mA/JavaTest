package dao;
import java.util.List;
import entity.Pet;

public interface PetDao {
	int save(Pet pet);
	int del(Pet pet);
	int update(Pet pet);
	Pet getByName(String name);
	List<Pet> findByName(String name);
	List<Pet> findByStrain(String name);
	List<Pet> query();
	Pet getByNameNc(String name);
	List<Pet> findByNameNc(String name);
	List<Pet> findByStrainNc(String name);
	int findPetInAdopt(int id);
	void close();
}
