package com.padrao.mvc.mvc.tests_controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.padrao.mvc.mvc.controllers.ProductController;
import com.padrao.mvc.mvc.models.product.Product;
import com.padrao.mvc.mvc.services.ProductService;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    public void deveCadastrarProduto() throws Exception {
        // Criando um produto de teste
        Product p = new Product(null, "Smartphone", 2400.0, "Smartphone samsung galaxy s24 ultra");
        Product pSaida = new Product(1L, "Smartphone", 2400.0, "Smartphone samsung galaxy s24 ultra");
    
        // Configurando o mock do serviço para retornar o produto salvo
        when(productService.save(any(Product.class))).thenReturn(pSaida);
    
        // Realizando a requisição POST e verificando o status e o conteúdo
        mockMvc.perform(post("/product/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(p)))
                .andExpect(status().isCreated())  // Espera o status 201 (Created)
                .andExpect(jsonPath("$.id", is(1)))  // Verifica se o id retornado é 1
                .andExpect(jsonPath("$.nome", is("Smartphone")))  // Verifica o nome do produto
                .andExpect(jsonPath("$.preco", is(2400.0)))  // Verifica o preço do produto
                .andExpect(jsonPath("$.descricao", is("Smartphone samsung galaxy s24 ultra")));  // Verifica a descrição
    }

}