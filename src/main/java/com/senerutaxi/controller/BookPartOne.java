package com.senerutaxi.controller;

import com.senerutaxi.model.AvailableCarsResult;
import com.senerutaxi.model.BorrowedDate;
import com.senerutaxi.model.Car;
import com.senerutaxi.model.Customer;
import com.senerutaxi.service.BorrowedDateService;
import com.senerutaxi.service.CarService;
import com.senerutaxi.service.CustomerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({ "customer", "borrowedDate" })
public class BookPartOne {

    private CarService carService;
    private BorrowedDateService borrowedDateService;
    private CustomerService customerService;

    public BookPartOne(CarService carService, BorrowedDateService borrowedDateService,
            CustomerService customerService) {
        this.carService = carService;
        this.borrowedDateService = borrowedDateService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/bookPartOne{car_id}", method = RequestMethod.GET)
    public String checkDates(Model model, @RequestParam(value = "car_id") Long CarId,
            @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(value = "end_date", defaultValue = "3000-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Car carById = carService.findById(CarId);
        List<AvailableCarsResult> availableCarById = borrowedDateService.checkAvailableCarById(startDate, endDate,
                CarId);
        model.addAttribute("carById", carById);
        model.addAttribute("availableCarById", availableCarById);
        return "bookPartOne";
    }

    @RequestMapping(value = "/bookPartOne", method = RequestMethod.POST)
    public String createNewCustomer(Car car, Customer customer, BorrowedDate borrowedDate,
            RedirectAttributes redirectAttributes, @RequestParam(value = "car_id") Long CarId,
            @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(value = "end_date", defaultValue = "3000-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        car = carService.findById(CarId);
        customer.getCars().add(car);
        customer.setBorrowedCars(customer.getBorrowedCars() + 1);
        customer.setTotalPrice(customer.getTotalPrice().add(car.getPrice()));
        borrowedDate.setCar(car);
            //    borrowedDate.setCustomer(customer);
        borrowedDate.setStartDate(startDate);
        borrowedDate.setEndDate(endDate);
        redirectAttributes.addAttribute("car_id", CarId);
        return "redirect:/bookPartTwo";
    }

}
