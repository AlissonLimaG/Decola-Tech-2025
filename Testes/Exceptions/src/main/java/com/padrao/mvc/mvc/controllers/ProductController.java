package com.padrao.mvc.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.padrao.mvc.mvc.models.product.Product;
import com.padrao.mvc.mvc.models.product.exceptions.ProductInvalidPriceException;
import com.padrao.mvc.mvc.models.product.exceptions.ProductNullNameException;
import com.padrao.mvc.mvc.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PostMapping("saveAll")
    public ResponseEntity<List<Product>> saveAllProducts(@RequestBody List<Product> lProducts){
        return ResponseEntity.ok(productService.saveAll(lProducts));
    }

    @GetMapping("all")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getForId(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

}
