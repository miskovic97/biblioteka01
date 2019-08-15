package biblioteka.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import biblioteka.model.Library;
import biblioteka.service.LibraryService;

@RestController
@RequestMapping(value="/library")
public class LibraryController {
	@Autowired
	LibraryService libraryservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Library>> getLibraryInformations(){
		List<Library> library = libraryservice.getAll();
		
		return new ResponseEntity<List<Library>>(library,HttpStatus.OK);
		
		
		
	}
	
	
	
}
