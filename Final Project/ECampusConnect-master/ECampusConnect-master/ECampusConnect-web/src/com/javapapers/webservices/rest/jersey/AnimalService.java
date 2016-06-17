package com.javapapers.webservices.rest.jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnimalService {

	AnimalDao animalDao;

	public AnimalService() {
		animalDao = AnimalDao.instance;
	}

	public void createAnimal(Animal animal) {
		animalDao.getAnimals().put(animal.getId(), animal);
	}

	public Animal getAnimal(String id) {
		return animalDao.getAnimals().get(id);
	}

	public Map<String, Animal> getAnimals() {
		return animalDao.getAnimals();
	}

	public List<Animal> getAnimalAsList() {
		List<Animal> animalList = new ArrayList<Animal>();
		animalList.addAll(animalDao.getAnimals().values());
		return animalList;
	}

	public int getAnimalsCount() {
		return animalDao.getAnimals().size();
	}

	public void deleteAnimal(String id) {
		animalDao.getAnimals().remove(id);
	}

}
