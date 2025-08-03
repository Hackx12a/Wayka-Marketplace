package com.ecommerce.wyka.Repository;

import com.ecommerce.wyka.Model.Item.Items;
import com.ecommerce.wyka.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface
ItemsRepository extends JpaRepository<Items, Integer> {


//    List<Items> findByUsers(Users user);
//
//    Optional<Items> findByitemIdAndUser(int itemId, Users user);

}
