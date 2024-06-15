package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO{
    ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public boolean isDataInsertIntoOrderDetail(List<OrderDetailDTO> orderDetails, String orderId, Connection connection) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

        for (OrderDetailDTO detail : orderDetails) {
            stm.setString(1, orderId);
            stm.setString(2, detail.getItemCode());
            stm.setBigDecimal(3, detail.getUnitPrice());
            stm.setInt(4, detail.getQty());

            if (stm.executeUpdate() != 1) {
                return false;
            }
            //Search & Update Item
            boolean isItemSearchedAndUpdated = itemDAO.isItemSearchedAndUpdated(connection,orderDetails);
            if (!isItemSearchedAndUpdated) {
                return false;
            }
        }
        return true;
    }
}