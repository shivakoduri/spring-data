package com.myprojects.examples.springdata.service;

import com.myprojects.examples.springdata.exception.NotFoundException;
import com.myprojects.examples.springdata.model.Shop;

import java.util.List;

public interface ShopService {

    public Shop create(Shop shop);
    public Shop delete(int id) throws NotFoundException;
    public List<Shop> findAll();
    public Shop update(Shop shop) throws NotFoundException;
    public Shop findById(int id);
}
