package com.ciclo3.Tareas.Controllers;

import com.ciclo3.Tareas.Models.Answer;
import com.ciclo3.Tareas.Models.User;
import com.ciclo3.Tareas.Services.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerUser {

    @Autowired
    InterfaceUser interfaceUser;

    @GetMapping("/UserList")
    public ResponseEntity<List<User>> getUser(){
        return new ResponseEntity<>(interfaceUser.getUser(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/OneUser/{id}")
    public ResponseEntity<Object> getUserPath(@PathVariable String id){
        try{
            User UserX = interfaceUser.getOnlyOneUser(id);
            return new ResponseEntity<>(UserX,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/CreateUser")
    public ResponseEntity<String> PostCreateUser(@RequestBody User UserX){
        try{
            String message = interfaceUser.getCreateUser(UserX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/UpdateUser")
    public ResponseEntity<Answer> putUpdateUser(@RequestBody User UserX){
        try{
            User UserBD = interfaceUser.getUpdateUser(UserX);
            return new ResponseEntity<>(new Answer("Actualizacion exitosa", UserBD),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Answer(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeleteUser/{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable String id){
        try{
            String message = interfaceUser.getDeleteUser(id);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
