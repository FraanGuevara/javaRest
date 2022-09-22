package com.App.netflix.Service;

import com.App.netflix.Dto.UserDTO;
import com.App.netflix.Entity.UserModel;
import com.App.netflix.Mapper.UserMapper;
import com.App.netflix.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

//    @Transactional
//    public UserModel crearUser (UserModel user) {
//        return userRepository.save(user);
//    }

    @Transactional
    public UserDTO crearUserDTO (UserDTO dto) {
        UserModel user = userMapper.toUserModel(dto);
        userRepository.save(user);

        return userMapper.toDto(userRepository.save(user));

    }


//    @Transactional(readOnly = true)
//    public List<UserModel> mostrarUsers() {
//        List<UserModel> users = new ArrayList<>();
//        users = userRepository.findAll();
//        return users;
//    }
    @Transactional(readOnly = true)
    public List<UserDTO> mostrarUsers() {
        List<UserDTO> usersListDTO = new ArrayList<>();
        usersListDTO = userMapper.toUserModelList(userRepository.findAll());
        return usersListDTO;
}

    @Transactional(readOnly = true)
    public UserDTO buscarPorId(Long id) throws Exception { //Siempre que se pone un ElseThrow se pone el "throws Exceptio"
        UserDTO dto = new UserDTO();
        dto = userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new Exception("El id buscado no existe"))); //te largar esa excepcion si no encuentra un usuario con ese ID
        return dto;
    }

    @Transactional
    public UserDTO modificarUser(UserDTO user, Long id) throws Exception {
        UserModel userDB = new UserModel();
        userDB =  userRepository.findById(id).orElseThrow(() -> new Exception("El id buscado no existe"));
        userDB = userMapper.toUserModel(user);
        userRepository.save(userDB);
        return userMapper.toDto(userDB);
    }
}
