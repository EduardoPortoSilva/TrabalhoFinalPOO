import java.util.Random;

/**
 * Classe utilizada para originar os dados "ficticios" a serem utilizados no programa principal
 * a idéia desta classe é simular um servidor que forneceria as informações atualizadas ao software
 */

public class Database {
	
	public int getDias() {
		return 50;
	}
	
	Random rd = new Random();
	
	int[] infectados_iniciais = {159383 , 100886 , 162777 , 106915 , 117793 , 108335 , 155386 , 130492 , 86649 , 111421 , 72362 , 160027 , 225000 , 138690 , 90059 , 167763 , 83926 , 150540 , 325500 , 153426 , 159172 , 125736 , 75211 , 165368 , 450000 , 72567 , 126429};
	int[] mortos_iniciais = {13383 , 12886 , 20777 , 26915 , 17793 , 15335 , 15386 , 10492 , 18649 , 11421 , 12362 , 12027 , 15000 , 18690 , 10059 , 18763 , 17926 , 10540 , 25000 , 13426 , 19172 , 25736 , 15211 , 25368 , 50000 , 12567 , 16429};
	int[] recuperados_iniciais = {139383 , 110886 , 122777 , 126915 , 147793 , 148335 , 145386 , 140492 , 166649 , 101421 , 92362 , 120027 , 180000 , 88690 , 100059 , 87763 , 103926 , 140540 , 200000 , 113426 , 149172 , 155736 , 165211 , 125368 , 300000 , 122567 , 116429};
	int[] vacinados_iniciais = {139383 , 110886 , 122777 , 126915 , 147793 , 118335 , 125386 , 120492 , 136649 , 101421 , 92362 , 120027 , 220000 , 88690 , 100059 , 87763 , 103926 , 140540 , 200000 , 113426 , 149172 , 155736 , 165211 , 125368 , 250000 , 122567 , 116429};
	int[] data_vacina = {11 , 14 , 12 , 15 , 11 , 13 , 13 , 12 , 11 , 13 , 12 , 15 , 12 , 16 , 14 , 16 , 10 , 13 , 12 , 11 , 12 , 12 , 13 , 10 , 10 , 15 , 12};
	
	double[] rgmax = {0.0891698 , 0.0100236 , 0.0824476 , 0.0772022 , 0.099731 , 0.0104564 , 0.0108233 , 0.0109778 , 0.010316 , 0.0104008 , 0.0109388 , 0.0101072 ,  0.13 , 0.0103396 , 0.0113194 , 0.0103129 , 0.0102839 , 0.0101686 ,  0.01 , 0.0102478 , 0.0100057 , 0.0102882 , 0.0100829 , 0.0108115 ,  0.012 , 0.010931 , 0.0109757};

	
	public int[] getInfectados(int id, int dias){
		int[] dados = new int[dias];
		
		int ini = infectados_iniciais[id];
		
		double rangeMin = 0.02, rangeMax = rgmax[id];
		
		for(int i = 0; i < dias; i++) {
			dados[i] = ini;
			double randomValue = rangeMin + (rangeMax - rangeMin) * rd.nextDouble();
			ini = (int)((double)ini*(1.0 + randomValue));
		}
		
		return dados;
	}
	
	public int[] getMortos(int id, int dias){
		int[] dados = new int[dias];
		
		int ini = mortos_iniciais[id];
		
		double rangeMin = 0.01, rangeMax = 0.012;
		
		for(int i = 0; i < dias; i++) {
			dados[i] = ini;
			double randomValue = rangeMin + (rangeMax - rangeMin) * rd.nextDouble();
			ini = (int)((double)ini*(1.0 + randomValue));
		}
		
		return dados;
	}
	
	public int[] getRecuperados(int id, int dias){
		int[] dados = new int[dias];
		
		int ini = recuperados_iniciais[id];
		
		double rangeMin = 0.05, rangeMax = rgmax[id];
		
		for(int i = 0; i < dias; i++) {
			dados[i] = ini;
			double randomValue = rangeMin + (rangeMax - rangeMin) * rd.nextDouble();
			ini = (int)((double)ini*(1.0 + randomValue));
		}
		
		return dados;
	}
	
	public int[] getVacinados(int id, int dias){
		int[] dados = new int[dias];
		
		int ini = vacinados_iniciais[id];
		
		double rangeMin = 0.005, rangeMax = 0.01;
		
		for(int i = 0; i < dias; i++) {
			dados[i] = ini;
			double randomValue = rangeMin + (rangeMax - rangeMin) * rd.nextDouble();
			ini = (int)((double)ini*(1.0 + randomValue));
		}
		
		return dados;
	}
	
	public int[] getDataVacina(int id) {
		int[] res = new int[6];
		int ini = data_vacina[id];
		for(int groups = 1; groups <= 5; groups++) {
			res[groups] = ini;
			double randomValue = 0.1 + (0.35 - 0.1) * rd.nextDouble();
			ini = 30 + (int)((double)ini*(1.0 + randomValue));
		}
		return res;
	}
	
	public String[] getNews(int id) {
		String[] ans = new String[2];
		ans[0] = "Lote de vacinas da Coronavac, com aproximadamente " + (int)(0.4*vacinados_iniciais[id]) + " imunizantes acaba de chegar ao estado.";
		ans[1] = "Média móvel de infectados segue a uma taxa de crescimento de " + (int)(100.0*((0.02 + rgmax[id])/2.0)) + "% ao dia."; 
		return ans;
	}
	
	public static void main(String[] args) {
		Database d = new Database();
		
		/*int[] dados = d.getInfectados(24, 50);
		
		for(int i:dados) {
			System.out.print(i + " ");
		}System.out.println();
		*/
		String r[] = d.getNews(12);
		for(String s:r) {
			System.out.println(s);
		}
	}

}