package cz.filmy.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zdenek on 05-Dec-16.
 */

@Entity
@Table(name = "USER_BO")
public class UserBo implements Serializable{


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String userName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String userEmail;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "authority_id") })
    private Set<AuthorityBo> authorities = new HashSet<AuthorityBo>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<CommentBo> commnets;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AuthorityBo> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AuthorityBo> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UserBo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
