package com.zamuken.Spring_boot_curso.product.infrastructure.dataBase.apiRest;

import com.zamuken.Spring_boot_curso.common.mediator.Mediator;
import com.zamuken.Spring_boot_curso.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final Mediator mediator;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String PageSize) {
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .stream().findFirst();

        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Void> saveProductById(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.created(URI.create("/api/v1/products".concat(product.getId().toString()))).build();
    }

    @PutMapping("")
    public ResponseEntity<Product> updateProductById(@RequestBody Product product) {
        Product productSelected = products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        productSelected.setName(product.getName());
        productSelected.setDescription(product.getDescription());
        productSelected.setPrecio(product.getPrecio());
        productSelected.setImage(product.getImage());

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        products.removeIf(p -> p.getId().equals(id));

        return ResponseEntity.noContent().build();
    }
}
