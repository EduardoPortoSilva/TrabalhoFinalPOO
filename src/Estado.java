public class Estado {
	public int semanas;
	public Tupla<Integer, Integer>[] infectados;
	public Tupla<Integer, Integer>[] recuperados;
	public Tupla<Integer, Integer>[] mortos;
	public Tupla<Integer, Integer>[] vacinados;
	public String[] noticias;
	public String[] diaVacinacao;
	//private Plot graficos;

	public void plot_infectados(Tupla<Integer, Integer>[] infect) {
		//graficos.plotar
	}

	public void plot_recuperados(Tupla<Integer, Integer>[] recup) {
		//graficos.plotar
	}

	public void plot_mortos(Tupla<Integer, Integer>[] mortos) {
		//graficos.plotar
	}

	public void plot_vacinados(Tupla<Integer, Integer>[] vacinados) {
		//graficos.plotar
	}

	public void print_noticias(String[] noticias) {
		for(int i = 0; i < noticias.length; i++)
			System.out.println(i + ")" + noticias[i] + "\n");
	}

	public void print_data(int grupo){
		System.out.println("Uma vez no grupo " + grupo + " vocẽ pode se vacinar dia " + this.diaVacinacao[grupo - 1]);
	}
}