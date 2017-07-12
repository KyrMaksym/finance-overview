package service.Impl;

import dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.RoleEntity;
import repository.RoleRepository;
import service.RoleService;

import java.util.List;

/**
 * Created by Vladimir on 12.07.2017.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public void deleteRole(Integer id) {

    }

    @Override
    public RoleDTO updateRole(Integer Id, RoleDTO roleDTO) {
        return null;
    }

    @Override
    public RoleDTO getRoleById(Integer roleId) {
        RoleDTO roleDTO = new RoleDTO();
        RoleEntity roleEntity = roleRepository.findOne(roleId);
        roleDTO.setId(roleEntity.getId());
        roleDTO.setName(roleEntity.getName());

        return roleDTO;
    }

    @Override
    public List<RoleDTO> getAllRoleByName() {
        return null;
    }
}
