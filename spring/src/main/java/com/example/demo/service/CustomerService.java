
package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.*;

@Service
public class CustomerService {
   
    @Autowired
    CustomerRepo pr;

    //post
    public Customer create(Customer p)
    {
        return pr.save(p);
    }

    //getbyid
    public List<Customer> fetchDepartmentList() 
    { 
        return (List<Customer>) pr.findAll(); 
    } 
    //getbyid
    public Customer getbyid(int customerId)
    {
        return pr.findById(customerId).orElse(null);
    }
    public List<Customer> getbysort(String field)
    {
        return pr.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    //put
    public boolean updateDetails(int customerId,Customer p)
        {
            if(pr.findById(customerId)==null)
            {
                return false;
            }
            try{
                pr.save(p);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteEmployee(int customerId)
        {
            if(this.getbyid(customerId) == null)
            {
                return false;
            }
            pr.deleteById(customerId);
            return true;
        }


}