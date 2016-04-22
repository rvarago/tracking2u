package br.edu.ufabc.tracking2u;

import br.edu.ufabc.tracking2u.telas.telaListaColaboradores;

public class App {

	public static void main(String[] args) {
           // telaLogin tela = new telaLogin();
			telaListaColaboradores tela = new telaListaColaboradores();
            tela.setVisible(true);
            tela.setLocationRelativeTo(null);  // *** this will center your app ***

        }
}