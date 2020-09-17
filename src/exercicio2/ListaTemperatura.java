package exercicio2;

public class ListaTemperatura {
	
	private Integer temperatura;
	private ListaTemperatura proximaTemperatura;
	
	public ListaTemperatura() {
	}
	
	public Integer getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(Integer Temperatura) {
		this.temperatura = Temperatura;
	}
	
	public ListaTemperatura getProx() {
		return proximaTemperatura;
	}
	
	public void setProx(ListaTemperatura Prox) {
		this.proximaTemperatura = Prox;
	}
	
}
