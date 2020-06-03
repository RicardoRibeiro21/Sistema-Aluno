package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Nota;
import br.com.exemplo.until.ConnectionFactory;

public class NotaDAO {
	private Nota notas;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public NotaDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception erro) {
			throw new Exception (erro.getMessage());
		}
	}
	public void Salvar (Nota notas) throws Exception {
		try {
			String sql = "INSERT INTO notas_faltas (disciplina, semestre, nota, falta, rgm ) "
					  + " VALUES (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString (1, notas.getDisciplina());
			ps.setString (2, notas.getSemestre());
			ps.setString (3, notas.getNota());
			ps.setInt (4, notas.getFaltas());
			ps.setString (5, notas.getRgm());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public void Alterar (Nota notas) throws Exception {
		try {
			String sql = "UPDATE notas_faltas SET disciplina=?, semestre=?, nota=?, falta=? "
					   + " WHERE rgm=?";
			ps = conn.prepareStatement(sql);
			ps.setString (1, notas.getDisciplina());
			ps.setString (2, notas.getSemestre());
			ps.setString (3, notas.getNota());
			ps.setInt (4, notas.getFaltas());
			ps.setString (5, notas.getRgm());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}

	public void Excluir (String rgm) throws Exception {
		try {
			String sql = "DELETE FROM notas_faltas WHERE rgm = ?";
			ps = conn.prepareStatement(sql);
			ps.setString (1, rgm);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public Nota ConsultarNotas (String rgm) throws Exception {
		try {
			ps = conn.prepareStatement ("SELECT * FROM notas_faltas "
									  + " WHERE rgm=?");
			ps.setString (1, rgm);
			rs= ps.executeQuery();
			Nota nota = new Nota ();
			if(rs.next()) {
				nota.setDisciplina(rs.getString("disciplina"));				
				nota.setSemestre(rs.getString ("semestre"));
				nota.setNota(rs.getString("nota"));
				nota.setFaltas(rs.getInt ("falta"));
			}
			return nota;
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	
	public List<Nota> ListarTodos() throws Exception {
		List<Nota> lista = new ArrayList<Nota>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM notas_faltas ");
			rs = ps.executeQuery();
			while (rs.next()) {
				String disciplina = rs.getString ("disciplina");
				String semestre = rs.getString ("semestre");
				String nota = rs.getString ("nota");
				int faltas = rs.getInt ("falta");
				String rgm = rs.getString ("rgm");
				notas = new Nota (disciplina, semestre, nota, faltas, rgm);
				lista.add(notas);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
	public List<Nota> ConsultarNotasRgm (String pRgm) throws Exception {
		List<Nota> lista = new ArrayList<Nota>();
		try {
			ps = conn.prepareStatement ("SELECT * FROM notas_faltas WHERE rgm=? ");
			ps.setString (1, pRgm);
			rs = ps.executeQuery();
			while (rs.next()) {
				String disciplina = rs.getString ("disciplina");
				String semestre = rs.getString ("semestre");
				String nota = rs.getString ("nota");
				int faltas = rs.getInt ("falta");
				String rgm = rs.getString ("rgm");
				notas = new Nota (disciplina, semestre, nota, faltas, rgm);
				lista.add(notas);
			}
			return lista;
		}catch (Exception e) {
			throw new Exception (e.getMessage());
		}
	}
}