package controller;


import dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.RoleService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Vladimir on 12.07.2017.
 */
@RestController
@RequestMapping({"/role"})
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(path="/create", method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDTO createRole(RoleDTO roleDTO) {
        return roleService.createRole(roleDTO);
    }

    @RequestMapping(path="/{id}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDTO getRole(@PathVariable Integer id) {
        return roleService.getRoleById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    RoleDTO updateUser(@PathVariable Integer id, @RequestBody RoleDTO roleDTO) {
        return roleService.updateRole(id, roleDTO);
    }
}
