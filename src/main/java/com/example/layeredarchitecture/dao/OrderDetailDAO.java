package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    boolean isDataInsertIntoOrderDetail(List<OrderDetailDTO> orderDetails, String orderId, Connection connection) throws SQLException, ClassNotFoundException;
}

