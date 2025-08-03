package com.ecommerce.wyka.Controller;


import com.ecommerce.wyka.Dto.ItemDto;
import com.ecommerce.wyka.Model.Item.Items;
import com.ecommerce.wyka.Model.UserPrincipal;
import com.ecommerce.wyka.Model.Users;
import com.ecommerce.wyka.Services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemsService itemsService;



    @PostMapping("/create/item")
    public ResponseEntity<ItemDto> uploadItem(@AuthenticationPrincipal UserPrincipal userPrincipal,
                                              @RequestPart("files") MultipartFile[] files,
                                              @RequestPart("itemData") Items items ){

        Users currentUser = userPrincipal.getUser();
        List<String> imagePaths = itemsService.uploadImages(files);
        items.setImagePaths(imagePaths);
        Items createdItem = itemsService.createItem(items, currentUser);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ItemDto(createdItem));

    }


    
































//
//    @PostMapping("/create/item")
//    public ResponseEntity<ItemDto> createItem(
//            @RequestPart("files") MultipartFile[] files, // For file uploads
//            @RequestPart("itemData") ItemDto itemDto,    // For JSON payload
//            @AuthenticationPrincipal UserPrincipal userPrincipal) {
//
//        Users currentUser = userPrincipal.getUser();
//        List<String> imagePaths = itemsService.uploadImages(files);
//        itemDto.setImagePaths(imagePaths);
//        Items createdItem = itemsService.createItem(itemDto, currentUser);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new ItemDto(createdItem));
//    }
//






}