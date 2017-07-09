package service;

import dto.UserDTO;

import java.util.List;

/**
 * Created by BSyvuliak on 09.07.2017.
 */
public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    void deleteUser(Integer id);

    UserDTO updateUser(Integer Id,UserDTO userDTO);

    UserDTO getUserById(Integer userId);

    List<UserDTO> getAllUsersByName();
}
