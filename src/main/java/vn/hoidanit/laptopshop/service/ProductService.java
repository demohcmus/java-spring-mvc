package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    public Product getProductById(long id) {
        Product ngo = this.productRepository.findById(id).orElse(null);
        return ngo;
    }

    public Product handleSaveProduct(Product product) {
        Product ngo = this.productRepository.save(product);
        System.out.println(ngo);
        return ngo;
    }

    public void deleteProduct(long id)
    {
        this.productRepository.deleteById(id);
    }
}