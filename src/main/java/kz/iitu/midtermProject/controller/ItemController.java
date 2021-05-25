package kz.iitu.midtermProject.controller;

import io.swagger.annotations.Api;
import kz.iitu.midtermProject.model.User;
import kz.iitu.midtermProject.model.Item;
import kz.iitu.midtermProject.service.iItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@Api(value = "Item Controller class", description = "This class allows to interact with Item object")
public class ItemController {

    @Autowired
    private iItemService iItemService;

    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id) {
        return iItemService.getById(id);
    }

    @PostMapping("/create")
    public Item create(@RequestBody Item o) {
        return iItemService.create(o);
    }

    @PostMapping("/update")
    public Item update(@RequestBody Item o) {
        return iItemService.update(o);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        iItemService.delete(id);
    }

    @GetMapping("/all")
    public List<Item> getAll() {
        return iItemService.getAll();
    }

    @GetMapping("/all/info/{info}")
    public List<Item> getAllByInfo(@PathVariable String info) {
        return iItemService.getAllByDesc(info);
    }

    @GetMapping("/all/user/{id}")
    public List<Item> getAllByCustomer(@PathVariable Long id) {
        return iItemService.getAllByCustomer(id);
    }

    @GetMapping("/all/name/{name}")
    public List<Item> getAllByName(@PathVariable String name) {
        return iItemService.getAllByName(name);
    }
}
