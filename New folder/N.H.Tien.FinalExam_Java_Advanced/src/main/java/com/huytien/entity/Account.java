package com.huytien.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "`Account`")
@NoArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", length = 50, unique = true, nullable = false, updatable = false)
    private String username;

    @Column(name = "`password`", length = 200, nullable = false)
    private String password;

    @Column(name = "first_name", length = 50, nullable = false, updatable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false, updatable = false)
    private String lastName;

    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public enum Role {
        ADMIN, EMPLOYEE, MANAGER;
    }

    @PrePersist
    public void prePersist(){
        if (role == null){
            role = Role.EMPLOYEE;
        }

        if (password == null) {
            password = new BCryptPasswordEncoder().encode("123456");
        }
    }
}
