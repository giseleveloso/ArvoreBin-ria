public class Principal {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserirNo(arvore.noRaiz, 10);
        arvore.inserirNo(arvore.noRaiz, 5);
        arvore.inserirNo(arvore.noRaiz, 12);

        arvore.preOrdem(arvore.getRaiz());
        System.out.println();
        System.out.println();

        arvore.emOrdem(arvore.getRaiz());
        System.out.println();
        System.out.println();

        arvore.posOrdem(arvore.getRaiz());
    }
}
