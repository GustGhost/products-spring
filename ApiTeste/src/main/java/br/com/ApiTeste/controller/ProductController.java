package br.com.ApiTeste.controller;

import br.com.ApiTeste.model.Product;
import br.com.ApiTeste.model.ProductID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product){
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result)
                ;
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        List<Product> result = new ArrayList<>();
            result.add(new Product("1", "produto 1", new BigDecimal("123.12")));
            result.add(new Product("2", "produto 2", new BigDecimal("432.453")));
            result.add(new Product("3", "produto 3", new BigDecimal("613.89")));
        return result;
    }

    @GetMapping("product/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println(id);
        return new Product("1", "produto 1", new BigDecimal("123.12"));
    }

    @DeleteMapping("product/{id}")
    public String deleteProductById(@PathVariable final String id){
        System.out.println(id);
        return "Produto deletado com sucesso";
    }

    @PutMapping("product/{id}")
    public ResponseEntity<Product> alterProduct(@PathVariable String id, @RequestBody final Product product){
        System.out.println(id);
        Product result = new Product(product.getId(), product.getDescription(), product.getPrice());
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result)
                ;
    }

}
