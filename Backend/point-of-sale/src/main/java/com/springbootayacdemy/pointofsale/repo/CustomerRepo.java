package com.springbootayacdemy.pointofsale.repo;

import com.springbootayacdemy.pointofsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Integer> {


    List<Customer> findAllByActiveEquals(boolean activeState);

    List<Customer> findCustomerByCustomerName(String customerName);

    List<Customer> getAllByCustomerAddress(String customerAddress);

}

