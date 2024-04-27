package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import com.example.demo.service.*;
@RestController
public class CustomerController
{
    @Autowired
    CustomerService ps;
    @PostMapping("/api/customer")
    public ResponseEntity<Customer> adddata(@RequestBody Customer p)
    {
        Customer obj=ps.create(p);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
    @GetMapping("/api/customers") 
    public List<Customer> fetchDepartmentList() 
    { 
        return ps.fetchDepartmentList(); 
    } 
    @GetMapping("/api/sort/{field}")
    public ResponseEntity<List<Customer>> get(@PathVariable String field)
    {
        try{
            return new ResponseEntity<>(ps.getbysort(field),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/api/customer/{customerId}")
    public ResponseEntity<Customer> putMethod(@PathVariable("customerId") int customerId,@RequestBody Customer pd)
    {
        if(ps.updateDetails(customerId,pd) == true)
        {
            return new ResponseEntity<>(pd,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/api/customer/{customerId}")
    public ResponseEntity<Boolean> delete(@PathVariable("customerId") int customerId)
    {
        if(ps.deleteEmployee(customerId) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}

