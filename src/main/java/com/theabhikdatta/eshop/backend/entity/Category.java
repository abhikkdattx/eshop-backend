package com.theabhikdatta.eshop.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = { "name" }
                )
        }
)
public class Category {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @NotEmpty(message = "name should not be null or empty")
    @Size(min = 3, max = 100, message = "name must be between 3 and 100 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "image must not be empty")
    @Column(name = "image", nullable = false)
    private String image;

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Product> products;
}
