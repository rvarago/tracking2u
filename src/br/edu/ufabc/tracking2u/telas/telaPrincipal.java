/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.tracking2u.telas;

import br.edu.ufabc.tracking2u.entity.Colaborador;
import br.edu.ufabc.tracking2u.entity.Papel;
import br.edu.ufabc.tracking2u.entity.StatusTarefa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.edu.ufabc.tracking2u.entity.Tarefa;
import br.edu.ufabc.tracking2u.persistence.PersistenceManager;
import br.edu.ufabc.tracking2u.persistence.PersistenceManagerFactory;

/**
 *
 * @author tuliocarreira
 */
public class telaPrincipal extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private final PersistenceManager manager = PersistenceManagerFactory.buildPersistenceManager();
	private telaLogin telaAnterior;
	Colaborador colaborador;
	Tarefa tarefa;

	/**
	 * Creates new form telaPrincipal
	 */
	public telaPrincipal() {
		this.initComponents();
	}

	public telaPrincipal(Colaborador c) {
		this.initComponents();
		this.carregaListaTarefas(c);
		this.colaborador = c;
		if (c.getPapel() != Papel.GERENTE_PROJETO) {
			buttonCriar.setVisible(false);
			buttonEditar.setVisible(false);
			buttonExcluir.setVisible(false);
		}
	}

	public void carregaListaTarefas(Colaborador colaborador) {
		List<? super Tarefa> listaTarefas = new ArrayList<Tarefa>();
		try {
			listaTarefas = this.manager.list(Tarefa.class);
		} catch (IOException ex) {
			Logger.getLogger(telaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(telaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		}
		DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Descrição");
		modelo.addColumn("Status");
		modelo.addColumn("Data de Previsão");

		if (listaTarefas.isEmpty()) {
			modelo.addRow(new String[] { "Sem dados", null, null, null, null });
		}
		for (int i = 0; i < listaTarefas.size(); i++) {
			Tarefa t = (Tarefa) listaTarefas.get(i);
			if (((t.getStatus().equals(StatusTarefa.AGUARDANDO_ANALISE) || t.getStatus().equals(StatusTarefa.EM_ANALISE)
					|| t.getStatus().equals(StatusTarefa.AGUARDANDO_DESENVOLVIMENTO))
					&& (colaborador.getPapel().equals(Papel.ANALISTA_SISTEMA)))

					|| ((t.getStatus().equals(StatusTarefa.AGUARDANDO_DESENVOLVIMENTO)
							|| t.getStatus().equals(StatusTarefa.AGUARDANDO_TESTE)
							|| t.getStatus().equals(StatusTarefa.EM_DESENVOLVIMENTO))
							&& (colaborador.getPapel().equals(Papel.DESENVOLVEDOR)))

					|| ((t.getStatus().equals(StatusTarefa.EM_TESTE)
							|| t.getStatus().equals(StatusTarefa.AGUARDANDO_VALIDACAO))
							&& (colaborador.getPapel().equals(Papel.ANALISTA_TESTE)))

					|| (colaborador.getPapel().equals(Papel.GERENTE_PROJETO)
							|| colaborador.getPapel().equals(Papel.CLIENTE))

			) {

				modelo.addRow(new String[] { t.getId() + "", t.getNome(), t.getDescricao(), t.getStatus() + "",
						t.getDataPrometida() + "" });
			}

		}
		this.tabelaTarefas.setModel(modelo);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jMenuItem1 = new javax.swing.JMenuItem();
		jScrollPane1 = new javax.swing.JScrollPane();
		tabelaTarefas = new javax.swing.JTable();
		buttonCriar = new javax.swing.JButton();
		buttonSair = new javax.swing.JButton();
		buttonEditar = new javax.swing.JButton();
		buttonExcluir = new javax.swing.JButton();
		buttonStatus = new javax.swing.JButton();
		buttonAlterarUsuario = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		menuTarefas = new javax.swing.JMenu();
		menuTarefaListar = new javax.swing.JMenuItem();
		menuTarefaCadastrar = new javax.swing.JMenuItem();
		menuColaboradores = new javax.swing.JMenu();
		menuListarColaboradores = new javax.swing.JMenuItem();
		menuCadastrarColaboradores = new javax.swing.JMenuItem();

		jMenuItem1.setText("jMenuItem1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Tracking 2U");

		tabelaTarefas
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tabelaTarefas);

		buttonCriar.setText("Criar");
		buttonCriar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonCriarActionPerformed(evt);
			}
		});

		buttonSair.setText("Sair");
		buttonSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSairActionPerformed(evt);
			}
		});

		buttonEditar.setText("Editar");
		buttonEditar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonEditarActionPerformed(evt);
			}
		});

		buttonExcluir.setText("Excluir");
		buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonExcluirActionPerformed(evt);
			}
		});

		buttonStatus.setText("Alterar Status");
		buttonStatus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonStatusActionPerformed(evt);
			}
		});

		buttonAlterarUsuario.setText("Alterar Usuario");
		buttonAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonAlterarUsuarioActionPerformed(evt);
			}
		});

		menuTarefas.setText("Tarefas");

		menuTarefaListar.setText("Listar");
		menuTarefaListar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuTarefaListarActionPerformed(evt);
			}
		});
		menuTarefas.add(menuTarefaListar);

		menuTarefaCadastrar.setText("Cadastrar");
		menuTarefaCadastrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuTarefaCadastrarActionPerformed(evt);
			}
		});
		menuTarefas.add(menuTarefaCadastrar);

		jMenuBar1.add(menuTarefas);

		menuColaboradores.setText("Colaboradores");
		menuColaboradores.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuColaboradoresActionPerformed(evt);
			}
		});

		menuListarColaboradores.setText("Listar");
		menuListarColaboradores.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuListarColaboradoresActionPerformed(evt);
			}
		});
		menuColaboradores.add(menuListarColaboradores);

		menuCadastrarColaboradores.setText("Cadastrar");
		menuCadastrarColaboradores.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuCadastrarColaboradoresActionPerformed(evt);
			}
		});
		menuColaboradores.add(menuCadastrarColaboradores);

		jMenuBar1.add(menuColaboradores);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(
												layout.createSequentialGroup().addComponent(buttonStatus)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(buttonCriar)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(buttonEditar)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(buttonExcluir)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(buttonAlterarUsuario).addGap(18, 18, 18)
														.addComponent(buttonSair))
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(21, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(16, 16, 16)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(buttonCriar).addComponent(buttonSair).addComponent(buttonEditar)
						.addComponent(buttonExcluir).addComponent(buttonAlterarUsuario).addComponent(buttonStatus))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void buttonStatusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonStatusActionPerformed
		// TODO add your handling code here:
		try {
			int linha = this.tabelaTarefas.getSelectedRow() + 1;
			Tarefa tarefa = this.manager.find(Long.valueOf(linha), Tarefa.class);
			this.setEnabled(false);
			telaAlteraStatus tela = new telaAlteraStatus(this, this.colaborador, tarefa);
			tela.setVisible(true);
			tela.setLocationRelativeTo(null);
			this.carregaListaTarefas(this.colaborador);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Selecione uma tarefa");
		} // GEN-LAST:event_buttonEditarActionPerformed

	}// GEN-LAST:event_buttonStatusActionPerformed

	private void buttonAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAlterarUsuarioActionPerformed
		// TODO add your handling code here:
		this.dispose();
		telaLogin tela = new telaLogin();
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
	}// GEN-LAST:event_buttonAlterarUsuarioActionPerformed

	private void menuColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuColaboradoresActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_menuColaboradoresActionPerformed

	private void menuCadastrarColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuCadastrarColaboradoresActionPerformed
		// TODO add your handling code here:
		telaCadastroColaborador tela = new telaCadastroColaborador(this);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
		this.setEnabled(false);
	}// GEN-LAST:event_menuCadastrarColaboradoresActionPerformed

	private void menuListarColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuListarColaboradoresActionPerformed
		// TODO add your handling code here:
		telaListaColaboradores tela = new telaListaColaboradores(this);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
		this.setEnabled(false);

	}// GEN-LAST:event_menuListarColaboradoresActionPerformed

	private void menuTarefaListarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuTarefaListarActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_menuTarefaListarActionPerformed

	private void menuTarefaCadastrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuTarefaCadastrarActionPerformed
		// TODO add your handling code here:
		this.setEnabled(false);
		telaCadastroTarefa tela = new telaCadastroTarefa(this, this.colaborador);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);

	}// GEN-LAST:event_menuTarefaCadastrarActionPerformed

	private void buttonCriarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonCriarActionPerformed
		// TODO add your handling code here:
		this.setEnabled(false);
		telaCadastroTarefa tela = new telaCadastroTarefa(this, this.colaborador);
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);
	}// GEN-LAST:event_buttonCriarActionPerformed

	private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonSairActionPerformed
		// TODO add your handling code here:
		System.exit(0);
	}// GEN-LAST:event_buttonSairActionPerformed

	private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonEditarActionPerformed
		// TODO add your handling code here:
		try {
			int linha = this.tabelaTarefas.getSelectedRow() + 1;
			Tarefa tarefa = this.manager.find(Long.valueOf(linha), Tarefa.class);
			this.setEnabled(false);
			telaCadastroTarefa tela = new telaCadastroTarefa(this, this.colaborador, tarefa);
			tela.setVisible(true);
			tela.setLocationRelativeTo(null);
			this.carregaListaTarefas(this.colaborador);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Selecione uma tarefa");
		} // GEN-LAST:event_buttonEditarActionPerformed
	}

	private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonExcluirActionPerformed
		// TODO add your handling code here:
		try {
			int linha = this.tabelaTarefas.getSelectedRow() + 1;
			Tarefa c = this.manager.find(Long.valueOf(linha), Tarefa.class);
			this.manager.delete(c);
			JOptionPane.showMessageDialog(this, "Tarefa excluida com sucesso!");
			this.carregaListaTarefas(this.colaborador);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Selecione uma tarefa");
		} // GEN-LAST:event_buttonExcluirActionPerformed
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
			java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new telaPrincipal().setVisible(true);

			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buttonAlterarUsuario;
	private javax.swing.JButton buttonCriar;
	private javax.swing.JButton buttonEditar;
	private javax.swing.JButton buttonExcluir;
	private javax.swing.JButton buttonSair;
	private javax.swing.JButton buttonStatus;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JMenuItem menuCadastrarColaboradores;
	private javax.swing.JMenu menuColaboradores;
	private javax.swing.JMenuItem menuListarColaboradores;
	private javax.swing.JMenuItem menuTarefaCadastrar;
	private javax.swing.JMenuItem menuTarefaListar;
	private javax.swing.JMenu menuTarefas;
	private javax.swing.JTable tabelaTarefas;
	// End of variables declaration//GEN-END:variables
}
