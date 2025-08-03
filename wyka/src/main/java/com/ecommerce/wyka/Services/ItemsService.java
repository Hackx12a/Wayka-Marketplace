package com.ecommerce.wyka.Services;

import com.ecommerce.wyka.Model.BaseClass.Listings;
import com.ecommerce.wyka.Model.Item.ItemCondition;
import com.ecommerce.wyka.Model.Item.Items;
import com.ecommerce.wyka.Model.Users;
import com.ecommerce.wyka.Repository.ListingsRepository;
import com.ecommerce.wyka.Repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemsService {


    @Autowired
    private ItemsRepository itemsRepository;


    // This annotation reads a value from application.properties file
// In this case, it gets the directory path where we'll save uploaded files
    @Value("${upload.dir}")
    private String uploadDir; // This will store our upload directory path

    /**
     * Method to upload a single image file
     * @param files The image file to be uploaded (wrapped in Spring's MultipartFile)
     * @return The full path where the file was saved
     */
    public String uploadImage(MultipartFile files) {
        try {
            // 1. CREATE UPLOAD DIRECTORY IF IT DOESN'T EXIST
            // Paths.get() converts the string path to a Path object
            // Files.createDirectories() creates all necessary parent directories
            Files.createDirectories(Paths.get(uploadDir));

            // 2. GENERATE A UNIQUE FILENAME
            // We use current time in milliseconds + original filename to avoid duplicates
            // Example: "1634567890000_cat.jpg"
            String fileName = System.currentTimeMillis() + "_" + files.getOriginalFilename();

            // 3. CREATE FULL PATH FOR THE NEW FILE
            // File.separator ensures we use the correct slash (/ or \) for the operating system
            // Example: "uploads/1634567890000_cat.jpg"
            Path path = Paths.get(uploadDir + File.separator + fileName);

            // 4. SAVE THE FILE TO DISK
            // files.getBytes() gets the actual file content as bytes
            // Files.write() saves these bytes to the specified path
            Files.write(path, files.getBytes());

            // 5. RETURN THE PATH WHERE WE SAVED THE FILE
            return path.toString();

        } catch (IOException e) {
            // If anything goes wrong, wrap the error in a RuntimeException
            throw new RuntimeException("Failed to store file: " + e.getMessage());
        }
    }

    /**
     * Method to upload multiple image files
     * @param files Array of image files to upload
     * @return List of paths where files were saved
     */
    public List<String> uploadImages(MultipartFile[] files) {
        // Create an empty list to store all the file paths we'll generate
        List<String> imagePaths = new ArrayList<>();

        // Loop through each file in the input array
        for (MultipartFile file : files) {
            // Check if the current file isn't empty
            if (!file.isEmpty()) {
                // Upload the current file using our single-file upload method
                String imagePath = uploadImage(file);

                // Add the resulting path to our list
                imagePaths.add(imagePath);
            }
        }

        // Return the complete list of all saved file paths
        return imagePaths;
    }


    public Items createItem(Items items, Users user) {
        // Create new item instance


        Items item = new Items();

        // Set basic properties
        item.setPrice(items.getPrice());
        item.setTitle(items.getTitle());
        item.setDescription(items.getDescription());
        item.setLocation(items.getLocation());
        item.setCreatedDate(LocalDate.now()); // Set current date
        item.setActive(true); // New items are active by default
        item.setListingType(items.getListingType());

        // Handle enums - ensure they're not null
        if (items.getItemCondition() != null) {
            item.setItemCondition(items.getItemCondition()); // Set the enum value directly
        } else {
            throw new IllegalArgumentException("Item condition must be specified");
        }

        if (items.getItemCategory() != null) {
            item.setItemCategory(items.getItemCategory()); // Set the enum value directly
        } else {
            throw new IllegalArgumentException("Item category must be specified");
        }

        // Handle image paths (defensive copy)
        if (items.getImagePaths() != null) {
            item.setImagePaths(new ArrayList<>(items.getImagePaths()));
        }

        // Set relationships
        item.setUsers(user);

        // Save and return
        return itemsRepository.save(item);
    }









































//    @Value("${upload.dir}")
//    private String uploadDir;
//
//    public List<Items> getItemsByUser(Users currentUser) {
//
//        return itemsRepository.findByUser(currentUser);
//    }
//
//
//
//    public Optional<Items> getItemByIdAndUser(int itemId, Users user) {
//        return itemsRepository.findByitemIdAndUser(itemId, user);
//
//    }
//
//    public String uploadImage(MultipartFile file) {
//        try {
//            // Create the directory if it doesn't exist
//            Files.createDirectories(Paths.get(uploadDir));
//
//            // Define the path for the file
//            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // Unique file name
//            Path path = Paths.get(uploadDir + File.separator + fileName);
//            Files.write(path, file.getBytes());
//
//            // Return the file path or URL
//            return path.toString(); // Adjust this as needed for your application
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to store file: " + e.getMessage());
//        }
//    }
//
//    public List<String> uploadImages(MultipartFile[] files) {
//        List<String> imagePaths = new ArrayList<>();
//        for (MultipartFile file : files) {
//            // Validate and process each file
//            if (!file.isEmpty()) {
//                String imagePath = uploadImage(file); // Implement this method as shown before
//                imagePaths.add(imagePath);
//            }
//        }
//        return imagePaths;
//    }
//
//
//    public Items createItem(ItemDto itemDto, Users user) {
//
//        Listings listings = listingsRepository.findByListingName(itemDto.getListingName());
//
//
//        Items item = new Items();
//        item.setPrice(itemDto.getPrice());
//        item.setImagePaths(itemDto.getImagePaths());
//        item.setItemName(itemDto.getItemName());
//        item.setItemDescription(itemDto.getItemDescription());
//        item.setListings(listings);
//        item.setUser(user);
//
//        return itemsRepository.save(item);
//    }
//
//    public List<ItemDto> getAllItemsFromAllUsers() {
//
//        List<Items> items = itemsRepository.findAll(); // Assuming you're using JPA
//
//        return items.stream()
//                .map(ItemDto::new)
//                .collect(Collectors.toList());
//    }
}
