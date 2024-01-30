package be.intecbrussel.animalshelter.service;

import be.intecbrussel.animalshelter.model.Animal;
import be.intecbrussel.animalshelter.model.SortType;
import be.intecbrussel.animalshelter.repository.AnimalRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalService {
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void sortAnimalShelter(SortType sortType){
        List<Animal> animalList = animalRepository.getAnimals();

        switch (sortType) {
            case AGE -> sortAnimalsByAge(animalList);
            case NAME -> sortAnimalsByName(animalList);
        }

        System.out.println();
    }

    public void sortAnimalsByName(List<Animal> animalList){
        animalList.sort(Comparator.comparing(Animal::getName));
    }

    public void sortAnimalsByAge(List<Animal> animalList){
        animalList.sort(Comparator.comparing(Animal::getAge));
    }
}
