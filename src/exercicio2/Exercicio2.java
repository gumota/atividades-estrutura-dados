package exercicio2;

import java.util.Scanner;

public class Exercicio2 {
	
	Scanner in = new Scanner(System.in);
	ListaTemperatura primeiro = new ListaTemperatura();
	ListaTemperatura ultimo = new ListaTemperatura();
	int tamanho = 0;
	int escolha;
	
	public ListaTemperatura percorreAdicinaLista(ListaTemperatura primeiro, int posiDesejada, int posiAtual, ListaTemperatura novo) {

		if (posiAtual < posiDesejada) {
			primeiro.setProx(percorreAdicinaLista(primeiro.getProx(), posiDesejada, posiAtual + 1, novo));
			
		} else {
			novo.setProx(primeiro.getProx());
			primeiro.setProx(novo);
		}
		return primeiro;
	}
	
	public ListaTemperatura percorreRemoveUltimo(ListaTemperatura primeiro, int posiNovoUltimo, int posiAtual) {

		if (posiAtual < posiNovoUltimo) {
			primeiro.setProx(percorreRemoveUltimo(primeiro.getProx(), posiNovoUltimo, posiAtual + 1));
			
		} else {
			System.out.println("O valor removido foi: " + (primeiro.getProx()).getTemperatura());
			primeiro.setProx(null);
			ultimo = primeiro;
			
		}
		return primeiro;
	}
	
	public ListaTemperatura percorreRemoveQualquer(ListaTemperatura primeiro, int posiDesejada, int posiAtual) {

		if (posiAtual < posiDesejada) {
			primeiro.setProx(percorreRemoveQualquer(primeiro.getProx(), posiDesejada, posiAtual + 1));
			
		} else {
			ListaTemperatura novo = primeiro.getProx();
			System.out.println("O valor removido foi: " + novo.getTemperatura());
			primeiro.setProx(novo.getProx());
			
		}
		return primeiro;
	}
	
	public boolean verificaListaVazia() {
		
		if (primeiro.getTemperatura() == null) {
			return true;
			
		} else {
			return false;
		}
	}
	
	
	public void adicionaNoInicio() {
		
		System.out.println("adicione a primeira temperatura: ");
		primeiro.setTemperatura(in.nextInt());	
	}
	
	public void adicionaNoFinal() {
		
		System.out.println("adicione a ultima temperatura: ");
		ultimo.setTemperatura(in.nextInt());
		primeiro.setProx(ultimo);
		
	}
	
	public void adicionaQualquerPosicao(int posicao) {
		
		ListaTemperatura Novo = new ListaTemperatura();
		System.out.println("digite a nova temperatura: ");
		Novo.setTemperatura(in.nextInt());

		int anterior = posicao - 1;
		primeiro = percorreAdicinaLista(primeiro, anterior, 1, Novo);
	}
	
	public void removePrimeiro() {
		
		System.out.println("O valor removido foi: " + primeiro.getTemperatura());
		primeiro = primeiro.getProx();
				
	}
	
	public void imprimeLista() {
		
		ListaTemperatura Percorre = primeiro;
		while (Percorre != null) {
			System.out.println(Percorre.getTemperatura());
			Percorre = Percorre.getProx();
		}
		
	}
	
	public void escolhas() {
		
		
		boolean saiu = false;
		while (saiu == false) {
			
			System.out.println("Digite uma escolha: ");
			escolha = in.nextInt();
			
			if (escolha == 0) {
				saiu = true;
			}
			
			if (escolha == 1) {
				
				System.out.println("--------------------");
				if (verificaListaVazia()) {
					System.out.println("A lista está vazia.");
					
				} else {
					System.out.println("A lista já foi iniciada.");
				}
			}
			
			if (escolha == 2) {
				
				System.out.println("--------------------");
				if (primeiro.getTemperatura() != null) {
					System.out.println("O primeiro item já existe");
					
				} else {
					adicionaNoInicio();
					tamanho++;
				}
			}
			
			if (escolha == 3) {
				
				System.out.println("--------------------");
				if (!verificaListaVazia() && ultimo.getTemperatura() != null) {
					System.out.println("O ultimo item já existe");
				}
				else {
					adicionaNoFinal();
					tamanho++;
				}
			}
			
			if (escolha == 4) {
				
				System.out.println("--------------------");
				System.out.println("digite a posição onde quer colocar a nova temperatura: ");
				int posicao = in.nextInt();	
				if (posicao <= 1 || posicao > tamanho) {
					System.out.println("Essa posição não existe ou não pode ser adicionada");
				}
				else {
					adicionaQualquerPosicao(posicao);
					tamanho++;
				}
			}
			
			if (escolha == 5) {
				
				System.out.println("--------------------");
				if (verificaListaVazia()) {
					System.out.println("A lista está vazia");
				}
				else {
					removePrimeiro();
					tamanho--;
				}
			}
			
			if (escolha == 6) {
				
				System.out.println("--------------------");
				if (verificaListaVazia()) {
					System.out.println("A lista está vazia");
				}
				else {
				percorreRemoveUltimo(primeiro,tamanho - 1, 1);
				tamanho--;
				}
			}
			
			if (escolha == 7) {
				
				System.out.println("--------------------");
				System.out.println("Digite a posição que deseja remover: ");
				int posicao = in.nextInt();
				if (posicao < 1 || posicao > tamanho) {
					System.out.println("Essa posição não existe ou não pode ser removida");
				}
				else {
					percorreRemoveQualquer(primeiro, posicao - 1, 1);
					tamanho--;
				}
				
			}
			
			if (escolha == 8) {
				System.out.println("--------------------");
				imprimeLista();
			}
		}
	}
	
	public static void main (String args[]) {
		Exercicio2 exercicio2 = new Exercicio2();
		
		System.out.println("Digite 1 para verificar se a lista está vazia.");
		System.out.println("Digite 2 para adicionar o primeiro elemento.");
		System.out.println("Digite 3 para adicionar o ultimo elemento.");
		System.out.println("Digite 4 para adicionar um elemento em qualquer posição.");
		System.out.println("Digite 5 para remover o primeiro elemento.");
		System.out.println("Digite 6 para remover o ultimo elemento.");
		System.out.println("Digite 7 para remover um elemento em qualquer posição.");
		System.out.println("Digite 8 para exibir a lista.");
		System.out.println("Digite 0 para sair.");
		System.out.println("--------------------");
		
		exercicio2.escolhas();
		
		
	}

}

