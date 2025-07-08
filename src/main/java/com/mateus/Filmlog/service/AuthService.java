package com.mateus.Filmlog.service;

import com.mateus.Filmlog.config.JwtUtil;
import com.mateus.Filmlog.dto.LoginDTO;
import com.mateus.Filmlog.model.User;
import com.mateus.Filmlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    public ResponseEntity<?> login(LoginDTO loginDTO) {
        User user = repository.findByEmail(loginDTO.getEmail());

        if(user == null || !(BCrypt.checkpw(loginDTO.getSenha(), user.getSenha()))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Credenciais inválidas", "valorDoCheckSenha", BCrypt.checkpw(loginDTO.getSenha(), user.getSenha()), "userEhNull", user == null));
        }

        String token = jwtUtil.gerarToken(user.getEmail());

        return ResponseEntity.ok(Map.of(
                "message", "Login bem-sucedido",
                "token", token,
                "nome", user.getNome()
        ));
    }
}
