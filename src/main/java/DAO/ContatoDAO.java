/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Contato;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author André
 */
public class ContatoDAO {

    public ArrayList<Contato> lerBanco() {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Contato> contatos = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT * FROM Contato");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setUsuarioId(rs.getInt("usuarioId"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                contato.setDataAniversario(rs.getString("aniversario"));
                contatos.add(contato);
            }

        } catch (SQLException ex) {
            System.out.println("Tabela não lida");
        } finally {
            Conexao.closeConection(con, stmt, rs);
        }
        return contatos;
    }

    public void inserirBanco(Contato c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("INSERT INTO Contato (usuarioId, nome, telefone, email, aniversario) VALUES(?,?,?,?,?)");
            stmt.setInt(1,c.getUsuarioId());
            stmt.setString(2,c.getNome());
            stmt.setString(3,c.getTelefone());
            stmt.setString(3,c.getEmail());
            stmt.setString(4,c.getDataAniversario());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao Inserir na Tabela Contato");
        } finally {
            Conexao.closeConection(con, stmt);
        }
    }
    public void AtualizarBanco(Contato c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE Contato SET nome = ?, telefone = ?, email = ?, aniversario = ? WHERE id = ?");
            
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getTelefone());
            stmt.setString(3,c.getEmail());
            stmt.setString(4,c.getDataAniversario());
            stmt.setInt(5,c.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao Atualizar na Tabela Contato");
        } finally {
            Conexao.closeConection(con, stmt);
        }
        
    }
    
     public void DeletarNoBanco(Contato c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("DELETE FROM Contato WHERE id = ? AND usuarioID = ?");
            stmt.setInt(1,c.getId());
            stmt.setInt(2,c.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao Deletar na Tabela Contato");
        } finally {
            Conexao.closeConection(con, stmt);
        }
    }
}
