package com.myprojects.examples.springdata.service;

import com.myprojects.examples.springdata.exception.NotFoundException;
import com.myprojects.examples.springdata.model.Shop;
import com.myprojects.examples.springdata.repository.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopRepository shopRepository;

    @Override
    @Transactional
    public Shop create(Shop shop) {
        Shop createdShop = shop;
        return shopRepository.save(createdShop);
    }

    @Override
    @Transactional
    public Shop findById(int id) {
        return shopRepository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor=NotFoundException.class)
    public Shop delete(int id) throws NotFoundException {
        Shop deletedShop = shopRepository.findOne(id);

        if (deletedShop == null)
            throw new NotFoundException();

        shopRepository.delete(deletedShop);
        return deletedShop;
    }

    @Override
    @Transactional
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor=NotFoundException.class)
    public Shop update(Shop shop) throws NotFoundException {
        Shop updatedShop = shopRepository.findOne(shop.getId());

        if (updatedShop == null)
            throw new NotFoundException();

        updatedShop.setName(shop.getName());
        updatedShop.setEmplNumber(shop.getEmplNumber());
        return updatedShop;
    }
}
