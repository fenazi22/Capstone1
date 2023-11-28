package com.example.capstone1.Controller;

import com.example.capstone1.Model.User;
import com.example.capstone1.Service.UserServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cap/user")
@RequiredArgsConstructor
public class UserController {

    private  final UserServ userServ;



   //get
    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userServ.getUsers());
    }



    //add
@PostMapping("/add")
    public ResponseEntity addUsers(@Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userServ.addUsers(user);
    return ResponseEntity.status(HttpStatus.OK).body("Successfully");
    }



    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updUsers(@PathVariable String id,@Valid@RequestBody User user, Errors errors ){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdate=userServ.updUsers(id,user);
                if(isUpdate)
                    return ResponseEntity.status(HttpStatus.OK).body("Successfully Update  :) \n");
                else
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!");
    }


    //Delete
  @DeleteMapping("/delete/{id}")
    public  ResponseEntity del(@PathVariable String id){
        boolean isDelete=userServ.delUsers(id);
        if (isDelete)
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Delete  :) \n");
                else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND!!");




  }





}
