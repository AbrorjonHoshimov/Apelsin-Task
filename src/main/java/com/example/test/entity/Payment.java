package com.example.test.entity;

import com.example.test.entity.template.AbstractId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment extends AbstractId {

    private Timestamp time;
    private double amount;
    @ManyToOne
    private Invoice invoice;

}
