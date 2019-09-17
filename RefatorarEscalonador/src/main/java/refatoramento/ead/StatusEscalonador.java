package main.java.refatoramento.ead;

import java.util.List;
import java.util.Queue;

public class StatusEscalonador {

	public String statusInicial(TipoEscalonador tipo, int quantum, int tick) {
		return "Escalonador " + tipo + ";Processos: {};Quantum: " + quantum + ";Tick: " + tick;
	}

	public String statusFila(TipoEscalonador tipo, Queue<String> fila, int quantum, int tick) {
		return "Escalonador " + tipo + ";Processos: {Fila: " + fila + "};Quantum: " + quantum + ";Tick: " + tick;
	}

	public String statusRodando(TipoEscalonador tipo, String rodando, int quantum, int tick) {
		return "Escalonador " + tipo + ";Processos: {Rodando: " + rodando + "};Quantum: " + quantum + ";Tick: " + tick;
	}

	public String statusProcessoRodandoFila(TipoEscalonador tipo, String rodando, Queue<String> processos, int quantum,
			int tick) {
		return "Escalonador " + tipo + ";Processos: {Rodando: " + rodando + ", Fila: " + processos + "};Quantum: "
				+ quantum + ";Tick: " + tick;
	}

	public String statusRodandoFilaBloqueados(TipoEscalonador tipo, String rodando, Queue<String> processos,
			List<String> bloqueados, int quantum, int tick) {
		return "Escalonador " + tipo + ";Processos: {Rodando: " + rodando + ", Fila: " + processos + ", Bloqueados: "
				+ bloqueados + "};Quantum: " + quantum + ";Tick: " + tick;
	}

	public String statusRodandoBloqueados(TipoEscalonador tipo, String rodando, List<String> bloqueados, int quantum,
			int tick) {
		return "Escalonador " + tipo + ";Processos: {Rodando: " + rodando + ", Bloqueados: " + bloqueados
				+ "};Quantum: " + quantum + ";Tick: " + tick;
	}

	public String statusBloqueados(TipoEscalonador tipo, List<String> bloqueados, int quantum, int tick) {
		return "Escalonador " + tipo + ";Processos: {Bloqueados: " + bloqueados + "};Quantum: " + quantum + ";Tick: "
				+ tick;
	}

}
