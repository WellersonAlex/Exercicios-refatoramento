package main.java.refatoramento.ead;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FachadaEscalonador {

	private StatusEscalonador st = new StatusEscalonador();
	private TipoEscalonador tipoEscalonador;
	private int quantum = 3;
	private int tick = 0;
	private int valorAternar = 1;
	private String rodando;

	private Queue<String> filaAternado = new LinkedList<>();

	private List<String> processosFinalizar = new ArrayList<String>();

	public FachadaEscalonador(TipoEscalonador roundrobin) {
		this.tipoEscalonador = roundrobin;
	}

	public String getStatus() {
		if (rodando == null && filaAternado.size() == 0) {
			return st.statusInicial(tipoEscalonador, quantum, tick);
		}
		if (rodando == null && filaAternado.size() > 0) {
			return st.statusFila(tipoEscalonador, filaAternado, quantum, tick);
		}
		if (tick > 0 && filaAternado.size() == 0) {
			return st.statusRodando(tipoEscalonador, rodando, quantum, tick);
		}
		return st.statusProcessoRodandoFila(tipoEscalonador, rodando, filaAternado, quantum, tick);
	}

	public void tick() {
		tick++;

		if (rodando == null) {
			rodando = filaAternado.poll();
		}

		if (processosFinalizar.size() > 0) {

			if (filaAternado.size() == 0) {
				rodando = null;
			}
			if (filaAternado.size() >= 1) {
				for (int i = 0; i < filaAternado.size(); i++) {
					if (filaAternado.contains(processosFinalizar.get(0))) {
						filaAternado.poll();
					}
				}
			}
			if (filaAternado.size() > 0) {
				rodando = filaAternado.poll();
				valorAternar = tick;
			}
			processosFinalizar.clear();
		}

		if (rodando != null && filaAternado.size() > 0) {
			if ((valorAternar + quantum) == tick) {
				valorAternar = tick;
				filaAternado.add(rodando);
				rodando = filaAternado.poll();
			}
		}

	}

	public void adicionarProcesso(String nomeProcesso) {
		
		
			filaAternado.add(nomeProcesso);
			if (tick > 0) {
				valorAternar = tick + 1;
			}
	}

	public void finalizarProcesso(String nomeProcesso) {

		if (rodando == nomeProcesso) {
			processosFinalizar.add(nomeProcesso);
		} else {
			if (!filaAternado.isEmpty()) {
				for (int i = 0; i < filaAternado.size(); i++) {
					if (filaAternado.contains(nomeProcesso) && processosFinalizar.size() == 0) {
						processosFinalizar.add(nomeProcesso);
					} else {
						if (!processosFinalizar.contains(nomeProcesso)) {
							processosFinalizar.add(nomeProcesso);
						}
					}
				}
			}

		}

	}

}
