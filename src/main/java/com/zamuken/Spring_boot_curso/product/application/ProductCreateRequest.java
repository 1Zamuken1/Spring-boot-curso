package com.zamuken.Spring_boot_curso.product.application;

import com.zamuken.Spring_boot_curso.common.mediator.Request;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductCreateRequest implements Request<Void> {
    private Long id;
    private String name;
    private String description;
    private Double precio;
    private String image;
}
