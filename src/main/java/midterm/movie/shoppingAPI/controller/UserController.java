package midterm.movie.shoppingAPI.controller;

import midterm.movie.shoppingAPI.model.User;
import midterm.movie.shoppingAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    @GetMapping("/login/{username}/{password}")
    public User getAllName(@PathVariable String username,@PathVariable String password) {
        List<User> record = userRepository.findAll();
        User respones = new User();
        for (User item : record) {
            if (item.username == username && item.password == password) {
                respones =item;
            }
        }
        return respones;
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable int id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        User record = userRepository.save(user);
        return record;
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id,
                        @RequestBody User user) {
        User record = userRepository.findById(id).get();
        record.setFirstName(user.getFirstName());
        record.setLastName(user.getLastName());
        record.setEmail(user.getEmail());
        record.setTel(user.getTel());
        record.setLocation(user.getLocation());
        userRepository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id) {
        User record = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return record;
    }

}
