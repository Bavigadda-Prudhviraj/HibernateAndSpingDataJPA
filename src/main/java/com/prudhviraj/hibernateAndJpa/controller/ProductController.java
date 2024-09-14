package com.prudhviraj.hibernateAndJpa.controller;

import com.prudhviraj.hibernateAndJpa.entites.Product;
import com.prudhviraj.hibernateAndJpa.repository.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private final Integer PAGE_SIZE = 5;
    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @RequestMapping(path = "/getByTitleOrderByPrice", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findByTitleOrderByPrice(){
        List<Product> products = productRepo.findByTitleOrderByPrice("Mango");
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }

    @RequestMapping(path = "/findByTitleOrderByPrice", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllOrderByPrice(){
        List<Product> products = productRepo.findAByOrderByPrice();
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }

    @RequestMapping(path = "/findBy", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findBy(@RequestParam(defaultValue = "id") String sortBy){
        List<Product> products = productRepo.findBy(Sort.by(Sort.Direction.ASC, sortBy,"price"));
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }
    @RequestMapping(path = "/pagination", method = RequestMethod.GET)
    ResponseEntity<List<Product>> pagination(@RequestParam(defaultValue = "id") String sortBy,
                             @RequestParam(defaultValue = "0") Integer pageNumber){
        Pageable pageable =  PageRequest.of(pageNumber,
                                            PAGE_SIZE,
                                            Sort.by(sortBy));
        List<Product> products = productRepo.findAll(pageable).getContent();
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }
}
