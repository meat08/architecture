package com.architecture.lessons.controllers;

import com.architecture.lessons.entities.Product;
import com.architecture.lessons.entities.dto.ProductDto;
import com.architecture.lessons.exceptions.ResourceNotFoundException;
import com.architecture.lessons.services.ProductService;
import com.architecture.lessons.utils.MyPage;
import com.architecture.lessons.utils.ProductFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(produces = "application/json")
    public MyPage<ProductDto> getAllProducts(@RequestParam(defaultValue = "1", name = "p") Integer page,
                                             @RequestParam Map<String, String> params) {
        ProductFilter productFilter = new ProductFilter(params);
        return productService.findAll(productFilter.getSpec(), page - 1, 5);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Product createProduct(@RequestBody Product p) {
        p.setId(null);
        return productService.save(p);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public Product updateProduct(@RequestBody Product p) {
        return productService.save(p);
    }

    @DeleteMapping
    public void deleteAll() {
        productService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
