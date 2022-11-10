package br.com.mesttra.atv.main.model;

import br.com.mesttra.atv.main.helper.Helpers;

public class Gerente {

	private Cliente[] clientesPj = new ClientePj[50];
	private Cliente[] clientesPf = new ClientePf[50];
	
	public Gerente() {
		
	}

	public Cliente[] getclientesPj() {
		return clientesPj;
	}

	public Cliente[] getclientesPf() {
		return clientesPf;
	}
	
	public void cadastraClientePj(ClientePj c) {
        int posicao = 0;
        for (int i = 0; i < clientesPj.length; i++) {
            if (clientesPj[i] == null) {
                posicao = i;
                break;
            }
        }
        c.setTipoConta(TipoConta.PJ);
        this.clientesPj[posicao] = c;
    }
	
	public void cadastraClientePf(ClientePf c) {
        int posicao = 0;
        for (int i = 0; i < clientesPf.length; i++) {
            if (clientesPf[i] == null) {
                posicao = i;
                break;
            }
        }
        
        c.setTipoConta(TipoConta.PF);
        this.clientesPf[posicao] = c;
	}
	
	
	public void removerClientePj(int i) {
		this.clientesPj[i] = null;
	}
	
	public void removerClientePf(int i) {
		this.clientesPf[i] = null;
	}
	
	public void buscarClientePf(ClientePf c) {
		
		System.out.println("Nome: "+ c.getNome());
		System.out.println("CPF: "+c.getCpf());
		System.out.println("Idade: "+c.getIdade());
		System.out.println("Agencia: "+c.getAgencia());
		System.out.println("Cheque especial: "+c.getLimiteChequeEspecial());
		System.out.println("Numero da conta: "+c.getNumeroConta());
		System.out.println("Saldo: "+c.getSaldo());
		System.out.println("Telefone: "+c.getTelefone());
	}
	
	public void buscarClientePj(ClientePj p) {
		
		System.out.println("Agencia: "+p.getAgencia());
		System.out.println("Cnpj: "+p.getCnpj());
		System.out.println("Cheque especial: "+p.getLimiteChequeEspecial());
		System.out.println("Nome fantasia: "+p.getNomeFantasia());
		System.out.println("Numero da conta: "+p.getNumeroConta());
		System.out.println("Razão social: "+p.getRazaoSocial());
		System.out.println("Saldo: "+p.getSaldo());
		System.out.println("Telefone: "+p.getTelefone());
		System.out.print("Sócios: ");
		for (int c = 0; c < p.getNomeSocios().length; c++) {
			System.out.print(p.getNomeSocios()[c]+" | ");
		}
		
	}

	public void aumentarLimitePj(int i, Double val) {
		Double chequeEspecial = this.clientesPj[i].getLimiteChequeEspecial();
		chequeEspecial += val;
		this.clientesPj[i].setLimiteChequeEspecial(chequeEspecial);
	}
	
	public void aumentarLimitePf(int i, Double val) {
		Double chequeEspecial = this.clientesPf[i].getLimiteChequeEspecial();
		chequeEspecial += val;
		this.clientesPf[i].setLimiteChequeEspecial(chequeEspecial);
	}
	
	public void diminuirLimitePj(int i, Double val) {
		Double chequeEspecial = this.clientesPj[i].getLimiteChequeEspecial();
		chequeEspecial -= val;
		this.clientesPj[i].setLimiteChequeEspecial(chequeEspecial);
	}
	
	public void diminuirLimitePf(int i, Double val) {
		Double chequeEspecial = this.clientesPf[i].getLimiteChequeEspecial();
		chequeEspecial -= val;
		this.clientesPf[i].setLimiteChequeEspecial(chequeEspecial);
	}

	public void transferir(String origin, String destino, Double valTransf) {
		Cliente clinteOrigin = recuperarCliente(origin);
		Cliente clienteDestino = recuperarCliente(destino);
		
		if (clinteOrigin.getSaldo() >= valTransf ) {
			clinteOrigin.setSaldo(clinteOrigin.getSaldo() - valTransf);
			clienteDestino.setSaldo(clienteDestino.getSaldo() + valTransf);
			salvar(clinteOrigin, clienteDestino);
			System.out.println("Valor transferido com sucesso!");
		}
		else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	public Cliente recuperarCliente(String numeroConta) {
        for (int i = 0; i < 50; i++) {
            if (clientesPj[i] != null && clientesPj[i].getNumeroConta().equals(numeroConta)) {
                return (ClientePj) clientesPj[i];
            }
            if (clientesPf[i] != null && clientesPf[i].getNumeroConta().equals(numeroConta)) {
                return (ClientePf) clientesPf[i];
            }

        }
        return null;
    }
	
	private void salvar(Cliente origin, Cliente destino) {
		if (origin.getTipoConta().equals(TipoConta.PJ)) {
			int i = Helpers.varrerPorNumeroConta(this.clientesPj, origin.getNumeroConta());
			this.clientesPj[i] = origin;
		}
		else {
			int i = Helpers.varrerPorNumeroConta(this.clientesPf, origin.getNumeroConta());
			this.clientesPf[i] = origin;
		}
		
		if (destino.getTipoConta().equals(TipoConta.PJ)) {
			int i = Helpers.varrerPorNumeroConta(this.clientesPj, destino.getNumeroConta());
			this.clientesPj[i] = destino;
		}
		else {
			int i = Helpers.varrerPorNumeroConta(this.clientesPf, destino.getNumeroConta());
			this.clientesPf[i] = destino;
		}
		
	}
	
	public void addSaldo(String numeroConta, Double val) {
		Cliente cliente = recuperarCliente(numeroConta);
		cliente.setSaldo(cliente.getSaldo() + val);
		
		if (cliente.getTipoConta().equals(TipoConta.PF)) {
			int i = Helpers.varrerPorNumeroConta(this.clientesPf, numeroConta);
			this.clientesPf[i] = cliente;
			
		}
		else if (cliente.getTipoConta().equals(TipoConta.PJ)) {
			int i = Helpers.varrerPorNumeroConta(this.clientesPj, numeroConta);
			this.clientesPj[i] = cliente;
		}
	}

	public void editar(String numeroConta, int altTelefone) {
		
		Cliente c = recuperarCliente(numeroConta);
		c.setTelefone(altTelefone);
		
		if (c.getTipoConta().equals(TipoConta.PF)) {
			int i = Helpers.varrerPorNumeroConta(this.clientesPf, numeroConta);
			this.clientesPf[i] = c;
		}
		else if (c.getTipoConta().equals(TipoConta.PJ)) {
			int i = Helpers.varrerPorNumeroConta(this.clientesPj, numeroConta);
			this.clientesPj[i] = c;
		}
		
	}
	
}
