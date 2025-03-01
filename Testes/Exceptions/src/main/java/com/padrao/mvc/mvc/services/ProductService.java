package com.padrao.mvc.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padrao.mvc.mvc.models.product.Product;
import com.padrao.mvc.mvc.models.product.exceptions.ProductInvalidPriceException;
import com.padrao.mvc.mvc.models.product.exceptions.ProductNullNameException;
import com.padrao.mvc.mvc.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        if(product.getNome() == null || product.getNome() == "") throw new ProductNullNameException();
        if(product.getPreco() <= 0) throw new ProductInvalidPriceException();
        
        return productRepository.save(product);
    }

    public List<Product> saveAll(List<Product> lProducts){
        return productRepository.saveAll(lProducts);
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
