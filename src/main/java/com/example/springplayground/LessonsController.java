package com.example.springplayground;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {

        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Lesson> getById(@PathVariable String id) {

        return this.repository.findById(Long.parseLong(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {

         this.repository.deleteById(Long.parseLong(id));
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }
}
