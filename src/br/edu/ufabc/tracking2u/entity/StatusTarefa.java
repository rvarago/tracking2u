package br.edu.ufabc.tracking2u.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rvarago
 */
public enum StatusTarefa {
	AGUARDANDO_ANALISE(1L, "Aguardando Análise"), EM_ANLISE(2L, "Em Análise"), AGUARDANDO_DESENVOLVIMENTO(3L,
			"Aguardando Desenvolvimento"), EM_DESENVOLVIMENTO(4L, "Em Desenvolvimento"), AGUARDANDO_TESTE(5L,
					"Aguardando Teste"), EM_TESTE(6L, "Em Teste"), AGUARDANDO_VALIDACAO(7L,
							"Aguardando Validação"), EM_APROVACAO(8L, "Em Aprovação"), APROVADA(9L,
									"Aprovada"), DESCARTADA(10L, "DESCARTADA");

	private Long codigo;
	private String nome;

	private static final Map<Long, StatusTarefa> items = new HashMap<>();

	static {
		for (StatusTarefa p : StatusTarefa.values()) {
			items.put(p.codigo, p);
		}
	}

	public static StatusTarefa valueOf(Long codigo) {
		if (!items.containsKey(codigo)) {
			throw new RuntimeException("Papel com código:  " + codigo + " não encontrado");
		}
		return items.get(codigo);
	}

	private StatusTarefa(Long codigo, String nome) {
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
