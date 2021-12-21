package com.example.test.entity;

import com.example.test.entity.template.AbstractId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer extends AbstractId {
    @Column(columnDefinition = "varchar(14)",nullable = false)
    private String name;
    @Column(columnDefinition = "varchar(3)",nullable = false)
    private String country;
    @Column(columnDefinition = "varchar(256)",nullable = false)
    private String address;
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String phone;
}
