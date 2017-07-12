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
public class UserServiceImpl extends  AbstractMapperService implements UserService {

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

        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = userRepository.findOne(userId);
        userDTO.setId(userEntity.getId());
        userDTO.setLogin(userEntity.getLogin());
        userDTO.setName(userEntity.getName());
        userDTO.setRoleID(userEntity.getRoleEntity().getId());

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsersByName() {
        return null;
    }

    @Override
    protected Class getDTOClass() {
        return null;
    }

    @Override
    protected Class getEntityClass() {
        return null;
    }
}
