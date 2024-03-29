package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderQueryDTO;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ManyToOne, One-to-One; X-to-One
 * Order
 * Order -> Member
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleController {

    private final OrderRepository orderRepository;
    // private final OrderService orderService;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> getOrdersV1() {
        List<Order> allOrders = orderRepository.findAllByString(new OrderSearch());
        // List<Order> allOrders = orderService.findOrders(new OrderSearch());
        for (Order order : allOrders) {
            order.getMember().getName();
            order.getDelivery().getAddress();
        }
        return allOrders;
    }

    @GetMapping("/api/v2/simple-orders")
    public List<OrderDTO> ordersV2() {
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<OrderDTO> result = orders.stream()
                .map(o -> new OrderDTO(o))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v3/simple-orders")
    public List<OrderDTO> ordersV3() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();
        List<OrderDTO> result = orders.stream()
                .map(o -> new OrderDTO(o))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v4/simple-orders")
    public List<OrderQueryDTO> ordersV4() {
        return orderRepository.findOrderDTO();
    }

    @Data
    static class OrderDTO {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public OrderDTO(Order o) {
            orderId = o.getId();
            name = o.getMember().getName();
            orderDate = o.getOrderDate();
            orderStatus = o.getStatus();
            address = o.getDelivery().getAddress();
        }
    }
}