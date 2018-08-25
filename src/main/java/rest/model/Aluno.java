package rest.model;

/**
 * @author DesenvolvedorJava
 *
 */
public class Aluno {
	private Integer id;
	private String nome;
	private String turma;
	private Double nota1;
	private Double nota2;

	/**
	 * @param nome
	 * @param turma
	 * @param nota1
	 * @param nota2
	 */

	public Aluno() {

	}

	public Aluno(Integer id, String nome, String turma, Double nota1, Double nota2) {
		super();
		this.id = id;
		this.nome = nome;
		this.turma = turma;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

}
