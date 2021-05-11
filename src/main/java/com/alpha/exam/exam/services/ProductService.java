package com.alpha.exam.exam.services;

import com.alpha.exam.exam.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.alpha.exam.exam.model.Product;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Product> findProductByContinent(String continent) {
        List<Product> productList = productRepository.findByContinent(continent);
        if(productList != null && !productList.isEmpty()){
            for(Product product: productList) {
                product.setMultipliedValue(calculateMultipliedValue(product));
            }
        }
        return productRepository.findByContinent(continent);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public Product insertProduct(Product newProduct) {
        Product product = null;
        if(newProduct != null) {
            newProduct.setCreatedAt(LocalDateTime.now());
            product = productRepository.save(newProduct);
            product.setMultipliedValue(calculateMultipliedValue(product));
        }

        return product;
    }

    private BigDecimal calculateMultipliedValue(Product product) {
        BigDecimal price = product.getPrice();
        BigDecimal multiplier = product.getMultiplier();
        return price.multiply(multiplier).setScale(6, RoundingMode.FLOOR);
    }
}
