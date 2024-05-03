package dev.kaichun.movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//this class is API layer for getting the request from the user and return the response.
//this class using the service class and delegating tasks pf fetching all movies from DB,
// and back to the API layer
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //    ResponseEntity是Spring框架提供的一个类，用于表示HTTP响应。它包含了响应的状态码、响应体以及其他相关的HTTP头信息。
//    在这个例子中，使用ResponseEntity<List<Movie>>来表示返回的响应，其中List<Movie>是电影对象的列表，HttpStatus.OK表示响应状态码为200，表示请求成功。
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);

        }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}

