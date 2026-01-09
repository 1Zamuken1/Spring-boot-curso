package com.zamuken.Spring_boot_curso.product.infrastructure.dataBase.apiRest;

import com.zamuken.Spring_boot_curso.product.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductApi {
    ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String PageSize);

    ResponseEntity<Product> getProductById(@PathVariable Long id);

    ResponseEntity<Void> saveProductById(@RequestBody Product product);

    ResponseEntity<Product> updateProductById(@RequestBody Product product);

    ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}
