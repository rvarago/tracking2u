/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.tracking2u.telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import br.edu.ufabc.tracking2u.entity.Colaborador;
import br.edu.ufabc.tracking2u.entity.Papel;
import br.edu.ufabc.tracking2u.ui.UIHandler;
import br.edu.ufabc.tracking2u.ui.UIHandlerImpl;

/**
 *
 * @author tuliocarreira
 */
public class telaCadastroColaborador extends javax.swing.JFrame {
	UIHandler uihandler = new UIHandlerImpl();
	telaListaColaboradores telaAnterior;
	Colaborador colaborador;

	/**
	 * Creates new form telaCadastroColaborador
	 */
	public telaCadastroColaborador() {
		initComponents();
		carregaListaPapeis();
	}

	public telaCadastroColaborador(telaListaColaboradores telaAnterior) {
		this();
		this.telaAnterior = telaAnterior;

	}

	public telaCadastroColaborador(telaListaColaboradores telaLista, Colaborador c) {
		this();
		this.telaAnterior = telaLista;
		this.colaborador = c;
	}

	public void carregaListaPapeis() {
		DefaultListModel model = new DefaultListModel();
		Papel[] papeis = Papel.values();
		for (int i = 0; i < papeis.length; ++i) {
			model.addElement(papeis[i].getNome());
		}
		listPapeis.setModel(model);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonSalvarColaborador = new javax.swing.JButton();
		buttonCancelarColaborador = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		textNome = new javax.swing.JTextField();
		textSenha = new javax.swing.JPasswordField();
		jScrollPane1 = new javax.swing.JScrollPane();
		listPapeis = new javax.swing.JList<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		buttonSalvarColaborador.setText("Salvar");
		buttonSalvarColaborador.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSalvarColaboradorActionPerformed(evt);
			}
		});

		buttonCancelarColaborador.setText("Cancelar");
		buttonCancelarColaborador.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonCancelarColaboradorActionPerformed(evt);
			}
		});

		jLabel1.setText("Usuário");

		jLabel2.setText("Senha");

		jLabel3.setText("Permissões");

		listPapeis.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "item1", "item2", "item3" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(listPapeis);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(40, 40, 40)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(textSenha).addComponent(jLabel1)
								.addComponent(jLabel2).addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE,
										108, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 141,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel3))
						.addGap(61, 61, 61))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonSalvarColaborador)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(buttonCancelarColaborador).addGap(73, 73, 73)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
						.createSequentialGroup().addGap(28, 28, 28).addGroup(layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(28, 28, 28).addComponent(jLabel2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonSalvarColaborador).addComponent(buttonCancelarColaborador))
						.addGap(23, 23, 23)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void buttonSalvarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonSalvarColaboradorActionPerformed
		String login = textNome.getText();
		String senha = textSenha.getPassword().toString();
		List<String> papeisLista = listPapeis.getSelectedValuesList();

		if (login.isEmpty() || senha.isEmpty() || papeisLista.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
		} else {
			List<Papel> papeis = new ArrayList<>();
			for (String s : papeisLista) {
				switch (s) {
				case "Gerente de Projeto":
					papeis.add(Papel.GERENTE_PROJETO);
					break;
				case "Analista de Sistema":
					papeis.add(Papel.ANALISTA_SISTEMA);
					break;
				case "Desenvolvedor":
					papeis.add(Papel.DESENVOLVEDOR);
					break;
				case "Analista de Teste":
					papeis.add(Papel.ANALISTA_TESTE);
					break;
				case "Cliente":
					papeis.add(Papel.CLIENTE);
					break;
				}

				uihandler.createColaborador(login, senha, papeis);
                                
				this.dispose();
                                telaAnterior.carregaListaColaboradores();
				telaAnterior.setEnabled(true);
			}
		}
	}

	private void buttonCancelarColaboradorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCancelarColaboradorActionPerformed
		this.dispose();
		telaAnterior.setEnabled(true);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(telaCadastroColaborador.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(telaCadastroColaborador.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(telaCadastroColaborador.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(telaCadastroColaborador.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new telaCadastroColaborador().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buttonCancelarColaborador;
	private javax.swing.JButton buttonSalvarColaborador;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JList<String> listPapeis;
	private javax.swing.JTextField textNome;
	private javax.swing.JPasswordField textSenha;
	// End of variables declaration//GEN-END:variables
}
