/**
 * Classe utilizada para representar as características de um estado no programa principal,
 * contendo informações advintas da classe "Database" e representando esses dados com a classe "Plot"
 * 
 * O estado em questão contará com um número de dias, uma id própria utilizando um enum, e os equivalentes
 * dados que serão recebidos ao utilizarmos os métodos criados na classe "Database".
 * Uma vez com os dados utilizaremos também os métodos da classe "Plot" para a vizualização em forma de gráficos.
 */
public class Estado {
	public int dias;
	public int id;
	public int[] infectados;
	public int[] recuperados;
	public int[] mortos;
	public int[] vacinados;
	public int[] diaVacinacao;
	public String[] noticias;
	Database database = new Database();

	//Construtor, recebendo apenas o id do estado a ser montado
	//Utilizaremos os respectivos métodos da classe "Database" para obtermos os valores
	public Estado(int id) {
		this.id = id;
		this.dias = database.getDias();
		this.infectados = database.getInfectados(this.id, this.dias);
		this.recuperados = database.getRecuperados(this.id, this.dias);
		this.mortos = database.getMortos(this.id, this.dias);
		this.vacinados = database.getVacinados(this.id, this.dias);
		this.noticias = database.getNews(this.id);
		this.diaVacinacao = database.getDataVacina(this.id);
	}

	//Método para a plotagem dos números de infectados neste estado no decorrer de certos dias
	public void plot_infectados() {
		String title = "Número de Infectados";
		String legenda = "Gráfico referente à progressão do número de infectados nos últimos" + String.valueOf(this.dias);

		Plot.plotChart(title, legenda, this.infectados);
	}

	//Método para a plotagem dos números de recuperados neste estado no decorrer de certos dias
	public void plot_recuperados() {
		String title = "Número de Recuperados";
		String legenda = "Gráfico referente à progressão do número de recuperados nos últimos" + String.valueOf(this.dias);

		Plot.plotChart(title, legenda, this.recuperados);
	}

	//Método para a plotagem dos números de mortos neste estado no decorrer de certos dias
	public void plot_mortos() {
		String title = "Número de Mortos";
		String legenda = "Gráfico referente à progressão do número de mortos nos últimos" + String.valueOf(this.dias);

		Plot.plotChart(title, legenda, this.mortos);
	}

	//Método para a plotagem dos números de vacinados neste estado no decorrer de certos dias
	public void plot_vacinados() {
		String title = "Número de Vacinados";
		String legenda = "Gráfico referente à progressão do número de vacinados nos últimos" + String.valueOf(this.dias);

		Plot.plotChart(title, legenda, this.vacinados);
	}

	//Método para a impressão das notícias sobre a COVID-19
	public void print_noticias() {
		for(int i = 0; i < this.noticias.length; i++)
			System.out.println(i + ")" + this.noticias[i] + "\n");
	}

	//Método para a impressão da data de vacinação estimada
	public void print_data(int grupo){
		System.out.println("Uma vez no grupo " + grupo + " vocẽ pode se vacinar dia " + this.diaVacinacao[grupo - 1]);
	}
}