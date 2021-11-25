/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retouno.web;

import co.edu.usa.ciclo4.retouno.model.User;
import co.edu.usa.ciclo4.retouno.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author angycastel
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
/**
 * Clase publica User Controller
 */
public class UserController {
    @Autowired
    private UserService userService;

/**
 * Llamado web para todos los elementos
 * @return muestra todos los registros
 */    
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
 
/**
 * Llamado metodo post para nuevo usuario
 * @param user
 * @return registro de usuario nuevo
 */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userService.registrar(user);
    }

/**
 * Llamado web para obtener email y password
 * @param email
 * @param password
 * @return autenticacion de usuario
 */    
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

/**
 * LLamado para verificar existencia de email
 * @param email
 * @return true o false
 */    
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }   
    
}

    