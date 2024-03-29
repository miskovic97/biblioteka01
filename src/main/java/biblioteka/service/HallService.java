package biblioteka.service;

import java.util.List;

import java.util.Optional;

import biblioteka.model.Hall;

public interface HallService {
	
	List<Hall> getAll();
	List<Hall >getByname(String name);
	
	Optional<Hall> getById(long id);
	
	Hall save(Hall hall);
	
	Hall update(Hall hall, long id);
	
	void delete(long id);
	
	
	
	Hall getByIdHall(long id );
}
