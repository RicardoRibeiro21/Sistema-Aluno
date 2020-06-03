package br.com.exemplo.model;

public class Aluno {
	// Propriedades da classe
		private String rgm;
		private String nome;
		private String dataNascimento;
		private String cpf;
		private String email;
		private String celular;
		private String endereco;	
		private String municipio;
		private String uf;
		private String curso;
		private String turma;
		private String campus;
		private String periodo;
		
		public Aluno() {  }
		
		public Aluno(String rgm, String nome, String dataNascimento, String cpf, String email, String celular,
				String endereco, String municipio, String uf, String curso, String campus, String periodo) {
			super();
			this.rgm = rgm;
			this.nome = nome;
			this.dataNascimento = dataNascimento;
			this.cpf = cpf;
			this.email = email;
			this.celular = celular;
			this.endereco = endereco;		
			this.municipio = municipio;
			this.uf = uf;
			this.curso = curso;		
			this.campus = campus;		
			this.periodo = periodo;
		}
		
		public String getRgm() {
			return rgm;
		}
		public void setRgm(String rgm) {
			this.rgm = rgm;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCelular() {
			return celular;
		}
		public void setCelular(String celular) {
			this.celular = celular;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getMunicipio() {
			return municipio;
		}
		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}
		public String getUf() {
			return uf;
		}
		public void setUf(String uf) {
			this.uf = uf;
		}
		public String getCurso() {
			return curso;
		}
		public void setCurso(String curso) {
			this.curso = curso;
		}
		public String getCampus() {
			return campus;
		}
		public void setCampus(String campus) {
			this.campus = campus;
		}
		
		public String getPeriodo() {
			return periodo;
		}
		
		public void setPeriodo(String periodo) {
			this.periodo = periodo;
		}
}
