package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * ManyToOne, One-to-One; X-to-One
 * Order
 * Order -> Member
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleController {

    // private final OrderRepository orderRepository;
    private final OrderService orderService;

    @GetMapping("/api/v1/orders")
    public List<Order> getOrdersV1() {
        // List<Order> allOrders = orderRepository.findAllByString(new OrderSearch());
        List<Order> allOrders = orderService.findOrders(new OrderSearch());
        return allOrders;
    }
}