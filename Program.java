package curso_programacao;

import java.util.HashMap;

public class Program {

	/**
	 * Implementação do algoritmo LRU (Last Recently Used). Esse código simula um
	 * cache com capacidade limitada de 4 posições, substituindo o item menos
	 * recentemente usado quando o cache está cheio.
	 */

	// Classe interna que representa cada elemento (nó) da lista duplamente ligada
	private class Node {
		String key;
		Node prev;
		Node next;

		Node(String key) {
			this.key = key;
		}
	}

	private final int capacidade;
	private final HashMap<String, Node> mapa;
	private final Node head, tail; // nós sentinelas

	public Program(int capacidade) {
		this.capacidade = capacidade;
		this.mapa = new HashMap<>();
		// Inicializa nós sentinelas (inicio e fim da lista)
		head = new Node(null);
		tail = new Node(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Insere um novo elemento no cache ou atualiza a posição de um existente.
	 */
	public void put(String key) {
		if (mapa.containsKey(key)) {
			// Se já existe, apenas movemos para o início (mais recente)
			Node node = mapa.get(key);
			moverParaFrente(node);
		} else {
			// Se for novo, adiciona e verifica se precisa remover o LRU
			Node node = new Node(key);
			mapa.put(key, node);
			adicionarNaFrente(node);

			if (mapa.size() > capacidade) {
				// Remove o menos recentemente usado (último da lista)
				Node lru = tail.prev;
				remover(lru);
				mapa.remove(lru.key);
			}
		}
	}

	/**
	 * Move um nó existente para a frente da lista (mais recentemente usado).
	 */
	private void moverParaFrente(Node node) {
		remover(node);
		adicionarNaFrente(node);
	}

	/**
	 * Adiciona um novo nó logo após o head (posição mais recente).
	 */
	private void adicionarNaFrente(Node node) {
		Node primeiro = head.next;
		head.next = node;
		node.prev = head;
		node.next = primeiro;
		primeiro.prev = node;
	}

	/**
	 * Remove um nó da lista.
	 */
	private void remover(Node node) {
		Node anterior = node.prev;
		Node proximo = node.next;
		anterior.next = proximo;
		proximo.prev = anterior;
	}

	/**
	 * Exibe o estado atual do cache, do mais recente ao menos recente.
	 */
	public void exibirEstado(String rotulo) {
		System.out.print(rotulo + ": ");
		Node atual = head.next;
		while (atual != tail) {
			System.out.print(atual.key + " ");
			atual = atual.next;
		}
		System.out.println();
	}

	/**
	 * Método principal que executa os testes conforme o exemplo fornecido.
	 */
	public static void main(String[] args) {
		Program cache = new Program(4);

		// Alocações iniciais
		String[] iniciais = { "A", "B", "C", "D" };
		for (String letra : iniciais) {
			cache.put(letra);
		}

		cache.exibirEstado("Estado Inicial");

		// Atualizações conforme exemplo: E, F, G, H, I
		String[] atualizacoes = { "E", "F", "G", "H", "I" };
		for (int i = 0; i < atualizacoes.length; i++) {
			cache.put(atualizacoes[i]);
			cache.exibirEstado("Após Atualização " + (i + 1) + " (inseriu " + atualizacoes[i] + ")");
		}
	}
}

