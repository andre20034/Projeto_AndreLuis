/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author André
 */
public class Usuario {
    private String nomeUsuario;
    private String email;

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public void setContato(ArrayList<Contato> contato) {
        this.contato = contato;
    }
    private String Senha;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return Senha;
    }

    public ArrayList<Contato> getContato() {
        return contato;
    }
    private ArrayList<Contato> contato;
}
