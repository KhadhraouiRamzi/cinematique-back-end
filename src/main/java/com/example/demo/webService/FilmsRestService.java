package com.example.demo.webService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.FilmsRepository;
import com.example.demo.entite.films;

@CrossOrigin
@RestController
public class FilmsRestService {

	@Autowired
	FilmsRepository filmsRepository; // NULL

	@RequestMapping(path = "/films", method = RequestMethod.GET)
	public List<films> listefilms() {
		return filmsRepository.listfilms();
	}

	@RequestMapping(path = "/film", method = RequestMethod.GET)
	public List<films> listefilm() {
		return filmsRepository.listfilm();
	}

	@RequestMapping(path = "/films/by-id/{id}", method = RequestMethod.GET)
	public Optional<films> rechercheParId(@PathVariable("id") Integer id) {
		return filmsRepository.findById(id);
	}
	
	@RequestMapping(path = "/getRealisateur/{id}", method = RequestMethod.GET)
	public List<films> listRealisateur(@PathVariable("id") Integer id) {
		return filmsRepository.getrealise(id);
	}

	@RequestMapping(path = "/new-films", method = RequestMethod.POST)
	public Integer addfilms(@RequestBody films u) {
		filmsRepository.save(u);
		return u.getId();
	}

	@RequestMapping(path = "/updateFilms", method = RequestMethod.PUT)
	public void updateV2(@RequestBody films u) {
		filmsRepository.save(u);
	}

	@RequestMapping(path = "/deleteFilms/{id}", method = RequestMethod.DELETE)
	public void deleteByExcludedId(@PathVariable("id") Integer id) {
		filmsRepository.deleteById(id);
	}

}