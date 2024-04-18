
public class ArvoreBinaria {
  private No noRaiz;
  private No direita;
  private No esquerda;

  public ArvoreBinaria(){
    this.noRaiz=null;
  }

  public void inserirNo(No noAtual, int elemento){
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
}