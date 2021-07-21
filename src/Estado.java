public class Estado {
	public int semanas;
	public String nome;
	public int[][] infectados;
	public int[][] recuperados;
	public int[][] mortos;
	public int[][] vacinados;
	public String[] noticias;
	public String[] diaVacinacao;

	public Estado(int semanas, int[][] infect, int[][] recup, int[][] mortos, int[][]vacin, String[] news, String[] diaVac) {
		this.semanas = semanas;
		this.infectados = infect;
		this.recuperados = recup;
		this.mortos = mortos;
		this.vacinados = vacin;
		this.noticias = news;
		this.diaVacinacao = diaVac;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void plot_infectados() {
		String title = "Número de Infectados";
		String[] legenda = new String[] {"Gráfico", "referente", "à", "progressão", "do", "número", "de", "infectados", "em", this.nome, "nas", String.valueOf(this.semanas)};

		Plot.plotChart(title, legenda, this.infectados);
	}

	public void plot_recuperados() {
		String title = "Número de Infectados";
		String[] legenda = new String[] {"Gráfico", "referente", "à", "progressão", "do", "número", "de", "recuperados", "em", this.nome, "nas", String.valueOf(this.semanas)};

		Plot.plotChart(title, legenda, this.recuperados);
	}

	public void plot_mortos() {
		String title = "Número de Infectados";
		String[] legenda = new String[] {"Gráfico", "referente", "à", "progressão", "do", "número", "de", "mortos", "em", this.nome, "nas", String.valueOf(this.semanas)};

		Plot.plotChart(title, legenda, this.mortos);
	}

	public void plot_vacinados() {
		String title = "Número de Infectados";
		String[] legenda = new String[] {"Gráfico", "referente", "à", "progressão", "do", "número", "de", "vacinados", "em", this.nome, "nas", String.valueOf(this.semanas)};

		Plot.plotChart(title, legenda, this.vacinados);
	}

	public void print_noticias() {
		for(int i = 0; i < this.noticias.length; i++)
			System.out.println(i + ")" + this.noticias[i] + "\n");
	}

	public void print_data(int grupo){
		System.out.println("Uma vez no grupo " + grupo + " vocẽ pode se vacinar dia " + this.diaVacinacao[grupo - 1]);
	}
}