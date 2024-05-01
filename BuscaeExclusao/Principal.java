package BuscaeExclusao;

public class Principal {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserirNo(arvore.noRaiz, 5);
        arvore.inserirNo(arvore.noRaiz, 3);
        arvore.inserirNo(arvore.noRaiz, 7);
        arvore.inserirNo(arvore.noRaiz, 2);
        arvore.inserirNo(arvore.noRaiz, 4);
        arvore.inserirNo(arvore.noRaiz, 6);
        arvore.inserirNo(arvore.noRaiz, 8);
        arvore.inserirNo(arvore.noRaiz, 9);

        arvore.preOrdem(arvore.getRaiz());
        System.out.println();
        System.out.println();

        arvore.emOrdem(arvore.getRaiz());
        System.out.println();
        System.out.println();

        arvore.posOrdem(arvore.getRaiz());
        System.out.println();
        System.out.println();

        System.out.println(arvore.busca(8, arvore.getRaiz()));

        arvore.excluir(9, arvore.getRaiz());
        arvore.emOrdem(arvore.getRaiz());
    }
}
