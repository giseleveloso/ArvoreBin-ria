public class ArvoreBinaria {
    public No noRaiz;

    public ArvoreBinaria(){
        this.noRaiz = null;
    }
    public void inserirNo(No noAtual, int elemento ){

      if (this.noRaiz==null) {
        this.noRaiz=new No(elemento);
      }
      else if (noAtual.elemento>elemento) {
        if (noAtual.esquerda==null) {
          noAtual.esquerda = new No(elemento);
        }
        else{
          noAtual=noAtual.esquerda;
          inserirNo(noAtual, elemento);
        }
      }
      else if (noAtual.elemento<elemento){
        if (noAtual.direita==null) {
          noAtual.direita = new No(elemento);
        }
        else{
          noAtual=noAtual.direita;
          inserirNo(noAtual, elemento);
        }
      }
    }

    public No getRaiz(){
      return this.noRaiz;
    }

    public void preOrdem(No raiz){ //cima-esquerda-direita
      if (raiz != null) {
        System.out.print(raiz.elemento + " ");
        preOrdem(raiz.esquerda);
        preOrdem(raiz.direita);
      }
    }

    public void emOrdem(No noAtual){ //esquerda-cima-direita
      if (noAtual != null) {
        emOrdem(noAtual.esquerda);
        System.out.print(noAtual.elemento + " ");
        emOrdem(noAtual.direita);
      }
    }

    public void posOrdem(No raiz){ //esquerda-direita-cima
      if (raiz != null) {
        posOrdem(raiz.esquerda);
        posOrdem(raiz.direita);
        System.out.print(raiz.elemento + " ");
      }
    }
}