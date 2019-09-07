package com.senerutaxi.service;

import com.senerutaxi.model.AvailableCarsResult;
import com.senerutaxi.model.BorrowedDate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface BorrowedDateService {

    List<AvailableCarsResult> checkAvailableCarById(Date startDate, Date endDate, Long id);

    List<AvailableCarsResult> checkAvailableCars(Date startDate, Date endDate);

    List<BorrowedDate> findAll();

    BorrowedDate findByCustomerId(Long id);

    BorrowedDate findByCarId(Long id);

    void save(BorrowedDate borrowedDate);

    long countDays(BorrowedDate borrowedDate);
}
