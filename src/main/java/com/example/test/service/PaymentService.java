package com.example.test.service;

import com.example.test.entity.Invoice;
import com.example.test.entity.Payment;
import com.example.test.payload.ApiResponse;
import com.example.test.payload.PaymentDto;
import com.example.test.repository.InvoiceRepository;
import com.example.test.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    InvoiceRepository invoiceRepository;

    public ApiResponse addPayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        payment.setTime(timestamp);
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(paymentDto.getInvoiceId());
        if (!optionalInvoice.isPresent()) return new ApiResponse("Failed", false);
        payment.setInvoice(optionalInvoice.get());
        payment.setAmount(optionalInvoice.get().getAmount());
        paymentRepository.save(payment);
        return new ApiResponse("Succes", true);
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }


    public ApiResponse getOrderId(int id) {
        List<Payment> allByOrderId = paymentRepository.findAllByOrderId(id);
        return new ApiResponse("Succes", true, allByOrderId);
    }
}
