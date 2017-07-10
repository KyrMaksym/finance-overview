package controller;

import dto.UserDTO;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

/**
 * Created by BSyvuliak on 09.07.2017.
 */
@Controller("/users")
public class UserController {
    //TODO
    //TODO2
    @Autowired
    UserService userService;

    @RequestMapping(name = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(name="{/id}", method =RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDTO updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }



}
