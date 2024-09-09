package model;

public class No<T> {
	private T elemento; //Valor genérico
	private No<T> proximo; //No <-- No // No<T> <-- No é genérico
	private No<T> anterior;
	
	public No(T elemento) {
		this.proximo = null;
		this.anterior = null;
		this.elemento = elemento;		
	}
	
	public void setElemento(T valor) {
		this.elemento = valor;
	}
	
	public T getElemento(){
		return elemento;
	}
	
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	
	public No<T> getProximo() {
		return proximo;
	}
	
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	
	public No<T> getAnterior(){
		return anterior;
	}
	
	@Override
	public String toString() {
		return elemento.toString();
	}
}
