package service.Impl;

import dto.UserDTO;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by BSyvuliak on 09.07.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public UserDTO updateUser(Integer Id, UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsersByName() {
        return null;
    }
}
