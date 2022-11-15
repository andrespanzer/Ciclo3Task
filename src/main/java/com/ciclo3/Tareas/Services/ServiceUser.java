package com.ciclo3.Tareas.Services;

import com.ciclo3.Tareas.Models.User;
import com.ciclo3.Tareas.Repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser implements InterfaceUser {

    Date Today = new Date();

    @Autowired
    RepositoryUser repositoryUser;

    @Override
    public List<User> getUser() {
        return repositoryUser.findAll();
    }

    @Override
    public User getOnlyOneUser(String id) throws Exception {
        Optional<User> UserBD = repositoryUser.findById(id);
        if(UserBD.isPresent()){
            return UserBD.get();
        }
        throw new Exception("Id de Usuario no Encontrado");
    }

    @Override
    public String getCreateUser(User userIn) {
        Optional<User> UserBD = repositoryUser.findById(userIn.getId());
        if(!UserBD.isPresent()){
            repositoryUser.save(userIn);
            return ("Usuario Creado Con Exito");
        }

        return ("Id ya está en Uso");
    }


    @Override
    public User getUpdateUser(User userIn) throws Exception {
        User userBD = getOnlyOneUser(userIn.getId());
        if(userIn.getEmail() != null && !userIn.getEmail().equals("")){
            userBD.setEmail(userIn.getEmail());
        }
        userBD.setUpdatedAt(Today);

        return repositoryUser.save(userBD);
    }

    @Override
    public String getDeleteUser(String id) throws Exception {
        Optional<User> userBD = repositoryUser.findById(id);
        if(userBD.isPresent()){
            repositoryUser.deleteById(id);
            return "Usuario eliminado con exito";
        }

        throw new Exception("Usuario no encontrado");
    }
}
