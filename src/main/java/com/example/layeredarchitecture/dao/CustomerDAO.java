package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    void saveCustomer(CustomerDTO customerDTO) throws Exception;

    void updateCustomer(CustomerDTO customerDTO) throws Exception;

    boolean existCustomer(String id) throws Exception;

    void deleteCustomer(String id) throws Exception;

    List<CustomerDTO> loadAllCustomers() throws Exception;

    String generateNewId() throws Exception;

    CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException;

    boolean checkCustomer(String id) throws SQLException, ClassNotFoundException;
}
