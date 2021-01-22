package com.architecture.lessons.repositories.specifications;


import com.architecture.lessons.entities.Category;
import com.architecture.lessons.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(Float minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(Float maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> nameLike(String namePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), String.format("%%%s%%", namePart.toLowerCase()));
    }

    public static Specification<Product> categoryIn(List<Category> categories) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> root.get("category").in(categories);
    }
}
