package org.example.dao;

import org.example.entity.Animal;

import java.util.List;

public interface AnimalDao {
    public List<Animal> selectAnimals();

    public int insertAnimal(Animal animal);

    public int deleteAnimal();


}
