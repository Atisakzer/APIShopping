package midterm.movie.shoppingAPI.controller;

import midterm.movie.shoppingAPI.model.ProductSell;
import midterm.movie.shoppingAPI.repository.ProductSellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/productSell")
public class ProductSellController {

    @Autowired
    private ProductSellRepository productSellRepository;

    public ProductSellController(ProductSellRepository productSellRepository) {
        this.productSellRepository = productSellRepository;
    }

    @GetMapping("/user/{userId}")
    public List<ProductSell> getByUser(@PathVariable int userId) {
        List<ProductSell> record = productSellRepository.findAll();
        List<ProductSell> response = new ArrayList<>();
        for (ProductSell p : record) {
            if (p.getUser_id() == userId) {
                response.add(p);
            }
        }
        return response;
    }

    @GetMapping
    public List<ProductSell> getAll() {
        return productSellRepository.findAll();
    }

    @GetMapping("no_id/{id}")
    public List<ProductSell> getnotAll(@PathVariable int id) {
        List<ProductSell> productSellList = productSellRepository.findAll();
        List<ProductSell> respone = new ArrayList<>();
        for (ProductSell productSell : productSellList) {
            if (productSell.user_id != id) {
                respone.add(productSell);
            }
        }
        return respone;
    }

    @GetMapping("/{id}")
    public ProductSell getOne(@PathVariable int id) {
        return productSellRepository.findById(id).get();
    }

    @PostMapping
    public ProductSell create(@RequestBody ProductSell productSell) {
        ProductSell record = productSellRepository.save(productSell);
        return record;
    }

    @PutMapping("/{id}")
    public ProductSell update(@PathVariable int id,
                              @RequestBody ProductSell productSell) {
        ProductSell record = productSellRepository.findById(id).get();
        record.setProductName(productSell.getProductName());
        record.setPrice(productSell.getPrice());
        record.setDetail(productSell.getDetail());
        record.setImage(productSell.getImage());
        record.setEditdate(new Date());
        record.setEditBy(productSell.getEditBy());
        productSellRepository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public ProductSell delete(@PathVariable int id) {
        ProductSell record = productSellRepository.findById(id).get();
        productSellRepository.deleteById(id);
        return record;
    }

}
