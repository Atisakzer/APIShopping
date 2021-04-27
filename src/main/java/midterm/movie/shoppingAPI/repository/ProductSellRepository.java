package midterm.movie.shoppingAPI.repository;


import midterm.movie.shoppingAPI.model.ProductSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSellRepository extends JpaRepository<ProductSell,Integer> {
}
