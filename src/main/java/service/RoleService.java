package service;

import dto.RoleDTO;

import java.util.List;

/**
 * Created by Vladimir on 12.07.2017.
 */
public interface RoleService {
    RoleDTO createRole(RoleDTO roleDTO);

    void deleteRole(Integer id);

    RoleDTO updateRole(Integer Id,RoleDTO roleDTO);

    RoleDTO getRoleById(Integer roleId);

    List<RoleDTO> getAllRoleByName();
}
