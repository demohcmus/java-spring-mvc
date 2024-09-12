package vn.hoidanit.laptopshop.repository;

import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
    
}
