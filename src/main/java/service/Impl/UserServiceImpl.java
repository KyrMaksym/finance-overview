package service.Impl;

import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.UserEntity;
import repository.UserRepository;
import service.UserService;

import java.util.List;

/**
 * Created by BSyvuliak on 09.07.2017.
 */
@Service
public class UserServiceImpl extends  AbstractMapperService<UserEntity,UserDTO> implements UserService {

    @Autowired
    UserRepository userRepository;


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
        return toDTO(userRepository.findOne(userId));
    }

    @Override
    public List<UserDTO> getAllUsersByName() {
        return null;
    }

    @Override
    protected Class getDTOClass() {
        return UserDTO.class;
    }

    @Override
    protected Class getEntityClass() {
        return UserEntity.class;
    }
}
