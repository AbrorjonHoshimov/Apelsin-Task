package com.example.test.entity;

import com.example.test.entity.template.AbstractId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Detail extends AbstractId {
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne
    private Product product;
    private int quantity;
}
