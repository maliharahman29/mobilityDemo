package mobility.rest.demo;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import mobility.rest.demo.domain.Customer;
import mobility.rest.demo.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
public class CustomerControllerTest {

  @MockBean
  private Customer customer;

  @MockBean
  CustomerRepository customerRepository;

  protected MockMvc mvc;

  @Autowired
  WebApplicationContext context;

  @BeforeEach
  public void setup() {
    mvc = MockMvcBuilders
        .webAppContextSetup(context)
        .apply(springSecurity())
        .build();
  }

  @BeforeEach
  public void createCustomer() {
    customer = new Customer();
    customer.setFirstName("first name");
    customer.setLastName("last name");
  }

  @Test
  public void findCustomerReturnsOk() throws Exception {
    Mockito.when(customerRepository.findById(anyLong())).thenReturn(
        Optional.of(customer));

    final String response = mvc.perform(get("/api/v1/customer/{customerId}", "customerId")
        .header(HttpHeaders.AUTHORIZATION, ""))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
  }

}
