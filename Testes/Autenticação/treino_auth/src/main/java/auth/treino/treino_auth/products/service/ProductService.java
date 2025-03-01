package auth.treino.treino_auth.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.treino.treino_auth.products.model.ProductModel;
import auth.treino.treino_auth.products.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductModel save(ProductModel productModel){
        return productRepository.save(productModel);
    }

    public List<ProductModel> findAll(){
        return productRepository.findAll();
    }

}
