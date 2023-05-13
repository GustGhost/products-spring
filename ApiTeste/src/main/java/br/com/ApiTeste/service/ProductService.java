package br.com.ApiTeste.service;

import br.com.ApiTeste.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProductById(Long id){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null)
                ;
    }

   public Product createProduct(Product product){
        Long newId = (long) (products.size() + 1);
        product.setId(newId);
        products.add(product);
       System.out.println(product);
        return product;
   }

   public Product updateProductById(Long id, Product updatedProduct){
        Product existingProduct = getProductById(id);
        if(existingProduct != null){
            updatedProduct.setId(id);
            int index = products.indexOf(existingProduct);
            products.set(index, updatedProduct);
            return updatedProduct;
        }
        return null;
   }

   public void deleteProduct(Long id){
        Product existingProduct = getProductById(id);
        products.remove(existingProduct);
   }
}
