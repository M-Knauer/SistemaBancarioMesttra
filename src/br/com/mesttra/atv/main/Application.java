package br.com.mesttra.atv.main;
import java.util.Scanner;

import br.com.mesttra.atv.main.helper.Helpers;
import br.com.mesttra.atv.main.model.Cliente;
import br.com.mesttra.atv.main.model.ClientePf;
import br.com.mesttra.atv.main.model.ClientePj;
import br.com.mesttra.atv.main.model.Gerente;
import br.com.mesttra.atv.main.model.TipoConta;
import br.com.mesttra.atv.main.service.Services;

public class Application {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gerente gerente = new Gerente();
		int index = 0;
		String tipoCliente;
		String numeroConta;
		gerente.cadastraClientePf(Test.gerarClientePf());
		gerente.cadastraClientePj(Test.gerarClientePj());
		
		while(index < 50) {
			System.out.println();
			Services.menu();
			System.out.print("Qual operação você deseja realizar? ");
			int opcao = sc.nextInt();
			System.out.println();
			
			switch(opcao) {
			
			case 1:
				do {
					System.out.print("O cliente que você deseja cadastrar é PF ou PJ? ");
					tipoCliente = sc.next();
				} while(!tipoCliente.equalsIgnoreCase("pj") && !tipoCliente.equalsIgnoreCase("pf"));
				
				
				System.out.print("Digite o numero da conta: ");
				numeroConta = sc.next();
				
				System.out.print("Digite o numero da agencia: ");
				int	agencia = sc.nextInt();
				
				System.out.print("Digite o numero do telefone: ");
				int telefone = sc.nextInt();
				
				System.out.print("Digite o saldo desse cliente: ");
				double saldo = sc.nextDouble();
				
				System.out.print("Digite o limite do cheque especial: ");
				double limiteCheque = sc.nextDouble();
				
				if(tipoCliente.equalsIgnoreCase("PJ")) {
					
					ClientePj customerPj = new ClientePj(numeroConta, agencia, telefone, saldo, limiteCheque);
					
					System.out.print("Digite o numero do CNPJ: ");
					customerPj.setCnpj(sc.next());
					
					System.out.print("Razão social: ");
					customerPj.setRazaoSocial(sc.next());
					
					sc.nextLine();
					
					System.out.print("Nome fantasia: ");
					customerPj.setNomeFantasia(sc.nextLine());
					
					String[] socios = new String[3];
					
					for (int socio = 0; socio < 3; socio++) {
						System.out.print("Nome do sócio: ");
						String nome = sc.nextLine();
						
						if (nome.equals(""))
							break;
						
						socios[socio] = nome;
						
						System.out.println("Se não tiver sócio, não digite nada, apenas prossiga");
					}
					
					gerente.cadastraClientePj(customerPj);
					
				} else if(tipoCliente.equalsIgnoreCase("PF")) {
					
					ClientePf clientePf = new ClientePf(numeroConta, agencia, telefone, saldo, limiteCheque);
					
					System.out.print("CPF: ");
					clientePf.setCpf(sc.next());
					
					sc.nextLine();
					
					System.out.print("Nome: ");
					clientePf.setNome(sc.nextLine());
					
					System.out.print("Idade: ");
					clientePf.setIdade(sc.nextInt());
				
					gerente.cadastraClientePf(clientePf);
				}
				index++;
				break;
				
			case 2:
				System.out.print("Remover cliente PJ ou PF? ");
				tipoCliente = sc.next();
				
				System.out.print("Numero da conta: ");
				numeroConta = sc.next();
				
				try {
					if (tipoCliente.equalsIgnoreCase("PJ")) {
						int i = Helpers.varrerPorNumeroConta(gerente.getclientesPj(), numeroConta);
						gerente.removerClientePj(i);
						System.out.println("Cliente removido com sucesso!");
						break;
					}
					else if (tipoCliente.equalsIgnoreCase("PF")) {
						int i = Helpers.varrerPorNumeroConta(gerente.getclientesPf(), numeroConta);
						gerente.removerClientePf(i);
						System.out.println("Cliente removido com sucesso!");
						break;
					}
					
				}
				catch (NullPointerException e) {
					System.out.println("Conta não existe!");
					break;
				}
				break;
				
			case 3:
				
				System.out.print("Numero da conta: ");
				numeroConta = sc.next();
				
				try {
					Cliente c = gerente.recuperarCliente(numeroConta);
					if (c.getTipoConta().equals(TipoConta.PJ)) {
						gerente.buscarClientePj((ClientePj) c);
						break;
					}
					else {
						gerente.buscarClientePf((ClientePf) c);
						break;
					}
				}
				catch (NullPointerException e) {
					System.out.println("Cliente não encontrado!");
					break;
				}
			case 4:
				System.out.print("Aumentar ou diminuir? [1/2]: ");
				int op = sc.nextInt();
				
				System.out.print("Buscar cliente PJ ou PF? ");
				tipoCliente = sc.next();
				
				System.out.print("Numero da conta: ");
				numeroConta = sc.next();
				
				System.out.print("Valor à ser alterado: ");
				Double val = sc.nextDouble();
				
				if (op == 1) {
					try {
						if (tipoCliente.equalsIgnoreCase("PJ")) {
							int i = Helpers.varrerPorNumeroConta(gerente.getclientesPj(), numeroConta);
							gerente.aumentarLimitePj(i, val);
							System.out.println("Limite aumentado com sucesso!");
							break;
						}
						else if (tipoCliente.equalsIgnoreCase("pf")) {
							int i = Helpers.varrerPorNumeroConta(gerente.getclientesPf(), numeroConta);
							gerente.aumentarLimitePf(i, val);
							System.out.println("Limite aumentado com sucesso!");
							break;
						}
						
					}
					catch (NullPointerException e) {
						System.out.println("Conta não existe!");
						break;
					}
				}
				else if (op == 2) {
					try {
						if (tipoCliente.equalsIgnoreCase("PJ")) {
							int i = Helpers.varrerPorNumeroConta(gerente.getclientesPj(), numeroConta);
							gerente.diminuirLimitePj(i, val);
							System.out.println("Limite diminuido com sucesso!");
							break;
						}
						else if (tipoCliente.equalsIgnoreCase("pf")) {
							int i = Helpers.varrerPorNumeroConta(gerente.getclientesPf(), numeroConta);
							gerente.diminuirLimitePf(i, val);
							System.out.println("Limite diminuido com sucesso!");
							break;
						}
						
					}
					catch (NullPointerException e) {
						System.out.println("Conta não existe!");
						break;
					}
				}
				break;
			case 5:
				System.out.print("Numero da conta de origem: ");
				String numeroContaOrigem = sc.next();
				
				System.out.print("Numero da conta de destino: ");
				numeroConta = sc.next();
				
				System.out.print("Valor à ser transferido: ");
				Double valTransf = sc.nextDouble();
				
				gerente.transferir(numeroContaOrigem, numeroConta, valTransf);
				
				break;
			case 6:
				System.out.print("Numero da conta: ");
				numeroConta = sc.next();
				
				System.out.print("Valor: ");
				Double valAdd = sc.nextDouble();
				
				
				
			}
				
			System.out.println();
		}
		sc.close();
		
	}
	
}
