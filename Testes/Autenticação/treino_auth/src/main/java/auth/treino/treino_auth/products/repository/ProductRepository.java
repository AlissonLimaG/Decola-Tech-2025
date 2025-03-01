package auth.treino.treino_auth.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth.treino.treino_auth.products.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Long>{

}
