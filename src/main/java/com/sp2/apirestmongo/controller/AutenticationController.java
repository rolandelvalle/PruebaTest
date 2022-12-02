package com.sp2.apirestmongo.controller;

import com.sp2.apirestmongo.dto.LoginDto;
import com.sp2.apirestmongo.dto.TokenDto;
import com.sp2.apirestmongo.model.User;
import com.sp2.apirestmongo.security.jwt.OperationJwt;
import com.sp2.apirestmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/v1/auth")
public class AutenticationController {

    private final OperationJwt operationJwt;
    private final UserService userService;

    @Autowired
    public AutenticationController(OperationJwt operationJwt, UserService userService) {
        this.operationJwt = operationJwt;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<TokenDto> generateJwt(@RequestBody LoginDto loginDto){
        User userFound = userService.findByEmail(loginDto.getEmail());
        if (userFound != null){
            Calendar dateExpiration = Calendar.getInstance();
            dateExpiration.add(Calendar.MINUTE, 5);
            String jwt = operationJwt.generateJwt(userFound, dateExpiration);
            TokenDto tokenDto = new TokenDto(jwt, dateExpiration.getTime());
            return new ResponseEntity<>(tokenDto, HttpStatus.OK);

        }else{
            return new ResponseEntity("Email" + loginDto.getEmail()
            + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
