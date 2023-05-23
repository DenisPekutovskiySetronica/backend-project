package com.project.depi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "book", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title"})
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter
    private Long id;

    @Setter
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Setter
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Setter
    @Column(name = "title", nullable = false)
    private String title;

    public Book(String firstName, String lastName, String title) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
    }
}