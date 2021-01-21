package com.architecture.lessons.services;

import com.architecture.lessons.entities.Product;
import com.architecture.lessons.entities.dto.ProductDto;
import com.architecture.lessons.repositories.ProductRepository;
import com.architecture.lessons.utils.MyPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public MyPage<ProductDto> findAll(Specification<Product> spec, int page, int size) {
        Page<Product> content = productRepository.findAll(spec, PageRequest.of(page, size));
        return new MyPage<>(content.getContent().stream().map(ProductDto::new).collect(Collectors.toList()), content.getPageable(), content.getTotalElements());
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
