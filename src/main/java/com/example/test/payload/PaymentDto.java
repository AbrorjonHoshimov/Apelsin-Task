package com.example.test.payload;

import com.example.test.entity.Invoice;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
public class PaymentDto {
    private int invoiceId;
}
