package epetshop.biz;

import java.util.List;

import epetshop.entity.Pet;
import epetshop.entity.PetOwner;

public interface PetOwnerManage {
	/**
	 * Master login
	 */
	public PetOwner login(PetOwner mas);
	
	/**
	 * Find all pets that belong a master with a certain ID
	 */
	public List<Pet> getMyPet(int ownerId);
}

