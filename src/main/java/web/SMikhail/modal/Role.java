package web.SMikhail.modal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role")
    private String name;

    private @ManyToMany(mappedBy = "roleSet")
    Set<User> userSet;


    @Override
    public String getAuthority() {
        return name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
    @Override
    public String toString() {
        if (name.equals("ROLE_USER")) {
            return "USER - только просмотр информации";
        } else if (name.equals("ROLE_ADMIN")) {
            return "ADMIN - Вам доступны любые действия в системе";
        } else return "ADMIN + USER";
    }
}
