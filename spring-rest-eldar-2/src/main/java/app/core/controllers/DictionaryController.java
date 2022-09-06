package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;

import app.core.entities.Entry;
import app.core.services.DictionaryService;

@RestController
//@RequestMapping(path= "/api/dictionary", headers = HttpHeaders.AUTHORIZATION)
@RequestMapping(path= "/api/dictionary")
public class DictionaryController {
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@PostMapping
	public int addEntry(@RequestBody Entry entry) {
		return dictionaryService.add(entry);
	}
	
	@GetMapping("/{word}")
	public List<Entry> getDefinitions(@PathVariable String word){
		return this.dictionaryService.getDefinition(word);
	}
	
	@GetMapping("/hi")
	public String greet() {
		return "Hi";
	}

}
