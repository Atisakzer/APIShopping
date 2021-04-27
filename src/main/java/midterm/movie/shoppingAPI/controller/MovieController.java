package midterm.movie.shoppingAPI.controller;


import midterm.movie.shoppingAPI.model.Movie;
import midterm.movie.shoppingAPI.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    public MovieController(MovieRepository repository) {
        this.movieRepository = repository;
    }


    @GetMapping("/Year/{Year}")
    public List<Movie> getAllYear(@PathVariable int Year) {
        List<Movie> record = movieRepository.findAll();
        List<Movie> respone = new ArrayList<>();
        for (Movie item : record) {
            if (item.getYear() == Year) {
                respone.add(item);
            }
        }
        return respone;
    }

    @GetMapping("/Name/{name}")
    public List<Movie> getAllName(@PathVariable String name) {
        List<Movie> record = movieRepository.findAll();
        List<Movie> respones = new ArrayList<>();
        for (Movie item : record) {
            if (item.getName().contains(name)) {
                respones.add(item);
            }
        }
        return respones;
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getOne(@PathVariable int id) {
        return movieRepository.findById(id).get();
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        Movie record = movieRepository.save(movie);
        return record;
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable int id,
                              @RequestBody Movie movie) {
        Movie record = movieRepository.findById(id).get();
        record.setName(movie.getName());
        record.setYear(movie.getYear());
        record.setDetail(movie.getDetail());
        movieRepository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable int id) {
        Movie record = movieRepository.findById(id).get();
        movieRepository.deleteById(id);
        return record;
    }

}
