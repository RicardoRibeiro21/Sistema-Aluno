package br.com.exemplo.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.exemplo.dao.AlunoDAO;
import br.com.exemplo.dao.NotaDAO;
import br.com.exemplo.model.Aluno;
import br.com.exemplo.model.Nota;

public class TelaInicial extends JFrame {
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenuItem menuSalvarAluno;
	private JMenuItem menuAlterarAluno;
	private JMenuItem menuConsultarAluno;
	private JMenuItem menuExcluirAluno;
	private JSeparator separator;
	private JMenuItem menuSair;
	private JMenu mnNotasFaltas;
	private JMenuItem menuSalvarNota;
	private JMenuItem menuAlterarNota;
	private JMenuItem menuExcluirNota;
	private JMenuItem menuConsultarNota;
	private JMenu mnAjuda;
	private JMenuItem menuSobre;
	private JTabbedPane tabbedPane;
	private JPanel tabDadosPessoais;
	private JPanel tabCurso;
	private JPanel tabNotasFaltas;
	private JLabel lblRGM;
	private JLabel lblDataNascimento;
	private JLabel lblEmail;
	private JLabel lblEndereco;
	private JLabel lblMunicipio;
	private JLabel lblUF;
	private JLabel lblCelular;
	private JLabel lblNome;
	private JLabel lblCPF;
	private JFormattedTextField ftfRgm;
	private JFormattedTextField ftfDataNascimento;
	private JFormattedTextField ftfCpf;
	private JComboBox cboUF;
	private JFormattedTextField ftfCelular;
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JLabel lblPeriodo;
	private JComboBox cboCurso;
	private JComboBox cboCampus;
	private JRadioButton btnMatutino;
	private JRadioButton btnVespertino;
	private JRadioButton btnNoturno;
	private JLabel lblRgmNf;
	private JFormattedTextField ftfRgmConsultar;
	private JLabel lblNomeAlunoNf;
	private JLabel lblDisciplinaNf;
	private JComboBox cboDisciplina;
	private JLabel lblSemestreNf;
	private JComboBox cboSemestre;
	private JLabel lblNota;
	private JLabel lblFaltas;
	private JFormattedTextField ftfFaltas;
	private JLabel lblNomeNf;
	private JLabel lblCursoNf;
	private JButton btnLimparDados;
	private JButton btnSalvarAluno;
	private JButton btnConsultarAluno;
	private JButton btnAlterarAluno;
	private JButton btnSair;
	private JButton btnLimparDadosNota;
	private JButton btnSalvarNota;
	private JButton btnConsultarNota;
	private JButton btnExcluirNota;
	private JButton btnAlterarNota;
	private JButton btnSairNf;
	private JButton btnExcluirAluno;
	private JPanel panel;
	private JLabel lblRgmBoletim;
	private JLabel lblNomeConsultarBoletim;
	private JLabel lblNomeBoletim;
	private JLabel lblCursoConsultarBoletim;
	private JLabel lblCursoBoletim;
	private JLabel lblSemestreConsultarBoletim;
	private JLabel lblSemestreBoletim;
	private JFormattedTextField ftfNota;
	private JButton btnListarAlunos;
	private JButton btnListarNotas;
	private JMenuItem menuListarAlunos;
	private JMenuItem menuListarNotas;
	private JFormattedTextField ftfRgmBoletim;
	private JButton btnConsultarBoletim;
	private JScrollPane grid;
	private JTable tabBoletim;
	private JTextField txtMunicipio;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtNome;
	private JLabel lblVerificacaoNota;
	private TextArea txtListagemAluno;
	private JLabel lblVerificacao;
	private TextArea txtLitagemNotas;
	private JLabel lblCursoAlunoNf;
	private JLabel lblVerificacaoBoletim;

	//Formatação de campos
	private void formatarCampo() {
		try {
			MaskFormatter formatarRgm = new MaskFormatter("#######-#");
			formatarRgm.install(ftfRgm);
			formatarRgm.install(ftfRgmConsultar);
			formatarRgm.install(ftfRgmBoletim);
			MaskFormatter formatarDataNascimento = new MaskFormatter("##/##/####");
			formatarDataNascimento.install(ftfDataNascimento);
			MaskFormatter formatarCpf = new MaskFormatter ("###.###.###-##");
			formatarCpf.install(ftfCpf);
			MaskFormatter formatarCelular = new MaskFormatter ("(##) #####-####");
			formatarCelular.install(ftfCelular);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar o campo: Erro: " + e.getMessage());
		}
	}
	
