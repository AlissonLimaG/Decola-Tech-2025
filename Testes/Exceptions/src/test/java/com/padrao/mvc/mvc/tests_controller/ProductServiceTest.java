package com.padrao.mvc.mvc.tests_controller;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.padrao.mvc.mvc.models.product.Product;
import com.padrao.mvc.mvc.models.product.exceptions.ProductInvalidPriceException;
import com.padrao.mvc.mvc.repositories.ProductRepository;
import com.padrao.mvc.mvc.services.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    @Test
    public void deveLancarExcecaoQuandoValorProdutoForZeroOuMenor(){
        Product p = new Product(1L,"Smartphone",-3500,"SMARTPHONE LINDO");
        
        assertThrows(ProductInvalidPriceException.class, ()-> productService.save(p));
    }

}
