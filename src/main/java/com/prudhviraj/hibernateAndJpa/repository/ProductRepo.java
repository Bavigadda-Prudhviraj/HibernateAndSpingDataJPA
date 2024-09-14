package com.prudhviraj.hibernateAndJpa.repository;

import com.prudhviraj.hibernateAndJpa.entites.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByCreatedAtAfter(LocalDateTime after);
    List<Product> findByCreatedAtBefore(LocalDateTime after);
    List<Product> findByQuantityAndPrice( int quantity,BigDecimal price) ;
    List<Product> findByQuantityGreaterThanAndPriceLessThan( int quantity,BigDecimal price) ;
    List<Product> findByTitleContainingIgnoreCase(String strToSearch);
    //two ways to append parameters into the SQL query both will work
    // @Query("select e from Product e where e.title=?1 and e.price=?2")
    @Query("select e from Product e where e.title=:title and e.price=:price")
    List<Product> findByTitleAndPrice(String title,BigDecimal price);

    //Pagination and sorting
    List<Product> findByTitleOrderByPrice(String title);
    List<Product> findAByOrderByPrice();
    List<Product> findBy(Sort sort);
}
