//package com.senerutaxi.service;
//
//import com.senerutaxi.model.BorrowedDate;
//import com.senerutaxi.model.Customer;
//import com.senerutaxi.repository.BorrowedDateDAO;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.assertEquals;
//
//public class BorrowedDateServiceImplTest {
//    BorrowedDate borrowedDate;
//    Customer customer;
//    BorrowedDateDAO borrowedDateDAO;
//    BorrowedDateService borrowedDateService;
//    BorrowedDateServiceImpl borrowedDateServiceImpl;
//
//    @Test
//    public void countDays() throws Exception {
//
//        customer = new Customer();
//        customer.setFullName("John Smith");
//        customer.setTotalPrice(new BigDecimal(100));
//
//        Date start = Date();
//        start.set(2019, 01, 01, 00, 00, 00);
//        Calendar end = Calendar.getInstance();
//        end.set(2019, 01, 10, 00, 00, 00);
//        borrowedDate = new BorrowedDate();
//        borrowedDate.setStartDate(start);
//        borrowedDate.setEndDate(end);
//
//        // FIXME: null pointer
//        // long days1 = borrowedDateService.countDays(borrowedDate);
//        // assertEquals(10, days1, 0);
//
//        long days = daysBetween(start, end);
//        customer.setTotalPrice(customer.getTotalPrice().multiply(new BigDecimal(days)));
//        BigDecimal totalSum = customer.getTotalPrice();
//
//        assertEquals(10, days, 0);
//        assertEquals(new BigDecimal(1000), totalSum);
//    }
//
////    private long daysBetween(Calendar startDate, Calendar endDate) {
////        endDate.add(Calendar.DATE, 1);
////        long end = endDate.getTimeInMillis();
////        long start = startDate.getTimeInMillis();
////        return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
////    }
//    public static long daysBetween(Date d1, Date d2) {
//        long diff = d2.getTime() - d1.getTime();
//        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//    }
//
//}