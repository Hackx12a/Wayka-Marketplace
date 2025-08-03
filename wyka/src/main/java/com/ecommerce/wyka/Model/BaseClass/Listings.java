package com.ecommerce.wyka.Model.BaseClass;

import com.ecommerce.wyka.Model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Listings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listingId;

    @Enumerated(EnumType.STRING)
    private ListingType listingType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

}
