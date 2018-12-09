package com.mate.hackathon.aug2018.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany()
    @JoinTable(
            name = "USERS_TO_ROLES",
            joinColumns = { @JoinColumn(name = "FK_ROLE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "FK_USER_ID") }
            )
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String roleName) {
        this.name = roleName;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public static Role of(RoleName roleName) {
        return new Role(roleName.name());
    }

    public enum RoleName {
        ADMIN(1L),
        USER(2L);

        public final Long roleId;

        RoleName(Long rileId) {
            this.roleId = rileId;
        }
    }
}