package midterm.movie.shoppingAPI.repository;

import midterm.movie.shoppingAPI.model.OrderBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBuyRepository extends JpaRepository<OrderBuy,Integer>  {
}
