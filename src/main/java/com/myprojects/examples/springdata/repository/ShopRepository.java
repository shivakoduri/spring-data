package com.myprojects.examples.springdata.repository;

import com.myprojects.examples.springdata.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
