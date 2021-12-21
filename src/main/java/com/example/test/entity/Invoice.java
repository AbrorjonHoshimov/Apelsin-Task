package com.example.test.entity;

import com.example.test.entity.template.AbstractId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice extends AbstractId {
    @OneToOne
    private Order order;
    private double amount;
    private Date issued;
    private Date due;
}
