/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.tracking2u.telas;

import br.edu.ufabc.tracking2u.entity.Colaborador;
import br.edu.ufabc.tracking2u.persistence.PersistenceManager;
import br.edu.ufabc.tracking2u.persistence.PersistenceManagerFactory;
import br.edu.ufabc.tracking2u.ui.UIHandler;
import br.edu.ufabc.tracking2u.ui.UIHandlerImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tuliocarreira
 */
public class telaLogin extends javax.swing.JFrame {
	UIHandler uihandler = new UIHandlerImpl();
	private final PersistenceManager manager = PersistenceManagerFactory.buildPersistenceManager();
	Colaborador colaborador = new Colaborador();

	/**
	 * Creates new form telaLogin
	 */
	public telaLogin() {
		initComponents();
	}

	public boolean existeColaborador() {
		List<Colaborador> lista = (List<Colaborador>) carregaListaColaboradores();
		String text = textUsuario.getText();
		char[] senha = textSenha.getPassword();
		for (Colaborador c : lista) {
			if (c.getNome().equals(text) && Arrays.equals(c.getSenha(), senha)) {
				this.colaborador = c;
				return true;
			}

		}
		return false;
	}

	public List<? super Colaborador> carregaListaColaboradores() {
		List<? super Colaborador> listaColaboradores = new ArrayList<Colaborador>();
		try {
			listaColaboradores = this.manager.list(Colaborador.class);
		} catch (IOException ex) {
			Logger.getLogger(telaListaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(telaListaColaboradores.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaColaboradores;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">
	private void initComponents() {

		jDialog1 = new javax.swing.JDialog();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		labelNome = new javax.swing.JLabel();
		labelSenha = new javax.swing.JLabel();
		buttonLogin = new javax.swing.JButton();
		textSenha = new javax.swing.JPasswordField();
		buttonCadastrarColaboradores = new javax.swing.JButton();
		textUsuario = new javax.swing.JTextField();

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Tracking 2U");

		labelNome.setText("Usuário");

		labelSenha.setText("Senha");

		buttonLogin.setText("Login");
		buttonLogin.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonLoginActionPerformed(evt);
			}
		});

		buttonCadastrarColaboradores.setText("Cadastrar colaboradores");
		buttonCadastrarColaboradores.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonCadastrarColaboradoresActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(44, Short.MAX_VALUE)
								.addComponent(buttonCadastrarColaboradores)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(buttonLogin).addGap(18, 18, 18))
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
										.createSequentialGroup().addGap(25, 25, 25).addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(labelNome, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(labelSenha, javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup().addGap(6, 6, 6).addComponent(
																textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
																157, javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(layout.createSequentialGroup().addGap(31, 31, 31).addComponent(textSenha,
										javax.swing.GroupLayout.PREFERRED_SIZE, 157,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addComponent(labelNome)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelSenha).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(37, 37, 37)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonLogin).addComponent(buttonCadastrarColaboradores))
						.addGap(28, 28, 28)));

		pack();
	}

	private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {
		if (existeColaborador()) {
			telaPrincipal tela = new telaPrincipal(this.colaborador);
			tela.setVisible(true);
			tela.setLocationRelativeTo(null);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
		}
	}

	private void buttonCadastrarColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCadastrarColaboradoresActionPerformed
		telaListaColaboradores tela = new telaListaColaboradores(this);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
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
			java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new telaLogin().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buttonCadastrarColaboradores;
	private javax.swing.JButton buttonLogin;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JLabel labelNome;
	private javax.swing.JLabel labelSenha;
	private javax.swing.JPasswordField textSenha;
	private javax.swing.JTextField textUsuario;
	// End of variables declaration//GEN-END:variables
}
