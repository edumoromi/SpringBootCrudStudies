package com.springboot.crud.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;



@Controller
public class UserControler {

    private final UserRepository userRepository;

    public UserControler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*@RequestMapping(value ="/signup",method = RequestMethod.GET)
    public String showSignUpForm(User user) {
        return "add-user";
    }
    */
    @RequestMapping(value ="/adduser", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody @Valid User user, BindingResult result, Model model) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value ="/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> showUser(@PathVariable("id") int id, Model model) {
        User user = userRepository.findById(id)
                .orElse(null);;
        if (user != null) {
            model.addAttribute("user", user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value="/update/{id}",method = RequestMethod.PATCH)
    public ResponseEntity updateUser(@PathVariable("id") int id, @RequestBody @Valid User user, BindingResult result, Model model) {
        User UserEdit = userRepository.findById(id)
                .orElse(null);;
        if (UserEdit !=null) {
            UserEdit.setName(user.getName());
            UserEdit.setEmail(user.getEmail());
            return ResponseEntity.ok().body(userRepository.save(UserEdit));
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id, Model model) {
        User user = userRepository.findById(id)
                .orElse(null);;
        if (user != null){
            userRepository.delete(user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value ="/getall",method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return ResponseEntity.ok(userRepository.findAll());
    }
}
