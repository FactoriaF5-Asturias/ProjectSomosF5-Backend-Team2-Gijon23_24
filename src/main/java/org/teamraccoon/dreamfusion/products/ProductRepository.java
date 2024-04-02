package org.teamraccoon.dreamfusion.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Optional<Product> findByProductName(String name);
    public Optional <List<Product>> findByProductNameContaining(String name);

}