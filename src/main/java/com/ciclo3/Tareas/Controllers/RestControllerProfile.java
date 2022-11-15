package com.ciclo3.Tareas.Controllers;

import com.ciclo3.Tareas.Models.Answer;
import com.ciclo3.Tareas.Models.Profile;
import com.ciclo3.Tareas.Services.InterfaceProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerProfile {


    @Autowired
    InterfaceProfile interfaceProfile;

    @GetMapping("/ProfileList")
    public ResponseEntity<List<Profile>> getProfile(){
        return new ResponseEntity<>(interfaceProfile.getProfile(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/OneProfile/{id}")
    public ResponseEntity<Object> getProfilePath(@PathVariable String id){
        try{
            Profile ProfileX = interfaceProfile.getOnlyOneProfile(id);
            return new ResponseEntity<>(ProfileX,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/CreateProfile")
    public ResponseEntity<String> PostCreateProfile(@RequestBody Profile ProfileX){
        try{
            String message = interfaceProfile.getCreateProfile(ProfileX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/UpdateProfile")
    public ResponseEntity<Answer> putUpdateProfile(@RequestBody Profile ProfileX){
        try{
            Profile ProfileBD = interfaceProfile.getUpdateProfile(ProfileX);
            return new ResponseEntity<>(new Answer("Actualizacion exitosa", ProfileBD),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Answer(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeleteProfile/{id}")
    public ResponseEntity<String> DeleteProfile(@PathVariable String id){
        try{
            String message = interfaceProfile.getDeleteProfile(id);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
