package midterm.movie.shoppingAPI.controller;


import midterm.movie.shoppingAPI.model.*;
import midterm.movie.shoppingAPI.repository.OrderBuyRepository;
import midterm.movie.shoppingAPI.repository.ProductSellRepository;
import midterm.movie.shoppingAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderBuyController {
    @Autowired
    private OrderBuyRepository orderBuyRepository;
    private ProductSellRepository productSellRepository;
    private UserRepository userRepository;

    public OrderBuyController(OrderBuyRepository repository,ProductSellRepository productRepository,UserRepository userRepository) {
        this.orderBuyRepository = repository;
        this.productSellRepository = productRepository;
        this.userRepository = userRepository;
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
    public List<OrderBuyAndSell> getUserbuy(@PathVariable int userId) {
        List<OrderBuy> record = orderBuyRepository.findAll();
        List<OrderBuyAndSell> respone = new ArrayList<>();
        for (OrderBuy item : record) {
            if (item.userBuy_id == userId) {
                OrderBuyAndSell orderBuyAndSell = new OrderBuyAndSell();
                orderBuyAndSell.id = item.id;
                orderBuyAndSell.id_order = item.id;
                orderBuyAndSell.product_id = item.product_id;
                orderBuyAndSell.createdate = item.createdate;
                orderBuyAndSell.editdate = item.editdate;
                orderBuyAndSell.createBy = item.createBy;
                orderBuyAndSell.editBy = item.editBy;
                orderBuyAndSell.userBuy_id = item.userBuy_id;
                orderBuyAndSell.userSell_id = item.userSell_id;
                orderBuyAndSell.statusBuy_id = item.statusBuy_id;
                orderBuyAndSell.Tracking = item.Tracking;
                List<ProductSell> productSellList = productSellRepository.findAll();
                for (ProductSell p : productSellList) {
                    if (p.getUser_id() == userId) {
                        orderBuyAndSell.productSell = p;
                    }
                }

                List<User> UserList = userRepository.findAll();
                for (User p : UserList) {
                    if (p.getId() == userId) {
                        orderBuyAndSell.user = p;
                    }
                }

                respone.add(orderBuyAndSell);
            }
        }
        return respone;
    }

    @GetMapping("/usersell/{userId}")
    public List<OrderBuyAndSell> getUserSell(@PathVariable int userId) {
        List<OrderBuy> record = orderBuyRepository.findAll();
        List<OrderBuyAndSell> respone = new ArrayList<>();
        for (OrderBuy item : record) {
            if (item.getUserSell_id() == userId) {
                OrderBuyAndSell orderBuyAndSell = new OrderBuyAndSell();
                orderBuyAndSell.id = item.id;
                orderBuyAndSell.id_order = item.id;
                orderBuyAndSell.product_id = item.product_id;
                orderBuyAndSell.createdate = item.createdate;
                orderBuyAndSell.editdate = item.editdate;
                orderBuyAndSell.createBy = item.createBy;
                orderBuyAndSell.editBy = item.editBy;
                orderBuyAndSell.userBuy_id = item.userBuy_id;
                orderBuyAndSell.userSell_id = item.userSell_id;
                orderBuyAndSell.statusBuy_id = item.statusBuy_id;
                orderBuyAndSell.Tracking = item.Tracking;
                List<ProductSell> productSellList = productSellRepository.findAll();
                for (ProductSell p : productSellList) {
                    if (p.getUser_id() == userId) {
                        orderBuyAndSell.productSell = p;
                    }
                }

                List<User> UserList = userRepository.findAll();
                for (User p : UserList) {
                    if (p.getId() == userId) {
                        orderBuyAndSell.user = p;
                    }
                }

                respone.add(orderBuyAndSell);
            }
        }
        return respone;
    }

    @PostMapping
    public OrderBuy create(@RequestBody OrderBuy orderBuy) {
        ProductSell productSell = productSellRepository.findById(orderBuy.product_id).get();
        orderBuy.setUserSell_id(productSell.user_id);
        orderBuy.statusBuy_id = 1;
        OrderBuy record = orderBuyRepository.save(orderBuy);
        return record;
    }

    @PutMapping("/confirm/{id}")
    public OrderBuy confirm(@PathVariable int id) {
        OrderBuy record = orderBuyRepository.findById(id).get();
        record.statusBuy_id = 2;
        orderBuyRepository.save(record);
        return record;
    }

    @PutMapping("/destroy/{id}")
    public OrderBuy destroy(@PathVariable int id) {
        OrderBuy record = orderBuyRepository.findById(id).get();
        record.statusBuy_id = 3;
        orderBuyRepository.save(record);
        return record;
    }
    
    @PutMapping("updateBuy/{id}")
    public OrderBuy update(@PathVariable int id,@RequestBody OrderBuyAndSell orderBuyAndSell) {
        OrderBuy record = orderBuyRepository.findById(id).get();
        record.statusBuy_id = 3;
        orderBuyRepository.save(record);
        return record;
    }

    @PutMapping("Tracking/{id}")
    public OrderBuy updateTracking(@PathVariable int id,@RequestBody OrderBuy orderBuy) {
        OrderBuy record = orderBuyRepository.findById(id).get();
        record.statusBuy_id = 4;
        record.Tracking = orderBuy.Tracking;
        orderBuyRepository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public OrderBuy delete(@PathVariable int id) {
        OrderBuy record = orderBuyRepository.findById(id).get();
        orderBuyRepository.deleteById(id);
        return record;
    }
}
