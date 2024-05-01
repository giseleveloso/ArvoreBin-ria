package BuscaeExclusao;

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

    public int busca (int valor,No noAtual) {
     if (noAtual!=null) {
      if (noAtual.elemento==valor){
        return noAtual.elemento;
      } else if (valor>noAtual.elemento) {
        return busca(valor, noAtual.direita);
      } else {
        return busca(valor, noAtual.esquerda);
      }
     }else{
          System.out.println("Valor não encontrado na árvore");
          return 0;
     }
    }

    public void excluir(int valor, No noAtual) {
      No pai = null;
      No atual = noAtual;
  
      if (atual == null) {
        System.out.println("Valor não encontrado na árvore");
        return;
    }

      while (atual != null && atual.elemento != valor) {
          pai = atual;
          if (valor < atual.elemento) {
              atual = atual.esquerda;
          } else {
              atual = atual.direita;
          }
      }

  
      //1: Nó folha
      if (atual.esquerda == null && atual.direita == null) {
          if (pai == null) {
              noRaiz = null;
          } else if (pai.esquerda == atual) {
              pai.esquerda = null;
          } else {
              pai.direita = null;
          }
      }

      //2: Nó possui apenas um filho
      else if (atual.esquerda == null) {
          if (pai == null) {
              noRaiz = atual.direita;
          } else if (pai.esquerda == atual) { 
              pai.esquerda = atual.direita;
          } else {
              pai.direita = atual.direita;
          }
      } else if (atual.direita == null) {
          if (pai == null) {
              noRaiz = atual.esquerda;
          } else if (pai.esquerda == atual) {
              pai.esquerda = atual.esquerda;
          } else {
              pai.direita = atual.esquerda;
          }
      }
      //3: Nó possui dois filhos
      else {
          No sucessor = encontrarMenor(atual.direita);
          int prox = sucessor.elemento;
          excluir(prox, noAtual);
          atual.elemento = prox;
      }
  }
  
  private No encontrarMenor(No no) {
      while (no.esquerda != null) {
          no = no.esquerda;
      }
      return no;
  }
  
}