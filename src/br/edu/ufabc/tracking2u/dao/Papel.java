package br.edu.ufabc.tracking2u.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rvarago
 */
public enum Papel {
	GERENTE_PROJETO(1L, "Gerente de Projeto"), ANALISTA_SISTEMA(2L, "Analista de Sistema"), DESENVOLVEDOR(3L,
			"Desenvolvedor"), ANALISTA_TESTE(4L, "Analista de Teste"), CLIENTE(5L, "Cliente");

	private Long codigo;
	private String nome;

	private static final Map<Long, Papel> items = new HashMap<>();

	static {
		for (Papel p : Papel.values()) {
			items.put(p.codigo, p);
		}
	}

	public static Papel valueOf(Long codigo) {
		if (!items.containsKey(codigo)) {
			throw new RuntimeException("Papel com código:  " + codigo + " não encontrado");
		}
		return items.get(codigo);
	}

	private Papel(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}
}
