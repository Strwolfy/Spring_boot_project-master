package web.SMikhail.dao;

import web.SMikhail.modal.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
       Role getRoleByName(String name);
}
