package dev.daniel.carshop.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table (name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
