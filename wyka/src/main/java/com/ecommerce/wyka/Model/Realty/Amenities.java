package com.ecommerce.wyka.Model.Realty;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Amenities {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amenitiesId;
    private String parkingAndFacilities;
    private String diningOptions;
    private String entertainmentOptions;
    private String accessibilityFeatures;
    private String petFriendlyServices;
    private String heatingAndCooling;


    @ManyToOne  // Changed from collection annotation
    @JoinColumn(name = "realty_id")
    private Realty realty;




}
