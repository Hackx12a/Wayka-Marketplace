package com.ecommerce.wyka.Model;

import com.ecommerce.wyka.Model.BaseClass.Listings;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;



    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Listings> listings;





}
