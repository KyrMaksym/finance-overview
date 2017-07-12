package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.UserEntity;

/**
 * Created by BSyvuliak on 11.07.2017.
 */
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
