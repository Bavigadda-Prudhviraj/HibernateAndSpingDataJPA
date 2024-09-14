package com.prudhviraj.hibernateAndJpa.entites;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "sku", columnNames = {"sku"}),
                @UniqueConstraint(name = "title_price_unique", columnNames = {"title","price"})
        },
        indexes = {
                @Index(name = "sku_idx",columnList = "sku")
        }

)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String sku;
    private String title;
    private BigDecimal price;
    private int quantity;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
