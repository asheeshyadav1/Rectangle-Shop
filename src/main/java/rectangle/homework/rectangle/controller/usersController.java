package rectangle.homework.rectangle.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import rectangle.homework.rectangle.model.User;
import rectangle.homework.rectangle.model.UserRepository;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class usersController {

    @Autowired
    private UserRepository userRepo; 

    @GetMapping("/users/view")
    public String getAllUsers(Model model) {
        System.out.println("Get all users");
        List<User> users = userRepo.findAll();
        model.addAttribute("us", users);
        return "users/product";
    }
    
    @PostMapping("/users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        System.out.println("ADD user");
        String name = newuser.get("name");
        String color = newuser.get("color");
        float width = Float.parseFloat(newuser.get("width"));
        float height = Float.parseFloat(newuser.get("height"));
        String delete = newuser.get("delete"); 
        userRepo.save(new User(name, color, width, height,delete));
        response.setStatus(201);
        return "users/addedUser";
     }

     @GetMapping("/users/{name}")
public String getUser(@PathVariable String name, Model model) {
    List<User> users = userRepo.findByName(name);
    if (!users.isEmpty()) {
        User user = users.get(0);
        model.addAttribute("user", user);
    }
    return "users/specUser";
}

@PostMapping("/users/delete/{name}")
public String delUser(@PathVariable String name, Model model) {
    List<User> users = userRepo.findByName(name);
    userRepo.deleteAll(users);
    return "users/DelUser";
}
@PostMapping("/users/edit/{name}")
public String editUser(@PathVariable String name, @RequestParam Map<String, String> updatedUser, Model model) {
    List<User> users = userRepo.findByName(name);
    if (!users.isEmpty()) {
        User user = users.get(0);
        user.setName(updatedUser.get("name"));
        user.setColor(updatedUser.get("color"));
        user.setWidth(Float.parseFloat(updatedUser.get("width")));
        user.setHeight(Float.parseFloat(updatedUser.get("height")));
        userRepo.save(user);
        model.addAttribute("user", user);
        return "users/updatedUser";
    } else {
        // Handle the case where no user with the given name is found
        model.addAttribute("error", "No user found with name: " + name);
        return "error";
    }
}
}


