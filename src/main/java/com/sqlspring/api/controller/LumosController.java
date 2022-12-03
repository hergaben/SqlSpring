package com.sqlspring.api.controller;


import com.sqlspring.repository.StatRepository;
import com.sqlspring.sql.Stat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stats")
public class LumosController {

    private final StatRepository statRepository;

    @Autowired
    public LumosController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @GetMapping
    public List<Stat> list() {
        return statRepository.findAll();
    }

    @GetMapping("{id}")
    public Stat getOne(@PathVariable("id") Stat stat) {
        return stat;
    }


    @PostMapping
    public Stat create(@RequestBody Stat stat) {
        return statRepository.save(stat);
    }

    @PutMapping("{id}")
    public Stat update(
            @PathVariable("id") Stat statFromDB,
            @RequestBody Stat stat) {
        BeanUtils.copyProperties(stat, statFromDB, "id");

        return statRepository.save(statFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Stat stat) {
        statRepository.delete(stat);
    }

}


















