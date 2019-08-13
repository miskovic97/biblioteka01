package biblioteka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import biblioteka.model.Hall;
import biblioteka.repository.HallRepository;

public class HallServiceImpl implements HallService {

	@Autowired
	HallRepository hallRepository;
	
	@Override
	public List<Hall> getAll() {
		return hallRepository.findAll();
	}

	@Override
	public Optional<Hall> getById(long id) {
		return hallRepository.findById(id);
	}

	@Override
	public Hall save(Hall hall) {
		return hallRepository.save(hall);
	}

	@Override
	public Hall update(Hall hall, long id) {
		return null;
	}

	@Override
	public void delete(long id) {
		hallRepository.deleteById(id);
	}

}
