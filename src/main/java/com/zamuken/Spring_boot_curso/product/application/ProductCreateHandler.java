package com.zamuken.Spring_boot_curso.product.application;

import com.zamuken.Spring_boot_curso.common.mediator.RequestHandler;
import com.zamuken.Spring_boot_curso.product.domain.Product;
import com.zamuken.Spring_boot_curso.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCreateHandler implements RequestHandler<ProductCreateRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(ProductCreateRequest request) {

        Product product = Product.builder()
                .id(1L)
                .name(request.getName())
                .description(request.getDescription())
                .precio(request.getPrecio())
                .image(request.getImage())
                .build();
        productRepository.upsert(product);
        return null;
    }

    @Override
    public Class<ProductCreateRequest> getRequestType() {
        return ProductCreateRequest.class;
    }
}
