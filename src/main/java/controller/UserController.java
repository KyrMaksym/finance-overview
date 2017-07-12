package controller;

import dto.UserDTO;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by BSyvuliak on 09.07.2017.
 */
@RestController
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/create", method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @RequestMapping(path = "/{id}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }


}
