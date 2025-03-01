package auth.auth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth.auth.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel,Long>{
    RoleModel findByRole(String name);
}
