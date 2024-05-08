package Altura;

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

    public int altura(No raiz) {
      if (raiz == null) {
          return 0;
      }
          int alturaEsquerda = altura(raiz.esquerda);
          int alturaDireita = altura(raiz.direita);
  
          if (alturaEsquerda > alturaDireita) {
              return alturaEsquerda + 1;
          } else {
              return alturaDireita + 1;
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
          if (pai == null) { //se a árvore só possui um elemento
              noRaiz = null;
          } else if (pai.esquerda == atual) { //se a folha está à esquerda do pai
              pai.esquerda = null;
          } else {
              pai.direita = null; //se a folha está à direita do pai
          }
      }

      //2: Nó possui apenas um filho
      else if (atual.esquerda == null) { //se o nó só possui um filho à direira
          if (pai == null) { //se o nó é raiz
              noRaiz = atual.direita;
          } else if (pai.esquerda == atual) { //se o nó que eu quero remover estiver à esquerda, o novo nó à esquerda será o que estava do lado direito
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
          No sucessor = encontrarMenor(atual.direita); //retorna o nó mais à esquerda
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

  public boolean EstritamenteBinaria(No raiz) {
    if (raiz == null)
        return true;

    if (raiz.esquerda == null && raiz.direita == null)
        return true;

    if (raiz.esquerda != null && raiz.direita != null)
        return EstritamenteBinaria(raiz.esquerda) && EstritamenteBinaria(raiz.direita);

    return false;
}

public boolean Completa(No raiz) {
    int altura = altura(raiz);
    return CompletaAux(raiz, 0, altura);
}

private boolean CompletaAux(No no, int index, int altura) {
    if (no == null)
        return true;

    if (index >= altura)
        return false;

    return (CompletaAux(no.esquerda, 2 * index + 1, altura) && CompletaAux(no.direita, 2 * index + 2, altura));
}

public boolean Cheia(No raiz) {
    int altura = altura(raiz);
    return CheiaAux(raiz, altura);
}

private boolean CheiaAux(No no, int altura) {
    if (no == null)
        return true;

    if (no.esquerda == null && no.direita == null && altura == 1)
        return true;

    if (no.esquerda != null && no.direita != null)
        return CheiaAux(no.esquerda, altura - 1) && CheiaAux(no.direita, altura - 1);

    return false;
}

  
}