package midterm.movie.shoppingAPI.controller;


import midterm.movie.shoppingAPI.model.Movie;
import midterm.movie.shoppingAPI.model.OrderBuy;
import midterm.movie.shoppingAPI.repository.OrderBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderBuyController {
    @Autowired
    private OrderBuyRepository orderBuyRepository;

    public OrderBuyController(OrderBuyRepository repository) {
        this.orderBuyRepository = repository;
    }

    @GetMapping
    public List<OrderBuy> getAll() {
        return orderBuyRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrderBuy getOne(@PathVariable int id) {
        return orderBuyRepository.findById(id).get();
    }

    @GetMapping("/userbuy/{userId}")
    public List<OrderBuy> getUserbuy(@PathVariable int userId) {
        List<OrderBuy> record = orderBuyRepository.findAll();
        List<OrderBuy> respone = new ArrayList<>();
        for (OrderBuy item : record) {
            if (item.getUserBuy_id() == userId) {
                respone.add(item);
            }
        }
        return respone;
    }

    @GetMapping("/usersell/{userId}")
    public List<OrderBuy> getUserSell(@PathVariable int userId) {
        List<OrderBuy> record = orderBuyRepository.findAll();
        List<OrderBuy> respone = new ArrayList<>();
        for (OrderBuy item : record) {
            if (item.getUserSell_id() == userId) {
                respone.add(item);
            }
        }
        return respone;
    }

    @PostMapping
    public OrderBuy create(@RequestBody OrderBuy orderBuy) {
        OrderBuy record = orderBuyRepository.save(orderBuy);
        return record;
    }

    @DeleteMapping("/{id}")
    public OrderBuy delete(@PathVariable int id) {
        OrderBuy record = orderBuyRepository.findById(id).get();
        orderBuyRepository.deleteById(id);
        return record;
    }
}
