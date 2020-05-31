package br.com.dfdx.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dfdx.restapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
