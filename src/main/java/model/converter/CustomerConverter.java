package model.converter;

import model.dao.CustomersDao;
import model.dto.CustomerDto;

public class CustomerConverter {
    public CustomersDao convert(CustomerDto customerDto) {
        CustomersDao customersDao = new CustomersDao() ;
        customersDao.setCustomerId(customerDto.getCustomerId());
        customersDao.setCustomerName(customerDto.getCustomerName());
        customersDao.setCustomerPhone(customerDto.getCustomerPhone());
        return customersDao;
    }
    public CustomerDto convert(CustomersDao customerDao){
        CustomerDto customerDto = new CustomerDto() ;
        customerDto.setCustomerId(customerDao.getCustomerId());
        customerDto.setCustomerName(customerDao.getCustomerName());
        customerDto.setCustomerPhone(customerDao.getCustomerPhone());
        return customerDto;
    }
}
