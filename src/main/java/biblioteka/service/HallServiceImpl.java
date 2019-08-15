package biblioteka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteka.model.Hall;
import biblioteka.repository.HallRepository;

@Service
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
	public Hall getByIdHall(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hall> getByname(String name) {
		return hallRepository.findByName(name);

	}

	@Override
	public Hall update(Hall hall, long id) {
		return hallRepository.saveAndFlush(hall);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
