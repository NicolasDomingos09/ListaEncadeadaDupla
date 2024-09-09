package view;
import controller.ListaController;
public class Main {

	public static void main(String[] args) {
		ListaController lista = new ListaController();
		try {
			lista.teste();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
