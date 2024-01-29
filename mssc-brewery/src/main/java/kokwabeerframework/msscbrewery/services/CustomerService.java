package kokwabeerframework.msscbrewery.services;

import kokwabeerframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;
public interface CustomerService {
    CustomerDto getCustomerById(UUID costumerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}
