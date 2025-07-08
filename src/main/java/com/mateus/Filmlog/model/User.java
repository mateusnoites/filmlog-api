package com.mateus.Filmlog.model;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    // Nome, Email, Senha, Id, CreatedAt
    @Id
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public User(String id, String nome, String email, String senha, LocalDateTime createdAt) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.createdAt = createdAt;
    }

    public User() {
    }

    @PrePersist
    public void initialize() {
        if (id == null)
            this.id = UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .substring(0, 8);
        if (createdAt == null)
            this.createdAt = LocalDateTime.now();
        criptografarSenha();
    }

    @PreUpdate
    public void criptografarSenha() {
        if (senha != null && !senha.startsWith("$2a$")) {
            var encoder = new BCryptPasswordEncoder();
            this.senha = encoder.encode(this.senha);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
