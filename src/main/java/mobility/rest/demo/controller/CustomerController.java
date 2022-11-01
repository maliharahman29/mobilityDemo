package mobility.rest.demo.controller;

import javax.validation.Valid;
import mobility.rest.demo.domain.Customer;
import mobility.rest.demo.exception.ResourceNotFoundException;
import mobility.rest.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/customers")
  public Page<Customer> getCustomers(Pageable pageable) {
    return customerRepository.findAll(pageable);
  }

  @GetMapping("/customer/{customerId}")
  public Customer getCustomer(@PathVariable Long customerId) {
    return customerRepository.findById(customerId)
        .orElseThrow(()
            -> new ResourceNotFoundException("Customer not found: " + customerId));
  }

  @PostMapping("/customers")
  public Customer addCustomer(@RequestBody Customer customer) {
    return customerRepository.save(customer);
  }

}
