package com.restApiPract2.crud.example.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.restApiPract2.crud.example.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findByName(String name);

}
