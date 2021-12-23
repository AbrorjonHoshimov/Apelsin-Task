package com.example.test.entity;

import com.example.test.entity.template.AbstractId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order extends AbstractId {
    private Date date;
    @ManyToOne
    private Customer customer;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy="order",cascade = CascadeType.ALL)
    private List<Detail> details;


}
