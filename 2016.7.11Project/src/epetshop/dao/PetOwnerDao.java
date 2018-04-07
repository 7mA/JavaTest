package epetshop.dao;
import epetshop.entity.*;

import java.util.*;

public interface PetOwnerDao {
	/**
	 * Query all masters' information
	 */
	public List<PetOwner> getAllOwner();
	
	/**
	 * Update master's information
	 */
	public int updateOwner(String sql,Object[] param);
	
	/**
	 * Find master's information by search condition
	 */
	public PetOwner selectOwner(String sql,Object[] param);
}
