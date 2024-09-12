package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.OrderDetailRepository;
import vn.hoidanit.laptopshop.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    
    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }
    
    public List<Order> fetchAllOrders(){
        return this.orderRepository.findAll();
    }

    public Optional<Order> fetchOrderById(long id){
        return this.orderRepository.findById(id);
    }

    public void deleteOrderById(long id){
        // delete order details first
        Optional<Order> orderOptional = this.orderRepository.findById(id);
        if(orderOptional.isPresent()){
            Order order = orderOptional.get();
            List<OrderDetail> orderDetails = order.getOrderDetails();
            for(OrderDetail orderDetail: orderDetails){
                this.orderDetailRepository.deleteById(orderDetail.getId());
            }
        }
        this.orderRepository.deleteById(id);
    }

    public Order saveOrder(Order order){
        return this.orderRepository.save(order);
    }
    public void updateOrder(Order order){
        Optional<Order> orderOptional = this.orderRepository.findById(order.getId());
        if(orderOptional.isPresent()){
            Order currentOrder= orderOptional.get();
            currentOrder.setStatus(order.getStatus());
            this.orderRepository.save(currentOrder);
        }
    }
    public List<Order> fetchOrderByUser(User user) {
        return this.orderRepository.findByUser(user);
    }
    public Page<Order> fetchAllOrders(Pageable page) {
        return this.orderRepository.findAll(page);
    }
}
