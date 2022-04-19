package customer.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import customer.services.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
