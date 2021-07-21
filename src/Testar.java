public class Testar{
    public static void main(String[] args) throws Exception{
        int[][] infectados = new int[][] {{1, 2, 3, 4, 5}, {10, 20, 30, 40, 50}};
	    int[][] recuperados = new int[][] {{1, 2, 3, 4, 5}, {10, 20, 30, 40, 50}};
	    int[][] mortos = new int[][] {{1, 2, 3, 4, 5}, {10, 20, 30, 40, 50}};
	    int[][] vacinados = new int[][] {{1, 2, 3, 4, 5}, {10, 20, 30, 40, 50}};
	    String[] noticias = new String[] {"Numero de mortes aumento", "Mais vacinas chegaram esta manhã"};
	    String[] diaVacinacao = new String[] {"19/09/21", "20/7/21", "3/4/22"};

        Estado teste = new Estado(10, infectados, recuperados, mortos, vacinados, noticias, diaVacinacao);
        teste.setNome("São Paulo");
        teste.print_noticias();
        teste.plot_infectados();
        teste.plot_mortos();
        teste.plot_recuperados();
        teste.plot_vacinados();
        teste.print_data(2);
    }
}