package ru.itgirl.libraryproject1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "role")
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Setter
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType roleType;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
