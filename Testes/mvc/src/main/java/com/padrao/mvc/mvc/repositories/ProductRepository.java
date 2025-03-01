package com.padrao.mvc.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padrao.mvc.mvc.models.dtos.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
