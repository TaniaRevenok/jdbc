package dataLayer;

import model.dao.CustomersDao;
import ua.config.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerRepository implements Repository<CustomersDao> {

    private final DatabaseManager connector;
    private static final String FIND_BY_ID = "SELECT * FROM customers c WHERE c.id = ? ;";
    private static final String INSERT = "INSERT INTO customers (id, customer_name, customer_phone) VALUES (?, ?, ?)";
    private static final String DELETE_BY_ID = "DELETE FROM customers WHERE id = ?";
    private static final String UPDATE = "UPDATE customers SET customer_name = ? , customer_phone = ? WHERE id = ?";

    public CustomerRepository(DatabaseManager connector) {
        this.connector = connector;
    }

    @Override
    public CustomersDao findById(Integer id) {
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCustomersDao(resultSet).orElseThrow(() -> new IllegalArgumentException(String.format("Customer with id %d not found", id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void create(CustomersDao customersDao) {
        try{
            CustomersDao exist = findById(customersDao.getCustomerId());
            System.out.println(String.format("Customer with %d already exist", exist.getCustomerId()));
        } catch (IllegalArgumentException e){
            try(Connection connection = connector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT)){
                preparedStatement.setInt(1, customersDao.getCustomerId());
                preparedStatement.setString(2, customersDao.getCustomerName());
                preparedStatement.setString(3, customersDao.getCustomerPhone());
                preparedStatement.execute();
            }
            catch (SQLException eq) {
                eq.printStackTrace();
            }
        }

    }

    @Override
    public void delete(CustomersDao customersDao) {
        findById(customersDao.getCustomerId());
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)){
            preparedStatement.setInt(1, customersDao.getCustomerId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(CustomersDao customersDao) {
        int rowsUpdated = 0;
        try(Connection connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, customersDao.getCustomerName());
            preparedStatement.setString(2, customersDao.getCustomerPhone());
            preparedStatement.setInt(3, customersDao.getCustomerId());
            rowsUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }
    private Optional<CustomersDao> mapToCustomersDao(ResultSet resultSet) throws SQLException {
        CustomersDao customersDao = null;
        while(resultSet.next()){
            customersDao = new CustomersDao();
            customersDao.setCustomerId(resultSet.getInt("id"));
            customersDao.setCustomerName(resultSet.getString("customer_name"));
            customersDao.setCustomerPhone(resultSet.getString("customer_phone"));
        }
        return Optional.ofNullable(customersDao);
    }

}