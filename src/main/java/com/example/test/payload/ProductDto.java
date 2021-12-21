package com.example.test.payload;

import com.example.test.entity.Attachment;
import com.example.test.entity.Category;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
public class ProductDto {
    private String name;
    private int categoryId;
    private String description;
    private double price;

    private int photoId;
}
