package com.example.capstone1.Service;

import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Getter
@Setter
@Service
public class UserServ {
    //Get
    ArrayList<User>users=new ArrayList<>();


    //Add
    public  void addUsers(User user){
        users.add(user);
    }



    //update
    public boolean updUsers(String id,User user){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId().equals(id)){
                users.set(i,user);
                return true;
            }
        }

    return false;
    }


    //Delete
    public boolean delUsers(String id){
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }


// -------- EndPint Area--------

    /*
*11- Create endpoint where user can add more stocks of product to a
     merchant Stock
• this endpoint should accept a product id and merchant id and the amount of
    additional stock.
    *  MerchantStock Classe .
    *  productID
    *  merchantID
    * additional stock
    */













}

