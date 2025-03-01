package auth.treino.treino_auth.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.treino.treino_auth.products.model.ProductModel;
import auth.treino.treino_auth.products.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product){
        return ResponseEntity.ok().body(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> findAll(){
        return ResponseEntity.ok().body(productService.findAll());
    }

}
