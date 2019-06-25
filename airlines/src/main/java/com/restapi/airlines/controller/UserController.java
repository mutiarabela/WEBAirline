package com.restapi.airlines.controller;

import com.restapi.airlines.model.User;
import com.restapi.airlines.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
//@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping(path = "/{idUser}",
//                produces = { MediaType.APPLICATION_JSON_VALUE,
//                             MediaType.APPLICATION_XML_VALUE  })
//    public ResponseEntity getUser(@PathVariable String idUser){ //Get specific user
//        UserResponseModel getUserValue = userService.getUser(idUser);
//        if (getUserValue != null) {
//            return new ResponseEntity<>(getUserValue, HttpStatus.OK);
//        } else {
//            throw new UserNotFoundException();
//        }
//    }
//
//    @GetMapping()
//    public ResponseEntity getAllUser(){ //Get all added user
//        Collection getAllUserValue = userService.getAllUser();
//        return new ResponseEntity<>(getAllUserValue, HttpStatus.OK);
//    }
//
//    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
//                              MediaType.APPLICATION_JSON_VALUE },
//                 produces = { MediaType.APPLICATION_XML_VALUE,
//                              MediaType.APPLICATION_JSON_VALUE }
//    )
//    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){ //Create user
//        UserResponseModel createUserValue = userService.createUser(userDetails);
//        return new ResponseEntity<>(createUserValue, HttpStatus.CREATED);
//    }
//
//    @PutMapping(path = "/{idUser}",
//                consumes = { MediaType.APPLICATION_XML_VALUE,
//                             MediaType.APPLICATION_JSON_VALUE },
//                produces = { MediaType.APPLICATION_XML_VALUE,
//                             MediaType.APPLICATION_JSON_VALUE }
//    )
//    public ResponseEntity<UserResponseModel> updatePhoneNumUser(@PathVariable String idUser, @Valid @RequestBody UserDetailsRequestModel userDetails){ //Update user's phone number
//        UserResponseModel updatePhoneNumUserValue = userService.updatePhoneNumUser(idUser, userDetails);
//        if (updatePhoneNumUserValue != null) {
//            return new ResponseEntity<>(updatePhoneNumUserValue, HttpStatus.OK);
//        } else {
//            throw new UserNotFoundException("Update Failed, User Not Found");
//        }
//    }
//
//    @DeleteMapping(path = "/{idUser}")
//    public ResponseEntity deleteUser(@PathVariable String idUser){ //Delete user
//        UserResponseModel deleteUserValue = userService.deleteUser(idUser);
//        if (deleteUserValue != null) {
//            return new ResponseEntity<>(deleteUserValue, HttpStatus.OK);
//        } else {
//            throw new UserNotFoundException("Delete Failed, User Not Found");
//        }
//    }

    @GetMapping("/signup")
    public String showCreateForm(@Valid User user, Model model){
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping("/addUser")
    public String createUser(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-user";
        }

        userService.createUser(user);
        model.addAttribute("users", userService.getAllUser());
        log.info(userService.getAllUser().toString());
        return "index";
    }

    @GetMapping("/index")
    public String showAllUser(@Valid User user, BindingResult result, Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping("/edit/{idUser}")
    public String showUpdateForm(@PathVariable("idUser") int idUser, Model model) {
        User user = userService.getUser(idUser);
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{idUser}")
    public String updateUser(@PathVariable("idUser") int idUser, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setIdUser(idUser);
            return "update-user";
        }
        userService.updateUser(idUser, user);
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping("/delete/{idUser}")
    public String deleteUser(@PathVariable("idUser") int idUser, Model model) {
        userService.deleteUser(idUser);
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

}