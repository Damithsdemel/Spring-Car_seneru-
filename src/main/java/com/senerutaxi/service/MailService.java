package com.senerutaxi.service;

import com.senerutaxi.model.BorrowedDate;
import com.senerutaxi.model.Car;
import com.senerutaxi.model.Customer;

public interface MailService {

    void sendMailTest();

    void sendMail(Customer customer, BorrowedDate borrowedDate, Car car);
}
