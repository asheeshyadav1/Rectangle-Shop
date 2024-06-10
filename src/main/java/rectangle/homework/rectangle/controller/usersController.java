/*
 * AUTHOR: Asheesh Yadav
 * DESCRIPTION: This class is the controller for the users making the rectangles
 * DATE: 6/14/2024
 *
 */
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

//This class is the controller for the users making the rectangles 
//it includes the endpoints that add, view, delete, and edit user data
@Controller
public class usersController {

    @Autowired
    private UserRepository userRepo; 

    //This method is used to show all the users in the database(using a table)
    //we use this on the products page and show only a little about the users rectangle
    //returns them to product.html where it shows all users rectangle(not all attributes are shown)
    @GetMapping("/users/view")
    public String getAllUsers(Model model) {
        System.out.println("Get all users");
        List<User> users = userRepo.findAll();
        model.addAttribute("us", users);
        return "users/product";
    }
    
    //This method is used to add a user to the database
    // takes in appropriate parameters and saves them to the database
    // it is called in the add.html page when the user wants to add a new rectangle
    //returns them to addedUser.html where it shows the user's rectangle has been added and allows them 
    //to go back to the product/add page
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

    //This method is used to view a specific user in the database
    // this is the endpoint for when the user presses on a link on the products page
    // or the view all users endpoint(users/view)
    //allows for the user to get specific information about a user
    //returns them to specUser.html where it shows all of users rectangle attributes
    @GetMapping("/users/{name}")
    public String getUser(@PathVariable String name, Model model) {
    List<User> users = userRepo.findByName(name);
    if (!users.isEmpty()) {
        User user = users.get(0);
        model.addAttribute("user", user);
    }
    return "users/specUser";
}

//This method is used to delete a user rectangle from the database
// this is the endpoint for when the user presses the delete button on the products page
//returns them to DelUser.html where it shows the user's rectangle has been deleted and allows them
//to go back to the product/add page
@PostMapping("/users/delete/{name}")
public String delUser(@PathVariable String name, Model model) {
    List<User> users = userRepo.findByName(name);
    userRepo.deleteAll(users);
    return "users/DelUser";
}
//This method is used to edit a user rectangle from the database
// this is the endpoint for when the user presses the edit button when viewing a specific user's 
//rectangles attributes on the specUser.html page
//returns them to updatedUser.html where it shows the user's rectangle has been updated and allows them
//to go back to the product/add page
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
        // incase no user is found
        model.addAttribute("error", "No user found with name: " + name);
        return "error";
    }
}
}


