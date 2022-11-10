package br.com.mesttra.atv.main;

import br.com.mesttra.atv.main.model.ClientePf;
import br.com.mesttra.atv.main.model.ClientePj;

public class Test {

	public static ClientePf gerarClientePf() {
		return new ClientePf("pf", 545, 878456,  2550.0,  2000.0,
			 "548985",  "sadrff", 58);
	}
	
	public static ClientePj gerarClientePj() {
		String[] nomes = {"Joao", "caio", "luan"};
		return new ClientePj("pj", 545, 878456,  2550.0,  2000.0,
				 "4545",nomes , "2165", "asdvs");
	}
}
