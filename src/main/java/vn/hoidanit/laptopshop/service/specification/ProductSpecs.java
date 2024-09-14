package vn.hoidanit.laptopshop.service.specification;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Product_;

public class ProductSpecs {
       public static Specification<Product> nameLike(String name){
        return (root, query, criteriaBuilder) 
            -> criteriaBuilder.like(root.get(Product_.NAME), "%"+name+"%");
      }

      // case 1: minPrice
      public static Specification<Product> minPrice(double min){
        return (root, query, criteriaBuilder) 
            -> criteriaBuilder.ge(root.get(Product_.PRICE), min);
      }

      // case 2: maxPrice
      public static Specification<Product> maxPrice(double max){
            return (root, query, criteriaBuilder) 
                -> criteriaBuilder.le(root.get(Product_.PRICE), max);
      }

      // case 3: factory
      public static Specification<Product> matchFactory(String factory){
        return (root, query, criteriaBuilder) 
            -> criteriaBuilder.equal(root.get(Product_.FACTORY), factory);
      }

      // case 4: list of factory
      public static Specification<Product> matchListFactory(List<String> factories){
        return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get(Product_.FACTORY)).value(factories); 
      }

      // case 5: minPrice and maxPrice
      public static Specification<Product> matchPrice(double min, double max){
        return (root, query, criteriaBuilder) 
            -> criteriaBuilder.between(root.get(Product_.PRICE), min, max);
            //-> criteriaBuilder.and(criteriaBuilder.ge(root.get(Product_.PRICE), min),
            // criteriaBuilder.le(root.get(Product_.PRICE), max));
      }

      // case 6: minPrice and factory
}
