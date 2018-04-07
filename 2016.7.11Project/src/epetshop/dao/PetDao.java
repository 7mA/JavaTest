package epetshop.dao;

import java.util.List;

import epetshop.entity.Pet;

public interface PetDao {
	public List<Pet> selectPet(String sql,Object[] para);
}
