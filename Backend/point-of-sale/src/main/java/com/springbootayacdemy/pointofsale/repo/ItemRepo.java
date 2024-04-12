package com.springbootayacdemy.pointofsale.repo;

import com.springbootayacdemy.pointofsale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Integer> {
}
