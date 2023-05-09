package spring.controllers;
import org.springframework.web.bind.annotation.*;
import spring.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    // Targil:
    // GET
    // GET -- query params
    // GET/ID
    // POST
    // PUT/ID -- update/add
    // DELETE/ID
    // PATCH/ID -- update only if exists

    ArrayList<Order> orders = new ArrayList<>(Arrays.asList(new Order(1, "Computer"), new Order(2, "Television"),
            new Order(3, "Sport car")));
    @GetMapping(value = "/order")
    public List<Order> getAllOrders() {
        return orders;
    }
    @GetMapping(value = "/order_params")
    public  List<Order> getOrdersByParam(@RequestParam Integer id ,String name) {
        // localhost:8083/order_params?id=1&name=Computer
        List<Order> query_params = orders.stream().filter(
                        order -> (id == -1 || order.id == id) && (name.equals("incognito") || order.customerName.contains(name))).
                collect(Collectors.toList());
        return query_params;
    }


    @GetMapping(value = "/orderid/{id}")
    public List<Order> getOrderById(@PathVariable Integer id) {
        List<Order> idList = orders.stream()
                .filter(order -> order.id == id)
                .collect(Collectors.toList());
        return idList;
    }

    @PostMapping(value = "/orderpost")
    public Order postOrder(@RequestBody Order order) {
        orders.add(order);
        return order;
    }

    @DeleteMapping(value = "/orderdelete/{id}")
    public void deleteOrderById(@PathVariable Integer id){
        orders.removeIf(order -> order.id == id);
    }

    @PutMapping(value = "/orderput/{id}")
    public Order putOrder(@PathVariable Integer id, @RequestBody Order order){
        orders.removeIf(orde -> orde.id == id);
        orders.add(order);
        return order;
    }

    @PatchMapping(value = "/orderpatch/{id}")
    public void patchOrder(@PathVariable Integer id,@RequestBody Order order){
        for (Order ord: orders){
            if(ord.id == id){
                ord.setId(order.id);
                ord.setCustomerName(order.customerName);
            }
        }
    }




}
