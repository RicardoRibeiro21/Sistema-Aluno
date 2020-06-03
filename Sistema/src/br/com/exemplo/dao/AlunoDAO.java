package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.exemplo.model.Aluno;
import br.com.exemplo.until.ConnectionFactory;

public class AlunoDAO {
	private Aluno aluno;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	public AlunoDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception ("Erro: " + erro.getMessage());
		}
	}
	public void Inserir (Aluno aluno) throws Exception {

		try {
			String sql = "INSERT INTO alunos (rgm, nome, data_nascimento, cpf, email, celular, endereco, municipio, uf, curso, campus, periodo ) "
					   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			ps = conn.prepareStatement(sql);
			ps.setString (1, aluno.getRgm());
			ps.setString (2, aluno.getNome());
			ps.setString (3, aluno.getDataNascimento());
			ps.setString (4, aluno.getCpf());
			ps.setString (5, aluno.getEmail());
			ps.setString (6, aluno.getCelular());
			ps.setString (7, aluno.getEndereco());			
			ps.setString (8, aluno.getMunicipio());
			ps.setString (9, aluno.getUf());
			ps.setString (10, aluno.getCurso());			
			ps.setString (11, aluno.getCampus());
			ps.setString (12, aluno.getPeriodo());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}

	public void Alterar (Aluno aluno) throws Exception {

		try {
			String sql = "UPDATE alunos SET nome=?, data_nascimento=?, cpf=?, email=?, celular=?, endereco=?, municipio=?, uf=?, curso=?, campus=?, periodo=? "
					   + " WHERE rgm = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString (12, aluno.getRgm());
			ps.setString (1, aluno.getNome());
			ps.setString (2, aluno.getDataNascimento());
			ps.setString (3, aluno.getCpf());
			ps.setString (4, aluno.getEmail());
			ps.setString (5, aluno.getCelular());
			ps.setString (6, aluno.getEndereco());			
			ps.setString (7, aluno.getMunicipio());
			ps.setString (8, aluno.getUf());
			ps.setString (9, aluno.getCurso());			
			ps.setString (10, aluno.getCampus());
			ps.setString (11, aluno.getPeriodo());			
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}

	public void Excluir (String rgm) throws Exception {
		try {
			String sql = "DELETE FROM alunos WHERE rgm = ?";
			ps = conn.prepareStatement(sql);
			ps.setString (1, rgm);			
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}

	public boolean verificaRgm (String rgm) {
		boolean mRetorno = false;
		try {
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		return mRetorno;
	}
	public Aluno BuscarPorRgm (String rgm) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM alunos "
									  + " WHERE rgm=?");
			ps.setString (1, rgm);
			rs= ps.executeQuery();
			if(rs.next()) {
				String nome = rs.getString ("nome");
				String dataNascimento = rs.getString ("data_nascimento");
				String cpf = rs.getString ("cpf");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String endereco = rs.getString ("endereco");				
				String municipio = rs.getString ("municipio");
				String uf = rs.getString ("uf");
				String curso = rs.getString ("curso");				
				String campus = rs.getString ("campus");
				String periodo = rs.getString ("periodo");
				aluno = new Aluno (rgm, nome, dataNascimento, cpf, email, celular, endereco, municipio, uf, curso, campus, periodo);
			}
				return aluno;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	
	public List<Aluno> ListarTodos() throws Exception {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM alunos");
			rs = ps.executeQuery();
			while (rs.next()) {
				String rgm = rs.getString ("rgm");
				String nome = rs.getString ("nome");
				String dataNascimento = rs.getString ("data_nascimento");
				String cpf = rs.getString ("cpf");
				String email = rs.getString ("email");
				String celular = rs.getString ("celular");
				String endereco = rs.getString ("endereco");				
				String municipio = rs.getString ("municipio");
				String uf = rs.getString ("uf");
				String curso = rs.getString ("curso");				
				String campus = rs.getString ("campus");
				String periodo = rs.getString ("periodo");
				aluno = new Aluno (rgm, nome, dataNascimento, cpf, email, celular, endereco, municipio, uf, curso, campus, periodo);
				lista.add(aluno);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}		
}
