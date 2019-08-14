package biblioteka.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biblioteka.model.Hall;
import biblioteka.service.HallService;

@RestController
@RequestMapping("/halls")
public class HallControler {

	@Autowired
	HallService hallservice;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Hall>> listAllHalls() {

		List<Hall> hall = hallservice.getAll();
		if (hall.isEmpty()) {

			return new ResponseEntity<List<Hall>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hall>>(hall, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hall> listHallsById(@PathVariable("id") long id) {
		Optional<Hall> optionalHall = hallservice.getById(id);
		Hall hall = optionalHall.get();
		if (hall == null) {
			return new ResponseEntity<Hall>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Hall>(hall, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Hall> createHall(@RequestBody Hall hall) {
		List<Hall> halls= hallservice.getByname(hall.name);

		if (halls.isEmpty()) {
			hallservice.save(hall);
			return new ResponseEntity<Hall>(HttpStatus.CREATED);
			
		}
		return new ResponseEntity<Hall>(HttpStatus.NOT_FOUND);
		
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateHall(@PathVariable("id") long id , @RequestBody Hall hall)	{
		Optional<Hall> halls =hallservice.getById(id);
		Hall currentHall = halls.get();
		
		if (currentHall == null) {
			return new ResponseEntity<Hall>(HttpStatus.NOT_FOUND);
		}
		currentHall.setId(id);
		currentHall.setName(hall.getName());
		currentHall.setMember(hall.getMember());
		currentHall.setLibrary(hall.getLibrary());
		hallservice.update(currentHall, id);
		
		return new ResponseEntity<Hall>(currentHall,HttpStatus.OK);
	}


	@RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteHall(@PathVariable("id") long id){
		
		Optional<Hall> hall = hallservice.getById(id);
		Hall hals = hall.get();
		if (hals==null) {
			return new ResponseEntity<Hall>(HttpStatus.NOT_FOUND);
		}
		hallservice.delete(id);
		return new ResponseEntity<Hall>(HttpStatus.NO_CONTENT);
	}
}
