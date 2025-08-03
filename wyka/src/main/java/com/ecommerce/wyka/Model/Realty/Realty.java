package com.ecommerce.wyka.Model.Realty;


import com.ecommerce.wyka.Model.BaseClass.Listings;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Realty extends Listings {

    private String forSaleorRent;
    private String title;
    private String description;
    private String location;
    private LocalDate createdDate;
    private int price;
    private boolean isActive;



    @ElementCollection
    private List<String> imagePaths;



    @OneToMany(mappedBy = "realty")
    private List<Amenities> amenities = new ArrayList<>();




}
