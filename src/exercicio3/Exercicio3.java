package exercicio3;

import java.util.Scanner;

public class Exercicio3 {
	
	Scanner in = new Scanner(System.in);
	ListaAluno primeiro = new ListaAluno();
	ListaAluno ultimo = new ListaAluno();
	int tamanho = 0;
	int escolha;
	
	public ListaAluno percorreAdicinaLista(ListaAluno primeiro, int posiDesejada, int posiAtual, ListaAluno novo) {

		if (posiAtual < posiDesejada) {
			primeiro.setProx(percorreAdicinaLista(primeiro.getProx(), posiDesejada, posiAtual + 1, novo));
			
		} else {
			novo.setProx(primeiro.getProx());
			primeiro.setProx(novo);
		}
		return primeiro;
	}
	
	public ListaAluno percorreRemoveUltimo(ListaAluno primeiro, int posiNovoUltimo, int posiAtual) {

		if (posiAtual < posiNovoUltimo) {
			primeiro.setProx(percorreRemoveUltimo(primeiro.getProx(), posiNovoUltimo, posiAtual + 1));
			
		} else {
			primeiro.setProx(null);
			ultimo = primeiro;
		}
		return primeiro;
	}
	
	public ListaAluno percorreRemoveQualquerPosicao(ListaAluno primeiro, int posicaoEscolhida, int posicaoAtual) {

		if (posicaoAtual < posicaoEscolhida) {
			primeiro.setProx(percorreRemoveQualquerPosicao(primeiro.getProx(), posicaoEscolhida, posicaoAtual + 1));
			
		} else {
			ListaAluno novo = primeiro.getProx();
			primeiro.setProx(novo.getProx());
		}
		return primeiro;
	}

	public void adicionaNoInicio() {
		
		System.out.println("Adicione o RA, nome, turma e semestre do primeiro aluno: ");
		primeiro.setRA(in.nextInt());
		primeiro.setNome(in.next());
		primeiro.setTurma(in.next());
		primeiro.setSemestre(in.next());
	}
	
	public void adicionaNoFinal() {
		
		System.out.println("Adicione o RA, nome, turma e semestre do ultimo aluno: ");
		ultimo.setRA(in.nextInt());
		ultimo.setNome(in.next());
		ultimo.setTurma(in.next());
		ultimo.setSemestre(in.next());
		primeiro.setProx(ultimo);
	}
	
	public void adicionaQualquerPosicao(int posicao) {
		
		ListaAluno novoAluno = new ListaAluno();
		System.out.println("Digite o RA, nome, turma e semestre do novo aluno: ");
		novoAluno.setRA(in.nextInt());
		novoAluno.setNome(in.next());
		novoAluno.setTurma(in.next());
		novoAluno.setSemestre(in.next());

		int anterior = posicao - 1;
		
		primeiro = percorreAdicinaLista(primeiro, anterior, 1, novoAluno);
		
	}
	
	public void removePrimeiro() {
		
		primeiro = primeiro.getProx();
				
	}

	public void imprimeLista() {
		
		ListaAluno percorre = primeiro;
		System.out.println("RA, Nome, Turma, Semestre");
		while (percorre != null) {
		
			System.out.println(percorre.getRA() + ", " + percorre.getNome() + ", " + percorre.getTurma() + ", " + percorre.getSemestre());
			System.out.println("--------------------");
			percorre = percorre.getProx();
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
				adicionaNoInicio();
				tamanho++;
			}
			
			if (escolha == 2) {
				System.out.println("--------------------");
				adicionaNoFinal();
				tamanho++;
			}
			
			if (escolha == 3) {
				System.out.println("--------------------");
				System.out.println("Digite a posição onde quer colocar o novo aluno: ");
				
				int posicao = in.nextInt();	
				if (posicao <= 1 || posicao > tamanho) {
					System.out.println("Essa posição não existe ou não pode ser adicionada");
				}
				else {
					adicionaQualquerPosicao(posicao);
					tamanho++;
				}
				
			}
			
			if (escolha == 4) {
				System.out.println("--------------------");
				removePrimeiro();
				tamanho--;
			}
			
			if (escolha == 5) {
				System.out.println("--------------------");
				percorreRemoveUltimo(primeiro,tamanho - 1, 1);
				tamanho--;
			}
			
			if (escolha == 6) {
				System.out.println("--------------------");
				System.out.println("Digite a posição que deseja remover: ");
				int posicao = in.nextInt();
				if (posicao <= 1 || posicao >= tamanho) {
					System.out.println("Essa posição não existe ou não pode ser removida");
				}
				else {
					percorreRemoveQualquerPosicao(primeiro, posicao - 1, 1);
					tamanho--;
				}
			}

			if (escolha == 7) {
				System.out.println("--------------------");
				imprimeLista();
			}
		}
			
	}
		
	public static void main (String args[]) {
		Exercicio3  exercicio3= new Exercicio3();
		
		System.out.println("Digite 1 para adicionar o primeiro aluno.");
		System.out.println("Digite 2 para adicionar o ultimo aluno.");
		System.out.println("Digite 3 para adicionar um aluno em qualquer posição.");
		System.out.println("Digite 4 para remover o primeiro aluno.");
		System.out.println("Digite 5 para remover o ultimo aluno.");
		System.out.println("Digite 6 para remover um aluno em qualquer posição.");
		System.out.println("Digite 7 para exibir a lista de alunos.");
		System.out.println("Digite 0 para sair.");
		System.out.println("--------------------");
		
		exercicio3.escolhas();

	}

}
