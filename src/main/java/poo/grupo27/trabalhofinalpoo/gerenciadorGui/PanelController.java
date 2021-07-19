package poo.grupo27.trabalhofinalpoo.gerenciadorGui;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;
import poo.grupo27.trabalhofinalpoo.gui.*;

/**
 * Serve para controlar os cards do MainFrame
 */
public class PanelController {
    private State estado;
    private final MainFrame main;
    private final HomePanel home;
    private final DataVacinaPanel data;
    private final InfoPanel info;
    private final CuidadosPanel cuidados;
    private final FAQPanel faq;
    private final GraficosPanel graficos;
    public PanelController(){
        //Cria todos os frames que são usados no programa
        main = new MainFrame(this);
        home = new HomePanel(this);
        data = new DataVacinaPanel(getTest());
        info = new InfoPanel(getTest(), getTest());
        cuidados = new CuidadosPanel(getTest());
        faq = new FAQPanel( getTest(), getTest());
        graficos = new GraficosPanel(this);
        //Adiciona todos em uma ArrayList
        ArrayList<JPanel> array = new ArrayList();
        array.add(home);
        array.add(data);
        array.add(info);
        array.add(cuidados);
        array.add(graficos);
        array.add(faq);
        //Coloca tudo em um vetor de referencia para a troca dos Cards
        String names[] = {Cards.MAIN_FRAME.getValue(), Cards.DATE_FRAME.getValue(), Cards.INFO_FRAME.getValue(), Cards.CARE_FRAME.getValue(), Cards.GRAPH_FRAME.getValue(), Cards.FAQ_FRAME.getValue()};
        //Adiciona os cards no MainFrame
        main.putFrames(array, new ArrayList<>(Arrays.asList(names)));
        //Coloca a Home como primeira a ser exibida
        main.setFrame(Cards.MAIN_FRAME);
        //Inicia o visual
        main.setVisible(true);
    }
    
    /**
     * Muda o estado que esta sendo consideirado
     * @param newState novo estado
     */
    public void changeState(State newState){
        estado = newState;
    }
    
    public State getState(){
        return estado;
    }
    
    /**
     * Muda o frame que está sendo exibido
     * @param nextFrame Indica qual será o proximo a ser mostrado
     */
    public void changeActualFrame(Cards nextFrame){
        main.setFrame(nextFrame);
    }
    
    /**
     * Metodo usado para testes dos textos a serem mostrados
     * @return uma ArrayList de Strings a serem testadas
     */
    protected ArrayList<String> getTest(){
        ArrayList<String> testePerguntas = new ArrayList<>();
        testePerguntas.add("T1");
        testePerguntas.add("T2");
        testePerguntas.add("T3");
        testePerguntas.add("T4");
        testePerguntas.add("T5");
        //testePerguntas.add("T6");
        return testePerguntas;
    }
}