package com.ecommerce.wyka.Dto;

import com.ecommerce.wyka.Model.BaseClass.Listings;
import com.ecommerce.wyka.Model.Item.Items;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    @JsonIgnore
    private int itemId;
    private double price;
    private List<String> imagePaths;
    private String itemTitle;
    private String itemDescription;
    private String listingType;
    private String username;
    private LocalDate createdDate;
    private boolean isActive;





    public ItemDto(Items item) {
        this.itemId = item.getListingId();
        this.createdDate = item.getCreatedDate();
        this.isActive = item.isActive();
        this.price = item.getPrice();
        this.imagePaths = item.getImagePaths();
        this.itemTitle = item.getTitle();
        this.itemDescription = item.getDescription();
        this.listingType = item.getListingType() != null ? String.valueOf(item.getListingType()) : null;
        this.username = item.getUsers() != null ? item.getUsers().getUsername() : null;

    }


}