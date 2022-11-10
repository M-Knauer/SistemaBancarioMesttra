package br.com.mesttra.atv.main.helper;

import br.com.mesttra.atv.main.model.Cliente;

public class Helpers {

	public static Integer varrerPorNumeroConta(Cliente[] obj, String numeroConta) {
		for (int index = 0; index < obj.length; index++) {
			if (obj[index].getNumeroConta().equals(numeroConta)) {
				return index;
			}
		}
		return null;
	}
}
