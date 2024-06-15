package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDAO {
    void save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    void update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean existItem(String code) throws SQLException, ClassNotFoundException;
    void deleteItem(String code) throws SQLException, ClassNotFoundException;
    String generateNewId() throws Exception;
    List<ItemDTO> loadAllCustomers() throws Exception;
    boolean isItemSearchedAndUpdated(Connection connection, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException;

    boolean checkItem(String code) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAllItems();
}
