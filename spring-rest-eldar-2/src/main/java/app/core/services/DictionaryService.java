package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Entry;
import app.core.repositories.EntryRepository;

@Service
@Transactional
public class DictionaryService {
	@Autowired
	private EntryRepository repository;
	
	public int add(Entry entry) {
		return repository.save(entry).getId();
	}
	
	public List<Entry> getDefinition(String word) {
		return this.repository.findByWord(word);
	}

}
