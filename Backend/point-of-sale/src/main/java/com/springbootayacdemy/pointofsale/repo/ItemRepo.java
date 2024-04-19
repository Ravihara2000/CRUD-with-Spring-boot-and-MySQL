package com.springbootayacdemy.pointofsale.repo;

import com.springbootayacdemy.pointofsale.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item,Integer> {

    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);

    Page<Item> findAllByActiveStateEquals(boolean activeStatus, Pageable pageable);

    int countAllByActiveStateEquals(boolean activeStatus);
}
