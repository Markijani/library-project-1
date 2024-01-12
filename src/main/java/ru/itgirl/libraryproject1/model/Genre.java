package ru.itgirl.libraryproject1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column(nullable = false)
    @Setter
    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<Book> books;
}
