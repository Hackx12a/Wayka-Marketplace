package com.ecommerce.wyka.Model.Item;

import com.ecommerce.wyka.Model.BaseClass.Listings;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Items extends Listings {

    private double price;
    private String title;
    private String description;
    private String location;
    private LocalDate createdDate;
    private boolean isActive;


    @Enumerated(EnumType.STRING)
    private ItemCondition itemCondition;

    @ElementCollection
    private List<String> imagePaths;

    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;







}
