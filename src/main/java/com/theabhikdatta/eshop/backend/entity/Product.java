package com.theabhikdatta.eshop.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "products"
)
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @NotEmpty(message = "title should not be null or empty")
    private String title;

    @NotNull(message = "price must not be empty")
    private double price;

    @NotEmpty(message = "description should not be null or empty")
    @Size(min = 10, message = "description should be at least 10 characters")
    private String description;

    @NotEmpty(message = "image cannot be null or empty")
    private String image;

    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "category_id",
            nullable = false
    )

    private Category category;
}
