package br.com.mesttra.atv.main.model;

public class ClientePf extends Cliente {
	
	private String cpf;
	private String nome;
	private int idade;
	
	public ClientePf(String numeroConta, int agencia, int telefone, double saldo, double limiteChequeEspecial,
			String cpf, String nome, int idade) {
		super(numeroConta, agencia, telefone, saldo, limiteChequeEspecial);
		
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		
	}
	
	public ClientePf(String numeroConta, int agencia, int telefone, double saldo, double limiteChequeEspecial) {
		super(numeroConta, agencia, telefone, saldo, limiteChequeEspecial);
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
}
