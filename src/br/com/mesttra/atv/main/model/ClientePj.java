package br.com.mesttra.atv.main.model;

public class ClientePj extends Cliente {
	
	private String cnpj;
	private String[] nomeSocios = new String[3];
	private String razaoSocial;
	private String nomeFantasia;
	
	public ClientePj(String numeroConta, int agencia, int telefone, double saldo, double limiteChequeEspecial,
			String cnpj, String[] nomeSocios, String razaoSocial, String nomeFantasia) {
		super(numeroConta, agencia, telefone, saldo, limiteChequeEspecial);
		
		this.cnpj = cnpj;
		this.nomeSocios = nomeSocios;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}
	
	public ClientePj(String numeroConta, int agencia, int telefone, double saldo, double limiteChequeEspecial) {
		super(numeroConta, agencia, telefone, saldo, limiteChequeEspecial);
	}


	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String[] getNomeSocios() {
		return nomeSocios;
	}

	public void setNomeSocios(String[] nomeSocios) {
		this.nomeSocios = nomeSocios;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
}
