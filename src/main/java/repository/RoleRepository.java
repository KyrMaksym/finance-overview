package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.RoleEntity;

/**
 * Created by Vladimir on 12.07.2017.
 */
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
}
