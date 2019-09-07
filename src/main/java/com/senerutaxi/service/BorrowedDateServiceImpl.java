package com.senerutaxi.service;

import com.senerutaxi.model.AvailableCarsResult;
import com.senerutaxi.model.BorrowedDate;
import com.senerutaxi.repository.BorrowedDateDAO;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BorrowedDateServiceImpl implements BorrowedDateService {

    private BorrowedDateDAO borrowedDateDAO;

    public BorrowedDateServiceImpl(BorrowedDateDAO borrowedDateDAO) {
        this.borrowedDateDAO = borrowedDateDAO;
    }

    @Override
    public BorrowedDate findByCustomerId(Long id) {
        return this.borrowedDateDAO.findByCustomerId(id);
    }

    @Override
    public BorrowedDate findByCarId(Long id) {
        return this.borrowedDateDAO.findByCarId(id);
    }

    @Override
    public List<BorrowedDate> findAll() {
        return this.borrowedDateDAO.findAll();
    }

    @Override
    public void save(BorrowedDate borrowedDate) {
        this.borrowedDateDAO.save(borrowedDate);
    }

    @Override
    public List<AvailableCarsResult> checkAvailableCars(Date startDate, Date endDate) {
        return this.borrowedDateDAO.checkAvailableCars(startDate, endDate);
    }

    @Override
    public List<AvailableCarsResult> checkAvailableCarById(Date startDate,Date endDate, Long id) {
        return this.borrowedDateDAO.checkAvailableCarById(startDate, endDate, id);
    }

    @Override
    public long countDays(BorrowedDate borrowedDate) {
        long days;
        Date start = borrowedDate.getStartDate();
        Date end = borrowedDate.getEndDate();
        days = daysBetween(start, end);
        return days;
    }


public static long daysBetween(Date d1, Date d2) {
    long diff = d2.getTime() - d1.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
}
}
