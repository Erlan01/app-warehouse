package pdp.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.entity.User;
import pdp.uz.model.UserAddDto;
import pdp.uz.model.UserDto;
import pdp.uz.model.resp.UserReport;
import pdp.uz.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    private UserDto add(@RequestBody UserAddDto dto) {
        return userService.add(dto);
    }

    @GetMapping("/get/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/get/{id}")
    public User getById(@PathVariable Long id){
        return userService.get(id);
    }

    @GetMapping("/get/{warehouseId}")
    public List<UserReport> getByWarehouse(@PathVariable Long warehouseId){
        return userService.getByWarehouse(warehouseId);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody UserAddDto dto){
        return userService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
