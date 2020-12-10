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

    @GetMapping("/find/{title}")
    public Lesson getByTitle(@PathVariable String title){

        return this.repository.findByTitle(title);

    }



    @GetMapping("/{id}")
    public Optional<Lesson> getById(@PathVariable String id) {

        return this.repository.findById(Long.parseLong(id));
    }
    @PatchMapping("/{id}")
    public Lesson patchId(@PathVariable String id, @RequestBody Lesson lesson){
        Lesson updated = new Lesson();

        Optional<Lesson> updateThis = this.repository.findById(Long.parseLong(id));
        updateThis.ifPresent(record -> {
            record.setTitle(lesson.getTitle());
            record.setDeliveredOn(lesson.getDeliveredOn());
        });
        if (updateThis.isPresent()){
            updated = updateThis.get();
        }

       return this.repository.save(updated);

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
