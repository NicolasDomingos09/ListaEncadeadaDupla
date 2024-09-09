package controller;

import model.ListaDupla;
import model.No;


public class ListaController {
	
	public ListaDupla<Object> lista = new ListaDupla<Object>();
	
	public ListaController() {
		super();
	}
	
	public void teste() throws Exception{
		
		lista.append("Alguém me mata por favor");
		lista.append(2);
		lista.append(5);
		System.out.println(lista.toString());
		System.out.println(lista.getTamanho());
		System.out.println(lista.index(2));
		lista.remove(2); //remove 5
		
		No<Object> item = lista.get(1);
		System.out.println(item.getElemento().toString());
		
		No<Object> last = lista.last();
		System.out.println(last.getElemento().toString());
		
		lista.prepend(1);
		lista.insert(1,0);
		System.out.println(lista.toString());
		
	}
}
