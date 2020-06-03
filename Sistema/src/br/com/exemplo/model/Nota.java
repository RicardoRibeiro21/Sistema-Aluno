package br.com.exemplo.model;

public class Nota {
	//Propriedades
		private String disciplina;
		private String semestre;
		private String nota;
		private int faltas;
		private String rgm;
		
		public Nota() {}
		
		public Nota(String disciplina, String semestre, String nota, int faltas, String rgm) {
			super();
			this.disciplina = disciplina;
			this.semestre = semestre;
			this.nota = nota;
			this.faltas = faltas;
			this.rgm = rgm;
		}

		public String getDisciplina() {
			return disciplina;
		}
		public void setDisciplina(String disciplina) {
			this.disciplina = disciplina;
		}
		public String getSemestre() {
			return semestre;
		}
		public void setSemestre(String semestre) {
			this.semestre = semestre;
		}
		public String getNota() {
			return nota;
		}
		public void setNota(String nota) {
			this.nota = nota;
		}
		public int getFaltas() {
			return faltas;
		}
		public void setFaltas(int faltas) {
			this.faltas = faltas;
		}
		public String getRgm() {
			return rgm;
		}
		public void setRgm(String rgm) {
			this.rgm = rgm;
		}
	}