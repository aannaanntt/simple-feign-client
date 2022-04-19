package bill.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bill.services.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	Bill getBillByCustomerId(long CustomerId);
}
