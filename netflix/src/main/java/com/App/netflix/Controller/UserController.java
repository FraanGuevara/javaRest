package com.App.netflix.Controller;

import com.App.netflix.Dto.UserDTO;
import com.App.netflix.Entity.UserModel;
import com.App.netflix.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(UserDTO dto){
        return new ResponseEntity<>(userService.crearUserDTO(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> allUsers (){
    return new  ResponseEntity<>(userService.mostrarUsers(), HttpStatus.OK);
    }

    @GetMapping ("/user/{id}")
    public ResponseEntity<UserDTO> buscarUserPorId (@PathVariable("id") Long id) throws Exception{ //a cada metodo que tiene adentro una excepcion se le pone Throws Exception
        return new  ResponseEntity(userService.buscarPorId(id), HttpStatus.OK);
    }

    @PutMapping ("/modify/{id}")
    public ResponseEntity<UserDTO> modifyUser(@PathVariable("id") Long id, UserDTO userModificadoDTO) throws Exception {
    return new ResponseEntity<>(userService.modificarUser(userModificadoDTO, id), HttpStatus.OK);
    }

}
