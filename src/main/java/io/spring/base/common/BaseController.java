package io.spring.base.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BaseController<T>{

    @GetMapping
    ResponseEntity<Result> findAll();

    @GetMapping("{id}")
    ResponseEntity<Result> findById(@PathVariable String id);

    @PostMapping
    ResponseEntity<Result> insert(@RequestBody T t);

    @PutMapping("{id}")
    ResponseEntity<Result> update(@PathVariable String id, @RequestBody T t);

    @DeleteMapping("{id}")
    ResponseEntity<Result> delete(@PathVariable String id);
}