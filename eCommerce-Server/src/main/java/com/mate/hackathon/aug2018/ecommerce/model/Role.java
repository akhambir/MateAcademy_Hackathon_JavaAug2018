package com.mate.hackathon.aug2018.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_TO_ROLES",
            joinColumns = {@JoinColumn(name = "FK_ROLE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "FK_USER_ID")})
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public static Role of(RoleName  roleName) {
        return new Role(roleName.name());
    }

    public enum RoleName {
        ADMIN (1),
        USER (2);

        public final int roleId;

        RoleName(int rileId) {
            this.roleId = rileId;
        }
    }
}