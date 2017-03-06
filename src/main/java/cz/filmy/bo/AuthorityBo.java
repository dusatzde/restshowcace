package cz.filmy.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zdenek on 07-Dec-16.
 * Security roles
 */

@Entity
public class AuthorityBo implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorityId;

    @NotEmpty
    private String name;

    private String description;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authorities")
    private Set<UserBo> users = new HashSet<UserBo>();

    @Override
    public String getAuthority() {
        return this.name;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserBo> getUsers() {
        return users;
    }

    public void setUsers(Set<UserBo> users) {
        this.users = users;
    }
}
