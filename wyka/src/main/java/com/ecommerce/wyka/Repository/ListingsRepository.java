package com.ecommerce.wyka.Repository;

import com.ecommerce.wyka.Model.BaseClass.Listings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingsRepository extends JpaRepository<Listings, Integer> {
//   Listings findByListingName(String categoryName);
}
