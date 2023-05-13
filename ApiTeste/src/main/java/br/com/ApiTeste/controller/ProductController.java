package br.com.ApiTeste.controller;

import br.com.ApiTeste.model.Product;
import br.com.ApiTeste.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Apagado com sucesso!";
    }
//
    @PutMapping("/{id}")
    public Product alterProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProductById(id, product);
    }

}
