package com.ecommerce.wyka.Repository;

import com.ecommerce.wyka.Model.SaveCart;
import com.ecommerce.wyka.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaveRepository extends JpaRepository<SaveCart, Integer> {

    Optional<SaveCart> findByUser(Users user);
}