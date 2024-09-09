package model;

public class ListaDupla<T> {
	private No<T> inicio = null;
	private No<T> fim = null;
	
	public void append(T elemento) {
		No<T> buffer = new No<>(elemento); 
		
		if(this.fim == null) { //Condicional que trata a lista vazia
			this.fim = buffer;
			this.inicio = buffer;
		}else {
			No<T> former = this.fim; //former recebe o antigo último item da lista
			former.setProximo(buffer); //former(proximo) = novo elemento
			buffer.setAnterior(former); //buffer(anterior) = antigo ultimo
			this.fim = buffer; //buffer é o novo fim
		}
	}
	
	public No<T> get(int index) throws Exception {
		int i = 0;
		if(this.inicio == null)
			throw new Exception("A lista está vazia");
		
		No<T> buffer = this.inicio;
		for(i = 0; i < index; i++) {
			if(buffer.getProximo() == null) //Fim da lista sem encontrar o objeto
				break;
			buffer = buffer.getProximo();
		}
		if(i < index)
			throw new Exception("Indice informado não existe");
		
		return buffer;
	}
	
	public int index(T elemento) throws Exception {
		if(this.inicio == null)
			throw new Exception("A lista está vazia");
		
		int index = 0;
		//Procurar elemento
		if(this.inicio.getElemento() == elemento) 
			return index; //Elemento é o primeiro da lista
		
		No<T> buffer = this.inicio; //Buffer para percorrer nos da lista
		while(buffer != null) {
			if(buffer.getElemento() == elemento) //elemento encontrado
				return index; 
			buffer = buffer.getProximo();
			index++;
		}
		throw new Exception("Item não encontrado");
	}
	
	public void insert(int index, T elemento) throws Exception {
		 if(index == 0) { //Adicionar no inicio
			prepend(elemento);
		 
		 }else if(index >= getTamanho()) { //Adicionar no final
			 append(elemento);
		 
		 }else { //Adicionar em um indice diferente de 0
			 No<T> novo = new No<>(elemento);
			 No<T> anterior = get(--index);
			 No<T> proximo = anterior.getProximo();

			 novo.setProximo(proximo);
			 novo.setAnterior(anterior);
			 anterior.setProximo(novo);
		 }
	}
	
	public void prepend(T elemento) {
		No<T> buffer = new No<>(elemento);
		
		if(this.inicio == null) {
			this.fim = buffer;
			this.inicio = buffer;
		}else {
			No<T> former = this.inicio; //Antigo começo
			//ponteiros
			former.setAnterior(buffer);
			buffer.setProximo(former);
			this.inicio = buffer; //novo começo
		}
	}
	
	public void remove(int index) throws Exception {
		if(this.fim == null) throw new Exception("A lista está vazia");
		
		if(index == 0) {
			this.inicio.setElemento(null); //remove o elemento da primeira posição
			
			if(this.inicio.getProximo() == null) { //há apenas um elemento na lista
				this.inicio = null;
				this.fim = null;
			}else { //Há mais de um elemento na lista
				No<T> novo = this.inicio.getProximo(); //novo index 0
				novo.setAnterior(null);
				this.inicio = novo;
			}
		}else {
			//busca nodes afetados
			No<T> anterior = get((index -1));
			No<T> elemento = anterior.getProximo();
			No<T> proximo = elemento.getProximo();
			
			//Atualiza ponteiros
			anterior.setProximo(proximo);

			//esvazia o node elemento
			elemento.setElemento(null);
			elemento.setProximo(null);
			elemento.setAnterior(null);
		}
	}
	
	public int getTamanho() {
		if(this.inicio == null)
			return 0;
		
		No<T> buffer = this.inicio;
		int tamanho = 0;
		while(buffer.getProximo() != null) {
			++tamanho;
			buffer = buffer.getProximo();
		}
		return tamanho;
	}
	
	public No<T> last() throws Exception{
		return get((getTamanho()-1));
	}
	
	@Override
	public String toString(){
		if(this.inicio == null){
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.inicio;
		
		builder.append(buffer.getElemento());
		
		while(buffer.getProximo() != null){
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getElemento());
		}

		builder.append("]");
		return builder.toString();
	}
}
