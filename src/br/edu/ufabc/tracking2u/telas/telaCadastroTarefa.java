/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.tracking2u.telas;

import br.edu.ufabc.tracking2u.entity.Colaborador;
import javax.swing.JOptionPane;

import br.edu.ufabc.tracking2u.entity.Tarefa;
import br.edu.ufabc.tracking2u.ui.UIHandler;
import br.edu.ufabc.tracking2u.ui.UIHandlerImpl;

/**
 *
 * @author tuliocarreira
 */
public class telaCadastroTarefa extends javax.swing.JFrame {

	/**
	 * Creates new form telaCadastroTarefa
	 */
	private telaPrincipal telaAnterior;
	private UIHandler uihandler = new UIHandlerImpl();
	Tarefa tarefa;
	Colaborador colaborador;

	private telaCadastroTarefa() {
		this.initComponents();
	}

	public telaCadastroTarefa(telaPrincipal telaAnterior) {
		this();
		this.telaAnterior = telaAnterior;
	}

	public telaCadastroTarefa(telaPrincipal telaAnterior, Colaborador colaborador) {
		this();
		this.telaAnterior = telaAnterior;
		this.colaborador = colaborador;
	}

	/**
	 * Creates new form telaCadastroColaborador
	 */

	public telaCadastroTarefa(telaPrincipal telaAnterior, Tarefa t) {
		this();
		this.telaAnterior = telaAnterior;
		this.tarefa = t;
		textNome.setText(t.getNome() + "");
		textDesc.setText(t.getDescricao() + "");
		textDataPrevisao.setText(t.getDataPrometida().toString());

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonCancelarCadastro = new javax.swing.JButton();
		buttonSalvarCadastro = new javax.swing.JButton();
		labelNome = new javax.swing.JLabel();
		labelDesc = new javax.swing.JLabel();
		labelDataPrevisao = new javax.swing.JLabel();
		textNome = new javax.swing.JTextField();
		scrollTextDesc = new javax.swing.JScrollPane();
		textDesc = new javax.swing.JTextArea();
		textDataPrevisao = new javax.swing.JTextField();
		buttonPendencias = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Cadastro de Tarefa");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		buttonCancelarCadastro.setText("Cancelar");
		buttonCancelarCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				buttonCancelarCadastroMouseClicked(evt);
			}
		});
		buttonCancelarCadastro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonCancelarCadastroActionPerformed(evt);
			}
		});

		buttonSalvarCadastro.setText("Salvar");
		buttonSalvarCadastro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSalvarCadastroActionPerformed(evt);
			}
		});

		labelNome.setText("Nome");

		labelDesc.setText("Descrição");

		labelDataPrevisao.setText("Data de Previsão de Término");

		textNome.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textNomeActionPerformed(evt);
			}
		});

		textDesc.setColumns(20);
		textDesc.setRows(5);
		scrollTextDesc.setViewportView(textDesc);

		textDataPrevisao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textDataPrevisaoActionPerformed(evt);
			}
		});

		buttonPendencias.setText("Pendências Associadas");
		buttonPendencias.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonPendenciasActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addGap(23, 23, 23)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(0, 2, Short.MAX_VALUE)
														.addComponent(buttonPendencias)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(buttonSalvarCadastro)
														.addComponent(buttonCancelarCadastro)
														.addContainerGap(
																12, Short.MAX_VALUE))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup().addComponent(scrollTextDesc)
																.addGap(25, 25, 25))
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE,
																144, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(labelNome)).addContainerGap(
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(labelDataPrevisao).addComponent(labelDesc)
														.addGroup(layout.createSequentialGroup().addGap(6, 6, 6)
																.addComponent(textDataPrevisao,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 151,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGap(0, 0, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(labelNome).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(labelDesc).addGap(18, 18, 18)
						.addComponent(scrollTextDesc, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(37, 37, 37).addComponent(labelDataPrevisao)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textDataPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(54, 54, 54)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buttonCancelarCadastro).addComponent(buttonSalvarCadastro)
								.addComponent(buttonPendencias))
						.addGap(23, 23, 23)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void comboboxStatusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_comboboxStatusActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_comboboxStatusActionPerformed

	private void buttonPendenciasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		this.setEnabled(false);
		new telaListaPendencias().setVisible(true);

	}// GEN-LAST:event_jButton1ActionPerformed

	private void buttonCancelarCadastroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCancelarCadastroActionPerformed
		this.dispose();
		this.telaAnterior.setEnabled(true);

	}// GEN-LAST:event_buttonCancelarCadastroActionPerformed

	private void buttonSalvarCadastroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonSalvarCadastroActionPerformed
		// TODO add your handling code here:
		String nome = this.textNome.getText();
		String desc = this.textDesc.getText();
		Long data;

		try {
			data = Long.valueOf(this.textDataPrevisao.getText());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Data inválida");
			return;
		}
		if (data.toString().length() != 8) {
			JOptionPane.showMessageDialog(this, "Informe uma data no formato DDMMYYYY");
			return;
		}

		if (nome.isEmpty() || desc.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
			return;
		}

		// como passar o colaborador atual?
		this.uihandler.manageTarefa(nome, desc, data, this.colaborador, this.tarefa);
		this.dispose();
		telaAnterior.carregaListaTarefas();
		telaAnterior.setEnabled(true);

	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosed
		// tratamento para operações de fechamento da janela
		this.telaAnterior.setEnabled(true);
	}// GEN-LAST:event_formWindowClosed

	private void buttonCancelarCadastroMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_buttonCancelarCadastroMouseClicked
		// TODO add your handling code here:
	}// GEN-LAST:event_buttonCancelarCadastroMouseClicked

	private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textNomeActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_textNomeActionPerformed

	private void textDataPrevisaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textDataPrevisaoActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_textDataPrevisaoActionPerformed

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jComboBox1ActionPerformed

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
			java.util.logging.Logger.getLogger(telaCadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(telaCadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(telaCadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(telaCadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				telaCadastroTarefa tela = new telaCadastroTarefa();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null); // *** this will center your
													// app ***

			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buttonCancelarCadastro;
	private javax.swing.JButton buttonPendencias;
	private javax.swing.JButton buttonSalvarCadastro;
	private javax.swing.JLabel labelDataPrevisao;
	private javax.swing.JLabel labelDesc;
	private javax.swing.JLabel labelNome;
	private javax.swing.JScrollPane scrollTextDesc;
	private javax.swing.JTextField textDataPrevisao;
	private javax.swing.JTextArea textDesc;
	private javax.swing.JTextField textNome;
	// End of variables declaration//GEN-END:variables
}
