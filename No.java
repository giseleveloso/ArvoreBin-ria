public class No {
	public int elemento;
	public No direita;
	public No esquerda;
	
	No(int valor){
		this.elemento=valor;
		this.direita=null;
		this.esquerda=null;
	}

	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

}