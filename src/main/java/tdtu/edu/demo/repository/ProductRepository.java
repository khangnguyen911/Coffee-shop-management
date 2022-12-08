package tdtu.edu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.edu.demo.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
