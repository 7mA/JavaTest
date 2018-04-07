package dao;
import entity.Master;
import entity.Pet;

import java.util.*;

public interface MasterDao {
	int save(Master master);
	int del(Master master);
	int update(Master master);
	Master findMaster(Master master);
	int adopt(Master master,Pet pet);
	List<Integer> findMasterInAdopt(int id);
	int releasePetFromAdopt(int id);
	Master getByID(Master master);
}