	private boolean verificaCampos() {
		try {
			if(ftfRgm.getText().equals ("") || txtNome.getText().equals("") || ftfDataNascimento.getText().equals("") 
					|| ftfCpf.getText().equals("") || txtEmail.getText().equals("") 
					|| ftfCelular.getText().equals("") || txtEndereco.getText().equals("") 
					|| txtMunicipio.getText().equals("") || cboUF.getSelectedItem().toString().equals("") 
					|| cboCurso.getSelectedItem().toString().equals("") || cboCampus.getSelectedItem().toString().equals("")) {
				return false;
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
		return true;
	}
	
	private void limpaDadosAluno() {
		try	{
			ftfRgm.setText(null);
			txtNome.setText(null);
			ftfDataNascimento.setText(null);
			ftfCpf.setText(null);
			txtEmail.setText(null);
			ftfCelular.setText(null);
			txtEndereco.setText(null);
			txtMunicipio.setText(null);
			cboUF.setSelectedIndex(0);
			cboCurso.setSelectedIndex(0);				
			cboCampus.setSelectedIndex(0);
			lblVerificacaoNota.setText(null);
			btnMatutino.setSelected(false);
			btnVespertino.setSelected(false);
			btnNoturno.setSelected(false);
			lblVerificacaoNota.setText(null);
			txtListagemAluno.setText(null);
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	private void limpaDadosNota() 
	{
		try {
			lblNomeAlunoNf.setText(null);
			lblCursoAlunoNf.setText(null);
			cboSemestre.setSelectedIndex(0);
			cboDisciplina.setSelectedIndex(0);
			ftfNota.setText(null);
			ftfFaltas.setText(null);
			lblVerificacaoNota.setText(null);
			txtLitagemNotas.setText(null);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	private void limpaDadosBoletim() {
		try {
			lblNomeBoletim.setText(null);					
			lblCursoBoletim.setText(null);
			lblSemestreBoletim.setText(null);
			lblVerificacaoBoletim.setText(null);
		}
		catch (Exception ex) {
			ex.getMessage();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setTitle(" Cadastro de Aluno");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/br/com/exemplo/view/images/IconePrograma.png")));
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 14));
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 515);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAluno = new JMenu("Aluno");
		mnAluno.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnAluno);
		
		menuSalvarAluno = new JMenuItem("Salvar");
		menuSalvarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno = new Aluno();
					aluno.setRgm(ftfRgm.getText());
					aluno.setNome(txtNome.getText());
					aluno.setDataNascimento(ftfDataNascimento.getText());
					aluno.setCpf(ftfCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setCelular(ftfCelular.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf(cboUF.getSelectedItem().toString());
					aluno.setCurso(cboCurso.getSelectedItem().toString());
					aluno.setCampus(cboCampus.getSelectedItem().toString());
					if (btnMatutino.isSelected()) {
						aluno.setPeriodo("Matutino");
					}
					else if (btnVespertino.isSelected()) {
						aluno.setPeriodo("Vespertino");
					}
					else if (btnNoturno.isSelected()) {
						aluno.setPeriodo("Noturno");
					}
					
					if (verificaCampos()) {						
						lblVerificacaoNota.setText("Erro ao Salvar: Preencha todos os campo.");
					}
					AlunoDAO dao = new AlunoDAO();
					dao.Inserir(aluno);
					lblVerificacaoNota.setText ("Salvo com Sucesso!!");
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1.getMessage().toString());
				}
			}
		});
		menuSalvarAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuSalvarAluno.setFont(new Font("Arial", Font.BOLD, 12));
		mnAluno.add(menuSalvarAluno);
		
		menuAlterarAluno = new JMenuItem("Alterar");
		menuAlterarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno = new Aluno();
					aluno.setRgm(ftfRgm.getText());
					aluno.setNome(txtNome.getText());
					aluno.setDataNascimento(ftfDataNascimento.getText());
					aluno.setCpf(ftfCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setCelular(ftfCelular.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf(cboUF.getSelectedItem().toString());
					aluno.setCurso(cboCurso.getSelectedItem().toString());
					aluno.setCampus(cboCampus.getSelectedItem().toString());
					if (btnMatutino.isSelected()) {
						aluno.setPeriodo("Matutino");
					}
					else if (btnVespertino.isSelected()) {
						aluno.setPeriodo("Vespertino");
					}
					else if (btnNoturno.isSelected()) {
						aluno.setPeriodo("Noturno");
					}
					AlunoDAO alunoDao = new AlunoDAO(); 
					alunoDao.Alterar(aluno);
					lblVerificacaoNota.setText("Alterado com Sucesso!!");
				}catch(Exception e1) {
					lblVerificacaoNota.setText("Erro ao Alterar " + e1.getMessage());
				}
			}
		});
		menuAlterarAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuAlterarAluno.setFont(new Font("Arial", Font.BOLD, 12));
		mnAluno.add(menuAlterarAluno);
		
		menuConsultarAluno = new JMenuItem("Consultar");
		menuConsultarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rgm = ftfRgm.getText();
				try {
					limpaDadosAluno();
					AlunoDAO alunoDao = new AlunoDAO();
					Aluno aluno = new Aluno();
					aluno = alunoDao.BuscarPorRgm(rgm);
					ftfRgm.setText(aluno.getRgm());
					txtNome.setText (aluno.getNome());
					ftfDataNascimento.setText (aluno.getDataNascimento());
					ftfCpf.setText (aluno.getCpf());
					txtEmail.setText (aluno.getEmail());
					ftfCelular.setText (aluno.getCelular());
					txtEndereco.setText (aluno.getEndereco());
					txtMunicipio.setText (aluno.getMunicipio());
					cboUF.setSelectedItem(aluno.getUf());
					cboCurso.setSelectedItem(aluno.getCurso());
					cboCampus.setSelectedItem(aluno.getCampus());
					if (aluno.getPeriodo().equals("Matutino")) {
						btnMatutino.setSelected(true);
					}
					else if (aluno.getPeriodo().equals("Vespertino")) {
						btnVespertino.setSelected(true);
					}
					else if (aluno.getPeriodo().equals("Noturno")) {
						btnNoturno.setSelected(true);
					}
					else {
						btnMatutino.setSelected(false);
						btnVespertino.setSelected(false);
						btnNoturno.setSelected(false);
					}
					lblVerificacaoNota.setText( "Consulta Realizada com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacaoNota.setText ("Erro ao Consultar. Erro: " + e1.getMessage());
				}
			}
		});
		menuConsultarAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		menuConsultarAluno.setFont(new Font("Arial", Font.BOLD, 12));
		mnAluno.add(menuConsultarAluno);
		
		menuExcluirAluno = new JMenuItem("Excluir");
		menuExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpaDadosAluno();
					AlunoDAO alunoDao = new AlunoDAO();
					NotaDAO notaDao = new NotaDAO();
					String rgm = ftfRgm.getText();
					alunoDao.Excluir(rgm);
					notaDao.Excluir(rgm);
					lblVerificacaoNota.setText("Excluido com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacaoNota.setText("Erro ao Excluir. Erro: " + e1.getMessage());
				}
			}
		});
		
		menuListarAlunos = new JMenuItem("Listar Todos");
		menuListarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpaDadosAluno();
					List<Aluno> lista = new ArrayList<Aluno>();
					AlunoDAO alunoDao = new AlunoDAO();
					lista = alunoDao.ListarTodos();
					for (Aluno aluno : lista) {
						txtListagemAluno.append ("RGM: " + aluno.getRgm() + "\n");
						txtListagemAluno.append ("Nome:: " + aluno.getNome() + "\n");
						txtListagemAluno.append ("Data de Nascimento: " + aluno.getDataNascimento() + "\n");
						txtListagemAluno.append ("CPF: " + aluno.getCpf() + "\n");
						txtListagemAluno.append ("Email: " + aluno.getEmail() + "\n");
						txtListagemAluno.append ("Celular: " + aluno.getCelular() + "\n");
						txtListagemAluno.append ("Endereço: " + aluno.getEndereco() + "\n");
						txtListagemAluno.append ("Municipio: " + aluno.getMunicipio() + "\n");
						txtListagemAluno.append ("UF: " + aluno.getUf() + "\n");
						txtListagemAluno.append ("Curso: " + aluno.getCurso() + "\n");
						txtListagemAluno.append ("Campus: " + aluno.getCampus() + "\n");
						txtListagemAluno.append ("Periodo: " + aluno.getPeriodo() + "\n\n");
						lblVerificacaoNota.setText ("Dados Listados com Sucesso!!");
					} 
				} catch (Exception e1) {
					lblVerificacaoNota.setText ("Erroao Listar. Erro: " + e1.getMessage());
				}
			}
		});
		menuListarAlunos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		menuListarAlunos.setFont(new Font("Arial", Font.BOLD, 12));
		mnAluno.add(menuListarAlunos);
		menuExcluirAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		menuExcluirAluno.setFont(new Font("Arial", Font.BOLD, 12));
		mnAluno.add(menuExcluirAluno);
		
		separator = new JSeparator();
		mnAluno.add(separator);
		
		menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		menuSair.setFont(new Font("Arial", Font.BOLD, 12));
		mnAluno.add(menuSair);
		
		mnNotasFaltas = new JMenu("Notas e Faltas");
		mnNotasFaltas.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnNotasFaltas);
		
		menuSalvarNota = new JMenuItem("Salvar");
		menuSalvarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Nota nota = new Nota();
					nota.setDisciplina(cboDisciplina.getSelectedItem().toString());
					nota.setSemestre(cboSemestre.getSelectedItem().toString());
					nota.setNota(ftfNota.getText());
					nota.setFaltas(Integer.parseInt(ftfFaltas.getText()));
					nota.setRgm(ftfRgmConsultar.getText());
					NotaDAO notaDao = new NotaDAO();
					notaDao.Salvar(nota);
					lblVerificacaoNota.setText ("Salvo com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacaoNota.setText ("Erro ao Salvar: " + e1.getMessage());
				}
			}
		});
		menuSalvarNota.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuSalvarNota.setFont(new Font("Arial", Font.BOLD, 12));
		mnNotasFaltas.add(menuSalvarNota);
		
		menuAlterarNota = new JMenuItem("Alterar");
		menuAlterarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Nota nota = new Nota();
					nota.setRgm(ftfRgmConsultar.getText());
					nota.setDisciplina(cboDisciplina.getSelectedItem().toString());
					nota.setSemestre(cboSemestre.getSelectedItem().toString());
					nota.setNota(ftfNota.getText());
					nota.setFaltas(Integer.parseInt(ftfFaltas.getText()));
					NotaDAO notaDao = new NotaDAO();
					notaDao.Alterar(nota);
					lblVerificacaoNota.setText("Alterado com Sucesso!!");
				}catch(Exception e1) {
					lblVerificacaoNota.setText("Erro ao Alterar " + e1.getMessage());
				}
			}
		});
		menuAlterarNota.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuAlterarNota.setFont(new Font("Arial", Font.BOLD, 12));
		mnNotasFaltas.add(menuAlterarNota);
		
		menuConsultarNota = new JMenuItem("Consultar");
		menuConsultarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rgm = ftfRgmConsultar.getText();
				try {
					limpaDadosNota();
					List <Nota> listaNota = new ArrayList<Nota>();
					NotaDAO notaDao = new NotaDAO();
					listaNota = notaDao.ConsultarNotasRgm(rgm);
					for (Nota nota : listaNota) {
						txtLitagemNotas.append ("Disciplina: " + nota.getDisciplina() + "\n");
						txtLitagemNotas.append ("Nota: " + nota.getNota() + "\n");
						txtLitagemNotas.append ("Faltas: " + nota.getFaltas() + "\n\n");
					}
					NotaDAO dao2 = new NotaDAO();
					Nota notas = dao2.ConsultarNotas(rgm);
					cboSemestre.setSelectedItem(notas.getSemestre());
					AlunoDAO dao3 = new AlunoDAO();
					Aluno aluno = dao3.BuscarPorRgm(rgm);
					lblNomeAlunoNf.setText(aluno.getNome());
					lblCursoAlunoNf.setText(aluno.getCurso());
					lblVerificacaoNota.setText ("Consulta Realizada com Sucesso!!");
					ftfNota.setText ("--------");
					ftfFaltas.setText ("--------");
					cboDisciplina.setSelectedIndex(7);
				} catch (Exception e1) {
					lblVerificacaoNota.setText ("Erro ao Consultar. Erro: " + e1.getMessage());
				}
			}
		});
		menuConsultarNota.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		menuConsultarNota.setFont(new Font("Arial", Font.BOLD, 12));
		mnNotasFaltas.add(menuConsultarNota);
		
		menuExcluirNota = new JMenuItem("Excluir");
		menuExcluirNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpaDadosNota();
					NotaDAO dao = new NotaDAO();
					String rgm = ftfRgmConsultar.getText();
					dao.Excluir(rgm);
					lblVerificacaoNota.setText("Excluido com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacaoNota.setText("Erro ao Excluir. Erro: " + e1.getMessage());
				}
			}
		});
		
		menuListarNotas = new JMenuItem("Listar Todos");
		menuListarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpaDadosNota();
					List <Nota> listaNota = new ArrayList <Nota>();
					List <Aluno> listaAluno = new ArrayList <Aluno>();
					NotaDAO notaDao = new NotaDAO();
					AlunoDAO alunoDao = new AlunoDAO();					
					listaAluno = alunoDao.ListarTodos();
					for (Aluno aluno : listaAluno) {
						String rgm = aluno.getRgm();
						listaNota = notaDao.ConsultarNotasRgm (rgm);
						txtLitagemNotas.append ("RGM: " + aluno.getRgm() + "\n");
						txtLitagemNotas.append ("Nome: " + aluno.getNome() + "\n");
						txtLitagemNotas.append ("Curso: " + aluno.getCurso() + "\n");
						for (Nota nota : listaNota) {
							txtLitagemNotas.append ("Semestre: " + nota.getSemestre() + "\n");
							txtLitagemNotas.append ("Disciplina: " + nota.getDisciplina() + "\n");
							txtLitagemNotas.append ("Nota: " + nota.getNota() + "\n");
							txtLitagemNotas.append ("Faltas: " + nota.getFaltas() + "\n\n");
						}
						txtLitagemNotas.append ("---------------------------------------------------------------------------------------------------------------------\n\n");
					}
					lblVerificacaoNota.setText("Dados Listados com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacaoNota.setText ("Erro ao Listar. Erro: " + e1.getMessage());
				}
			}
		});
		menuListarNotas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		menuListarNotas.setFont(new Font("Arial", Font.BOLD, 12));
		mnNotasFaltas.add(menuListarNotas);
		menuExcluirNota.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		menuExcluirNota.setFont(new Font("Arial", Font.BOLD, 12));
		mnNotasFaltas.add(menuExcluirNota);
		
		mnAjuda = new JMenu("Ajuda");
		mnAjuda.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnAjuda);
		
		menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String osName = System.getProperty("os.name");
				String osVersion = System.getProperty("os.version");
				String javaI = System.getProperty("java.version");
				String javaRE = System.getProperty("java.runtime.version");
				JOptionPane.showMessageDialog(null, "====================Sobre o Sistema===================="
						+ "\n Instalado: " + osName + " e Versão: " + osVersion
						+ "\n Versão do Java: " + javaI + " e Versão da Runtime: " + javaRE
						+ "\n=====================================================");
			}
		});
		menuSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		menuSobre.setFont(new Font("Arial", Font.BOLD, 12));
		mnAjuda.add(menuSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 704, 434);
		contentPane.add(tabbedPane);
		
		tabDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, tabDadosPessoais, null);
		tabbedPane.setFont(new Font ("Arial", Font.PLAIN, 12));
		tabDadosPessoais.setLayout(null);
		
		lblRGM = new JLabel("RGM");
		lblRGM.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRGM.setBounds(34, 24, 33, 20);
		tabDadosPessoais.add(lblRGM);
		
		ftfRgm = new JFormattedTextField();
		ftfRgm.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfRgm.setBounds(79, 21, 178, 23);
		formatarCampo();
		tabDadosPessoais.add(ftfRgm);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(286, 24, 45, 20);
		tabDadosPessoais.add(lblNome);
		
		lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataNascimento.setBounds(34, 60, 101, 20);
		tabDadosPessoais.add(lblDataNascimento);
		
		ftfDataNascimento = new JFormattedTextField();
		ftfDataNascimento.setToolTipText("");
		ftfDataNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfDataNascimento.setBounds(143, 57, 118, 23);
		formatarCampo();
		tabDadosPessoais.add(ftfDataNascimento);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCPF.setBounds(286, 57, 35, 20);
		tabDadosPessoais.add(lblCPF);
		
		ftfCpf = new JFormattedTextField();
		ftfCpf.setActionCommand("   .   .   -  ");
		ftfCpf.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfCpf.setBounds(333, 57, 336, 23);
		formatarCampo();
		tabDadosPessoais.add(ftfCpf);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(34, 95, 57, 20);
		tabDadosPessoais.add(lblEmail);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(445, 167, 57, 20);
		tabDadosPessoais.add(lblCelular);
		
		ftfCelular = new JFormattedTextField();
		ftfCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfCelular.setBounds(506, 164, 163, 23);
		formatarCampo();
		tabDadosPessoais.add(ftfCelular);
		
		lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereco.setBounds(33, 130, 57, 20);
		tabDadosPessoais.add(lblEndereco);
		formatarCampo();
		
		lblMunicipio = new JLabel("Munic\u00EDpio");
		lblMunicipio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMunicipio.setBounds(34, 165, 67, 20);
		tabDadosPessoais.add(lblMunicipio);
		
		lblUF = new JLabel("UF");
		lblUF.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUF.setBounds(320, 167, 33, 20);
		tabDadosPessoais.add(lblUF);
		
		cboUF = new JComboBox();
		cboUF.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		cboUF.setFont(new Font("Arial", Font.PLAIN, 14));
		cboUF.setBorder(null);
		cboUF.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		cboUF.setBounds(351, 164, 57, 23);
		tabDadosPessoais.add(cboUF);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setBounds(101, 165, 160, 22);
		tabDadosPessoais.add(txtMunicipio);
		txtMunicipio.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(101, 129, 568, 22);
		tabDadosPessoais.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(103, 93, 566, 22);
		tabDadosPessoais.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(333, 22, 336, 22);
		tabDadosPessoais.add(txtNome);
		txtNome.setColumns(10);
		
		tabCurso = new JPanel();
		tabbedPane.addTab("Curso", null, tabCurso, null);
		tabCurso.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCurso.setBounds(42, 29, 55, 20);
		tabCurso.add(lblCurso);
		
		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCampus.setBounds(42, 64, 61, 20);
		tabCurso.add(lblCampus);
		
		lblPeriodo = new JLabel("Per\u00EDodo");
		lblPeriodo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPeriodo.setBounds(42, 114, 55, 20);
		tabCurso.add(lblPeriodo);
		
		cboCurso = new JComboBox();
		cboCurso.setModel(new DefaultComboBoxModel(new String[] {"An\u00E1lise e Desenvolvimento de Sistemas", "Psicologia", "Redes e computadores"}));
		cboCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		cboCurso.setBounds(107, 30, 463, 23);
		tabCurso.add(cboCurso);
		
		cboCampus = new JComboBox();
		cboCampus.setModel(new DefaultComboBoxModel(new String[] {"Tatuap\u00E9", "Pinheiros"}));
		cboCampus.setFont(new Font("Arial", Font.PLAIN, 12));
		cboCampus.setBounds(107, 64, 463, 23);
		tabCurso.add(cboCampus);
		
		btnMatutino = new JRadioButton("Matutino");
		btnMatutino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnMatutino.isSelected()) {
					btnVespertino.setSelected(false);
					btnNoturno.setSelected(false);
				}
			}
		});
		btnMatutino.setFont(new Font("Arial", Font.PLAIN, 12));
		btnMatutino.setBounds(105, 111, 80, 23);
		tabCurso.add(btnMatutino);
		
		btnVespertino = new JRadioButton("Vespertino");
		btnVespertino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnVespertino.isSelected()) {
					btnMatutino.setSelected(false);
					btnNoturno.setSelected(false);
				}
			}
		});
		btnVespertino.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVespertino.setBounds(189, 111, 86, 23);
		tabCurso.add(btnVespertino);
		
		btnNoturno = new JRadioButton("Noturno");
		btnNoturno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNoturno.isSelected()) {
					btnMatutino.setSelected(false);
					btnVespertino.setSelected(false);
				}
			}
		});
		btnNoturno.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNoturno.setBounds(287, 111, 101, 23);
		tabCurso.add(btnNoturno);
		
		btnLimparDados = new JButton("Limpar dados");
		btnLimparDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaDadosAluno();
			}
		});
		btnLimparDados.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimparDados.setBounds(504, 108, 124, 29);
		tabCurso.add(btnLimparDados);
		
		btnSalvarAluno = new JButton("");
		btnSalvarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno = new Aluno();
					aluno.setRgm(ftfRgm.getText());
					aluno.setNome(txtNome.getText());
					aluno.setDataNascimento(ftfDataNascimento.getText());
					aluno.setCpf(ftfCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setCelular(ftfCelular.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf(cboUF.getSelectedItem().toString());
					aluno.setCurso(cboCurso.getSelectedItem().toString());
					aluno.setCampus(cboCampus.getSelectedItem().toString());
					if (btnMatutino.isSelected()) {
						aluno.setPeriodo("Matutino");
					}
					else if (btnVespertino.isSelected()) {
						aluno.setPeriodo("Vespertino");
					}
					else if (btnNoturno.isSelected()) {
						aluno.setPeriodo("Noturno");
					}
					else {
						lblVerificacaoNota.setText("Erro ao Salvar: Preencha todos os campo.");
					}					
					if (!verificaCampos()) {
						JOptionPane.showMessageDialog  (null, "Preencha todos os campo.");
						lblVerificacaoNota.setText("Erro ao Salvar: Preencha todos os campo.");
					} else {
						AlunoDAO alunoDao = new AlunoDAO();
						alunoDao.Inserir(aluno);
						lblVerificacao.setText ("Salvo com Sucesso!!");						
					}
				} catch (Exception e1) {
					lblVerificacao.setText ("Erro ao Salvar: " + e1.getMessage());
				}
			}
		});
		btnSalvarAluno.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvarAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvarAluno.setBounds(42, 160, 80, 72);
		tabCurso.add(btnSalvarAluno);
		
		btnConsultarAluno = new JButton("");
		btnConsultarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rgm = ftfRgm.getText();
				try {
					limpaDadosAluno();
					AlunoDAO alunoDao = new AlunoDAO();
					Aluno aluno = new Aluno();
					aluno = alunoDao.BuscarPorRgm(rgm);
					ftfRgm.setText(aluno.getRgm());
					txtNome.setText (aluno.getNome());
					ftfDataNascimento.setText (aluno.getDataNascimento());
					ftfCpf.setText (aluno.getCpf());
					txtEmail.setText (aluno.getEmail());
					ftfCelular.setText (aluno.getCelular());
					txtEndereco.setText (aluno.getEndereco());
					txtMunicipio.setText (aluno.getMunicipio());
					cboUF.setSelectedItem(aluno.getUf());
					cboCurso.setSelectedItem(aluno.getCurso());
					cboCampus.setSelectedItem(aluno.getCampus());
					if (aluno.getPeriodo().equals("Matutino")) {
						btnMatutino.setSelected(true);
					}
					else if (aluno.getPeriodo().equals("Vespertino")) {
						btnVespertino.setSelected(true);
					}
					else if (aluno.getPeriodo().equals("Noturno")) {
						btnNoturno.setSelected(true);
					}
					else {
						btnMatutino.setSelected(false);
						btnVespertino.setSelected(false);
						btnNoturno.setSelected(false);
					}
					lblVerificacao.setText( "Consulta Realizada com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacao.setText ("Erro ao Consultar. Erro: " + e1.getMessage());
				}
			}
		});
		btnConsultarAluno.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/notes.png")));
		btnConsultarAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultarAluno.setBounds(246, 160, 80, 72);
		tabCurso.add(btnConsultarAluno);
		
		btnAlterarAluno = new JButton("");
		btnAlterarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno = new Aluno();
					aluno.setRgm(ftfRgm.getText());
					aluno.setNome(txtNome.getText());
					aluno.setDataNascimento(ftfDataNascimento.getText());
					aluno.setCpf(ftfCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setCelular(ftfCelular.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf(cboUF.getSelectedItem().toString());
					aluno.setCurso(cboCurso.getSelectedItem().toString());
					aluno.setCampus(cboCampus.getSelectedItem().toString());
					if (btnMatutino.isSelected()) {
						aluno.setPeriodo("Matutino");
					}
					else if (btnVespertino.isSelected()) {
						aluno.setPeriodo("Vespertino");
					}
					else if (btnNoturno.isSelected()) {
						aluno.setPeriodo("Noturno");
					}
					AlunoDAO alunoDao = new AlunoDAO();
					alunoDao.Alterar(aluno);					
					lblVerificacao.setText("Aluno " + aluno.getRgm() + " alterado!");
				}catch(Exception e1) {
					lblVerificacao.setText("Erro ao Alterar " + e1.getMessage());
				}
			}
		});
		btnAlterarAluno.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/Atualizar.png")));
		btnAlterarAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterarAluno.setBounds(143, 160, 80, 72);
		tabCurso.add(btnAlterarAluno);
		
		btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/power-off.png")));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSair.setBounds(548, 160, 80, 72);
		tabCurso.add(btnSair);
		
		btnExcluirAluno = new JButton("");
		btnExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AlunoDAO alunoDao = new AlunoDAO();
					NotaDAO notaDao = new NotaDAO();
					String rgm = ftfRgm.getText();
					alunoDao .Excluir(rgm);
					notaDao.Excluir(rgm);			
					lblVerificacao.setText("Excluido com Sucesso!!");
					limpaDadosAluno();
				} catch (Exception e1) {					
					lblVerificacao.setText("Erro ao Excluir. Erro: " + e1.getMessage());
				}
			}
		});
		btnExcluirAluno.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/Delete.png")));
		btnExcluirAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluirAluno.setBounds(348, 160, 80, 72);
		tabCurso.add(btnExcluirAluno);
		
		btnListarAlunos = new JButton("");
		btnListarAlunos.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/procurar.png")));
		btnListarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpaDadosAluno();
					List<Aluno> listaAluno = new ArrayList<Aluno>();
					AlunoDAO alunoDao = new AlunoDAO();
					listaAluno = alunoDao.ListarTodos();
					for (Aluno aluno : listaAluno) {
						txtListagemAluno.append ("RGM: " + aluno.getRgm() + "\n");
						txtListagemAluno.append ("Nome:: " + aluno.getNome() + "\n");
						txtListagemAluno.append ("Data de Nascimento: " + aluno.getDataNascimento() + "\n");
						txtListagemAluno.append ("CPF: " + aluno.getCpf() + "\n");
						txtListagemAluno.append ("Email: " + aluno.getEmail() + "\n");
						txtListagemAluno.append ("Celular: " + aluno.getCelular() + "\n");
						txtListagemAluno.append ("Endereço: " + aluno.getEndereco() + "\n");
						txtListagemAluno.append ("Municipio: " + aluno.getMunicipio() + "\n");
						txtListagemAluno.append ("UF: " + aluno.getUf() + "\n");
						txtListagemAluno.append ("Curso: " + aluno.getCurso() + "\n");
						txtListagemAluno.append ("Campus: " + aluno.getCampus() + "\n");
						txtListagemAluno.append ("Periodo: " + aluno.getPeriodo() + "\n\n");						
						lblVerificacao.setText ("Dados Listados com Sucesso!!");
					} 
				} catch (Exception e1) {
					lblVerificacao.setText ("Erro ao Listar. Erro: " + e1.getMessage());					
				}
			}
		});
		btnListarAlunos.setFont(new Font("Arial", Font.PLAIN, 12));
		btnListarAlunos.setBounds(446, 160, 80, 72);
		tabCurso.add(btnListarAlunos);
		
		txtListagemAluno = new TextArea();
		txtListagemAluno.setBounds(42, 244, 587, 113);
		tabCurso.add(txtListagemAluno);
		
		lblVerificacao = new JLabel("...");
		lblVerificacao.setForeground(new Color(250, 128, 114));
		lblVerificacao.setBackground(new Color(255, 255, 255));
		lblVerificacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerificacao.setFont(new Font("Arial", Font.BOLD, 14));
		lblVerificacao.setBounds(12, 370, 659, 16);
		tabCurso.add(lblVerificacao);
		tabbedPane.setFont(new Font ("Arial", Font.PLAIN, 12));
		tabbedPane.setFont(new Font ("Arial", Font.PLAIN, 12));
		formatarCampo();
		tabbedPane.setFont(new Font ("Arial", Font.PLAIN, 12));
		tabbedPane.setFont(new Font ("Arial", Font.PLAIN, 12));
		
		tabNotasFaltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, tabNotasFaltas, null);
		tabNotasFaltas.setLayout(null);
		
		lblRgmNf = new JLabel("RGM");
		lblRgmNf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRgmNf.setBounds(37, 13, 46, 20);
		tabNotasFaltas.add(lblRgmNf);
		
		ftfRgmConsultar = new JFormattedTextField();
		ftfRgmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rgm = ftfRgmConsultar.getText();
				try {
					limpaDadosNota();
					AlunoDAO alunoDao = new AlunoDAO();
					Aluno aluno = new Aluno();
					aluno = alunoDao.BuscarPorRgm(rgm);
					lblNomeAlunoNf.setText(aluno.getNome());
					lblCursoAlunoNf.setText(aluno.getCurso());
				} catch (Exception e1) {					
					lblVerificacaoNota.setText ("Erro ao Consultar. Erro: " + e1.getMessage());
				}
			}
		});
		ftfRgmConsultar.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfRgmConsultar.setBounds(93, 11, 136, 23);
		tabNotasFaltas.add(ftfRgmConsultar);
		
		lblNomeAlunoNf = new JLabel("");
		lblNomeAlunoNf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeAlunoNf.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNomeAlunoNf.setBounds(297, 11, 384, 23);
		tabNotasFaltas.add(lblNomeAlunoNf);
		
		lblDisciplinaNf = new JLabel("Disciplina");
		lblDisciplinaNf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDisciplinaNf.setBounds(37, 78, 66, 20);
		tabNotasFaltas.add(lblDisciplinaNf);
		
		cboDisciplina = new JComboBox();
		cboDisciplina.setModel(new DefaultComboBoxModel(new String[] {"Engenharia de Software", "An\u00E1lise e Projeto de Sistemas", "Banco de Dados", "T\u00E9cnicas de Programa\u00E7\u00E3o", "Psicologia", "Fundamentos de Estrutura de Dados", "Redes de Computadores", ""}));
		cboDisciplina.setFont(new Font("Arial", Font.PLAIN, 12));
		cboDisciplina.setBounds(113, 76, 255, 23);
		tabNotasFaltas.add(cboDisciplina);
		
		lblSemestreNf = new JLabel("Semestre");
		lblSemestreNf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSemestreNf.setBounds(391, 47, 66, 20);
		tabNotasFaltas.add(lblSemestreNf);
		
		cboSemestre = new JComboBox();
		cboSemestre.setModel(new DefaultComboBoxModel(new String[] {"", "2020-1"}));
		cboSemestre.setFont(new Font("Arial", Font.PLAIN, 12));
		cboSemestre.setBounds(467, 47, 94, 23);
		tabNotasFaltas.add(cboSemestre);
		
		lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNota.setBounds(391, 78, 29, 20);
		tabNotasFaltas.add(lblNota);
		
		lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFaltas.setBounds(573, 47, 40, 20);
		tabNotasFaltas.add(lblFaltas);
		
		ftfFaltas = new JFormattedTextField();
		ftfFaltas.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfFaltas.setBounds(623, 47, 58, 23);
		tabNotasFaltas.add(ftfFaltas);
		
		lblNomeNf = new JLabel("Nome");
		lblNomeNf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeNf.setBounds(241, 11, 46, 20);
		tabNotasFaltas.add(lblNomeNf);
		
		lblCursoNf = new JLabel("Curso");
		lblCursoNf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCursoNf.setBounds(37, 45, 46, 20);
		tabNotasFaltas.add(lblCursoNf);
		
		btnLimparDadosNota = new JButton("Limpar dados");
		btnLimparDadosNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpaDadosNota();
			}
		});
		btnLimparDadosNota.setIcon(new ImageIcon("F:\\Faculdade\\2\u00B0 SEMESTRE\\Prof Jadir\\Tecnicas de Programa\u00E7\u00E3o\\Trabalho\\Imagens dos Bot\u00F5es\\novo3.png"));
		btnLimparDadosNota.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimparDadosNota.setBounds(541, 72, 128, 29);
		tabNotasFaltas.add(btnLimparDadosNota);
		
		btnSalvarNota = new JButton("");
		btnSalvarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Nota nota = new Nota();
					nota.setDisciplina(cboDisciplina.getSelectedItem().toString());
					nota.setSemestre(cboSemestre.getSelectedItem().toString());
					nota.setNota(ftfNota.getText());
					nota.setFaltas(Integer.parseInt(ftfFaltas.getText()));
					nota.setRgm(ftfRgmConsultar.getText());
					NotaDAO dao = new NotaDAO();
					dao.Salvar(nota);
					lblVerificacaoNota.setText ("Salvo com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacaoNota.setText ("Erro ao Salvar: " + e1.getMessage());
				}
			}
		});
		btnSalvarNota.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/save.png")));
		btnSalvarNota.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvarNota.setBounds(37, 130, 80, 72);
		tabNotasFaltas.add(btnSalvarNota);
		
		btnConsultarNota = new JButton("");
		btnConsultarNota.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/notes.png")));
		btnConsultarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rgm = ftfRgmConsultar.getText();
				try {
					limpaDadosNota();
					List <Nota> listaNota = new ArrayList<Nota>();
					NotaDAO notaDao = new NotaDAO();
					listaNota = notaDao.ConsultarNotasRgm(rgm);
					for (Nota notas : listaNota) {
						txtLitagemNotas.append ("Disciplina: " + notas.getDisciplina() + "\n");
						txtLitagemNotas.append ("Nota: " + notas.getNota() + "\n");
						txtLitagemNotas.append ("Faltas: " + notas.getFaltas() + "\n\n");
					}
					NotaDAO dao2 = new NotaDAO();
					Nota notas = dao2.ConsultarNotas(rgm);
					cboSemestre.setSelectedItem(notas.getSemestre());
					AlunoDAO dao3 = new AlunoDAO();
					Aluno aluno = dao3.BuscarPorRgm(rgm);
					lblNomeAlunoNf.setText(aluno.getNome());
					lblCursoAlunoNf.setText(aluno.getCurso());
					lblVerificacaoNota.setText ("Consulta Realizada com Sucesso!!");
					ftfNota.setText ("--------");
					ftfFaltas.setText ("--------");
					cboDisciplina.setSelectedIndex(7);
				} catch (Exception e1) {
					lblVerificacaoNota.setText ("Erro ao Consultar. Erro: " + e1.getMessage());
				}
			}
		});
		btnConsultarNota.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultarNota.setBounds(258, 130, 80, 72);
		tabNotasFaltas.add(btnConsultarNota);
		
		btnExcluirNota = new JButton("");
		btnExcluirNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpaDadosNota();
					NotaDAO dao = new NotaDAO();
					String rgm = ftfRgmConsultar.getText();
					dao.Excluir(rgm);
					lblVerificacaoNota.setText("Excluido com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacaoNota.setText("Erro ao Excluir. Erro: " + e1.getMessage());
				}
			}
		});
		btnExcluirNota.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/Delete.png")));
		btnExcluirNota.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluirNota.setBounds(365, 130, 80, 72);
		tabNotasFaltas.add(btnExcluirNota);
		
		btnAlterarNota = new JButton("");
		btnAlterarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Nota nota = new Nota();
					nota.setRgm(ftfRgmConsultar.getText());
					nota.setDisciplina(cboDisciplina.getSelectedItem().toString());
					nota.setSemestre(cboSemestre.getSelectedItem().toString());
					nota.setNota(ftfNota.getText());
					nota.setFaltas(Integer.parseInt(ftfFaltas.getText()));
					NotaDAO notaDao = new NotaDAO();
					notaDao.Alterar(nota);
					lblVerificacaoNota.setText("Alterado com Sucesso!!");
				}catch(Exception e1) {
					lblVerificacaoNota.setText("Erro ao Alterar " + e1.getMessage());
				}
			}
		});
		btnAlterarNota.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/Atualizar.png")));
		btnAlterarNota.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAlterarNota.setBounds(148, 130, 80, 72);
		tabNotasFaltas.add(btnAlterarNota);
		
		btnSairNf = new JButton("");
		btnSairNf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSairNf.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/power-off.png")));
		btnSairNf.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSairNf.setBounds(595, 130, 80, 72);
		tabNotasFaltas.add(btnSairNf);
		
		ftfNota = new JFormattedTextField();
		ftfNota.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfNota.setBounds(430, 78, 80, 23);
		tabNotasFaltas.add(ftfNota);
		
		btnListarNotas = new JButton("");
		btnListarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpaDadosNota();
					List <Nota> lista = new ArrayList <Nota>();
					List <Aluno> lista2 = new ArrayList <Aluno>();
					NotaDAO notaDao = new NotaDAO();
					AlunoDAO alunoDao = new AlunoDAO();					
					lista2 = alunoDao.ListarTodos();
					for (Aluno aluno : lista2) {
						String rgm = aluno.getRgm();
						lista = notaDao.ConsultarNotasRgm(rgm);
						txtLitagemNotas.append ("RGM: " + aluno.getRgm() + "\n");
						txtLitagemNotas.append ("Nome: " + aluno.getNome() + "\n");
						txtLitagemNotas.append ("Curso: " + aluno.getCurso() + "\n");
						for (Nota nota : lista) {
							txtLitagemNotas.append ("Semestre: " + nota.getSemestre() + "\n");
							txtLitagemNotas.append ("Disciplina: " + nota.getDisciplina() + "\n");
							txtLitagemNotas.append ("Nota: " + nota.getNota() + "\n");
							txtLitagemNotas.append ("Faltas: " + nota.getFaltas() + "\n\n");
						}
						txtLitagemNotas.append ("-----------------------------------------------------------------------------------------------------------------\n\n");
					}
					lblVerificacaoNota.setText("Dados Listados com Sucesso!!");
				} catch (Exception e1) {
					lblVerificacaoNota.setText ("Erro ao Listar. Erro: " + e1.getMessage());
				}
			}
		});
		btnListarNotas.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/exemplo/view/images/procurar.png")));
		btnListarNotas.setFont(new Font("Arial", Font.PLAIN, 12));
		btnListarNotas.setBounds(476, 130, 80, 72);
		tabNotasFaltas.add(btnListarNotas);
		
		lblVerificacaoNota = new JLabel("...");
		lblVerificacaoNota.setForeground(new Color(250, 128, 114));
		lblVerificacaoNota.setFont(new Font("Arial", Font.BOLD, 14));
		lblVerificacaoNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerificacaoNota.setBounds(12, 368, 669, 16);
		tabNotasFaltas.add(lblVerificacaoNota);
		
		txtLitagemNotas = new TextArea();
		txtLitagemNotas.setBounds(37, 219, 632, 143);
		tabNotasFaltas.add(txtLitagemNotas);
		
		lblCursoAlunoNf = new JLabel("");
		lblCursoAlunoNf.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCursoAlunoNf.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCursoAlunoNf.setBounds(93, 44, 275, 23);
		tabNotasFaltas.add(lblCursoAlunoNf);
		
		panel = new JPanel();
		tabbedPane.addTab("Boletim", null, panel, null);
		panel.setLayout(null);
		
		lblRgmBoletim = new JLabel("RGM");
		lblRgmBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRgmBoletim.setBounds(34, 16, 46, 20);
		panel.add(lblRgmBoletim);
		
		lblNomeConsultarBoletim = new JLabel("Nome");
		lblNomeConsultarBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeConsultarBoletim.setBounds(34, 52, 46, 20);
		panel.add(lblNomeConsultarBoletim);
		
		lblNomeBoletim = new JLabel("");
		lblNomeBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeBoletim.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNomeBoletim.setBounds(90, 49, 317, 23);
		panel.add(lblNomeBoletim);
		
		lblCursoConsultarBoletim = new JLabel("Curso");
		lblCursoConsultarBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCursoConsultarBoletim.setBounds(33, 90, 46, 20);
		panel.add(lblCursoConsultarBoletim);
		
		lblCursoBoletim = new JLabel("");
		lblCursoBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCursoBoletim.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCursoBoletim.setBounds(89, 90, 415, 23);
		panel.add(lblCursoBoletim);
		
		lblSemestreConsultarBoletim = new JLabel("Semestre");
		lblSemestreConsultarBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSemestreConsultarBoletim.setBounds(450, 49, 69, 20);
		panel.add(lblSemestreConsultarBoletim);
		
		lblSemestreBoletim = new JLabel("");
		lblSemestreBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSemestreBoletim.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSemestreBoletim.setBounds(519, 49, 119, 23);
		panel.add(lblSemestreBoletim);
		
		ftfRgmBoletim = new JFormattedTextField();
		ftfRgmBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rgm = ftfRgmBoletim.getText();
				try {
					limpaDadosBoletim();
					AlunoDAO alunoDao = new AlunoDAO();
					NotaDAO notaDao = new NotaDAO();
					Aluno aluno = new Aluno();
					Nota nota = new Nota();
					aluno = alunoDao.BuscarPorRgm(rgm);
					nota = notaDao.ConsultarNotas(rgm);
					lblNomeBoletim.setText(aluno.getNome());
					lblCursoBoletim.setText(aluno.getCurso());
					lblSemestreBoletim.setText(nota.getSemestre());
				} catch (Exception e1) {					
					lblVerificacaoBoletim.setText ("Erro ao Consultar. Erro: " + e1.getMessage());
				}
			}
		});
		ftfRgmBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		ftfRgmBoletim.setBounds(90, 13, 111, 23);
		formatarCampo();
		panel.add(ftfRgmBoletim);
		
		btnConsultarBoletim = new JButton("Consultar");
		btnConsultarBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rgm = ftfRgmBoletim.getText();
				try {
					DefaultTableModel model = (DefaultTableModel) tabBoletim.getModel();
					model.setNumRows(0);
					limpaDadosBoletim();
					AlunoDAO alunoDao = new AlunoDAO();
					NotaDAO notaDao = new NotaDAO();
					Aluno aluno = new Aluno();
					Nota nota = new Nota();
					aluno = alunoDao.BuscarPorRgm (rgm);
					nota = notaDao.ConsultarNotas (rgm);
					lblNomeBoletim.setText (aluno.getNome());
					lblCursoBoletim.setText (aluno.getCurso());
					lblSemestreBoletim.setText (nota.getSemestre());
					List <Nota> listaNota =  new ArrayList <Nota>();
					listaNota = notaDao.ConsultarNotasRgm(rgm);
					for (Nota notas : listaNota) {
						model.addRow (new Object[] {
							notas.getDisciplina(),
							notas.getNota(),
							notas.getFaltas(),
						});
					}					
				} catch (Exception e1) {
					lblVerificacaoBoletim.setText ("Erro ao Listar. Erro: " + e1.getMessage());
				}
			}
		});
		btnConsultarBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultarBoletim.setBounds(213, 13, 104, 23);
		panel.add(btnConsultarBoletim);
		
		grid = new JScrollPane();
		grid.setToolTipText("");
		grid.setBounds(12, 155, 679, 210);
		panel.add(grid);
		
		tabBoletim = new JTable();
		tabBoletim.setToolTipText("");
		tabBoletim.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Disciplina", "Notas", "Faltas"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabBoletim.getColumnModel().getColumn(0).setResizable(false);
		tabBoletim.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabBoletim.getColumnModel().getColumn(1).setResizable(false);
		tabBoletim.getColumnModel().getColumn(1).setPreferredWidth(40);
		tabBoletim.getColumnModel().getColumn(2).setResizable(false);
		tabBoletim.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabBoletim.setFont(new Font("Arial", Font.PLAIN, 12));
		grid.setViewportView(tabBoletim);
		
		lblVerificacaoBoletim = new JLabel("...");
		lblVerificacaoBoletim.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerificacaoBoletim.setForeground(new Color(250, 128, 114));
		lblVerificacaoBoletim.setFont(new Font("Arial", Font.BOLD, 14));
		lblVerificacaoBoletim.setBounds(175, 126, 344, 16);
		panel.add(lblVerificacaoBoletim);
	}
}
