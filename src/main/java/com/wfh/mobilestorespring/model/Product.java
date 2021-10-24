package com.wfh.mobilestorespring.model;


import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Base64;
import java.util.Objects;

@Entity
@Table(name = "Product")
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String productName;
    String unitInStock;
    String unitPrice;
    String description;
    String manufacturer;
    String category;
    int productCondition;
    byte[] image;
    @Transient
    MultipartFile img;

    public String getImage() {
        if(image != null)
        return Base64.getEncoder().encodeToString(image);
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return 2042274511;
    }
}
