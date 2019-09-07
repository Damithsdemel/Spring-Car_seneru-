package com.senerutaxi.repository;

import com.senerutaxi.model.AvailableCarsResult;
import com.senerutaxi.model.BorrowedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public interface BorrowedDateDAO extends JpaRepository<BorrowedDate, Long> {
    BorrowedDate findByCustomerId(Long id);
    BorrowedDate findByCarId(Long id);
    List<BorrowedDate> findAll();


    @Query("select NEW com.senerutaxi.model.AvailableCarsResult "+
            "(b.id, b.car.id, b.car.name, b.car.description, b.car.price) "+
            "from BorrowedDate as b "+
            "where :startDate not between b.startDate and b.endDate "+
            "and :endDate not between b.startDate and b.endDate "+
            "and b.car.id NOT IN (select DISTINCT bd.car.id "+
                "from BorrowedDate bd "+
                "where :startDate between bd.startDate and bd.endDate "+
                "OR :endDate between bd.startDate and bd.endDate) " +
                "group by b.car.id")
    List<AvailableCarsResult> checkAvailableCars(@Param("startDate") Date startDate,
                                                 @Param("endDate") Date endDate);

    @Query("select NEW com.senerutaxi.model.AvailableCarsResult "+
            "(b.id, b.car.id, b.car.name, b.car.description, b.car.price) "+
            "from BorrowedDate as b "+
            "where :startDate not between b.startDate and b.endDate "+
            "and :endDate not between b.startDate and b.endDate "+
            "and b.car.id = :carId "+
            "and b.car.id NOT IN (select DISTINCT bd.car.id "+
                "from BorrowedDate bd "+
                "where :startDate between bd.startDate and bd.endDate "+
                "OR :endDate between bd.startDate and bd.endDate)")
    List<AvailableCarsResult> checkAvailableCarById(@Param("startDate") Date startDate,
                                                    @Param("endDate") Date endDate,
                                                    @Param("carId") Long id);


}
