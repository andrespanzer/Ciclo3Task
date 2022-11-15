package com.ciclo3.Tareas.Services;

import com.ciclo3.Tareas.Models.Profile;
import com.ciclo3.Tareas.Repositories.RepositoryProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceProfile implements InterfaceProfile {

    Date Today = new Date();

    @Autowired
    RepositoryProfile repositoryProfile;

    @Override
    public List<Profile> getProfile() {
        return repositoryProfile.findAll();
    }

    @Override
    public Profile getOnlyOneProfile(String id) throws Exception {
        Optional<Profile> ProfileBD = repositoryProfile.findById(id);
        if(ProfileBD.isPresent()){
            return ProfileBD.get();
        }
        throw new Exception("Id de Perfil no Encontrado");
    }

    @Override
    public String getCreateProfile(Profile ProfileIn) {
        Optional<Profile> ProfileBD = repositoryProfile.findById(ProfileIn.getId());
        if(!ProfileBD.isPresent()){
            repositoryProfile.save(ProfileIn);
            return ("Perfil Creado Con Exito");
        }

        return ("Id ya está en Uso");
    }


    @Override
    public Profile getUpdateProfile(Profile ProfileIn) throws Exception {
        Profile ProfileBD = getOnlyOneProfile(ProfileIn.getId());
        if(ProfileIn.getPhone() != null && !ProfileIn.getPhone().equals("")){
            ProfileBD.setPhone(ProfileIn.getPhone());
        }

        ProfileBD.setUpdatedAt(Today);

        return repositoryProfile.save(ProfileBD);
    }

    @Override
    public String getDeleteProfile(String id) throws Exception {
        Optional<Profile> ProfileBD = repositoryProfile.findById(id);
        if(ProfileBD.isPresent()){
            repositoryProfile.deleteById(id);
            return "Perfil eliminado con exito";
        }

        throw new Exception("Perfil no encontrado");
    }
    
    
}
