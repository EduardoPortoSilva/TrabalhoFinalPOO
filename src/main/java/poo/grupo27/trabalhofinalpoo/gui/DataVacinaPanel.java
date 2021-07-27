package poo.grupo27.trabalhofinalpoo.gui;

import external.Estado;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Classe responsavel pelo Card sobre a data de vacinação
 */
public class DataVacinaPanel extends javax.swing.JPanel {
    
    private ArrayList<JCheckBox> checkBoxes;
    private Estado estado;
    
    /**
     * Cria o Painel das datas
     * @param comorbidades A lista de comorbidades
     */
    public DataVacinaPanel(ArrayList<String> comorbidades, Estado estado) {
        initComponents();
        preencheComorbidades(comorbidades);
        mudaEstado(estado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdade = new javax.swing.JLabel();
        fieldIdade = new javax.swing.JTextField();
        panelComorbidades = new javax.swing.JPanel();
        lblResultado = new javax.swing.JLabel();

        lblIdade.setText("Informe a sua idade");

        fieldIdade.setBorder(null);
        fieldIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                validaIdade(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelComorbidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldIdade, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addComponent(lblResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(fieldIdade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelComorbidades, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Listener de KeyPressed, confere se a idade informada é valida
     */
    private void validaIdade(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_validaIdade
        if(evt.getKeyChar() < (char)32 || evt.getKeyChar() == (char)127)//Teclas de comandos
            return;
        try{
            Integer.parseInt(fieldIdade.getText());
            calculaVacina();
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(new JFrame(), "Insira um valor valido, por favor", "Problemas com a idade", JOptionPane.WARNING_MESSAGE);
            fieldIdade.setText(fieldIdade.getText().substring(0, fieldIdade.getText().length()-1));
        }
    }//GEN-LAST:event_validaIdade
    
    /**
     * Adiciona as checkbox das comorbidades
     */
    private void preencheComorbidades(ArrayList<String> comorbidades){
        checkBoxes = new ArrayList<>();
        for(int i = 0; i < comorbidades.size(); i++){
            //Cria uma checkbox
            JCheckBox temp = new JCheckBox(comorbidades.get(i));
            //Adiciona o ActionListener como mudaComorbidades
            temp.addActionListener((ActionEvent evt) -> {
                mudaComorbidades();
            });
            //Coloca nos paneis;
            checkBoxes.add(temp);
            panelComorbidades.add(temp);
        }
    }
    
    public void mudaEstado(Estado estado){
        this.estado = estado;
    }
    
    /**
     * ActionListener das checkboxes valida as opções e passa para calculaVacina()
     */
    private void mudaComorbidades(){
        calculaVacina();
    }
    
    //TODO: Fazer a função de calculo da data
    /**
     * Responsavel pelo calculo da data de vacinação
     */
    private void calculaVacina(){
        int grupo = 0;
        int idade = 0;
        try{
            idade = Integer.parseInt(fieldIdade.getText());
        }catch(NumberFormatException ex){
            idade = 0;
        }
        if(idade >= 60 || checkBoxes.get(0).isSelected() || checkBoxes.get(1).isSelected() || checkBoxes.get(2).isSelected()){
            grupo = 1;
        }else if(idade >= 40 || checkBoxes.get(3).isSelected() || checkBoxes.get(4).isSelected() || checkBoxes.get(5).isSelected() || checkBoxes.get(6).isSelected()){
            grupo = 2;
        }else if(idade >= 30 || checkBoxes.get(7).isSelected() || checkBoxes.get(8).isSelected()){
            grupo = 3;
        }else if(idade >= 18){
            grupo = 4;
        }else{
            grupo = 5;
        }
        lblResultado.setText(estado.print_data(grupo));
        //lblResultado.setText("Previsão de vacinação (Primeira Dose) : " );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldIdade;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JPanel panelComorbidades;
    // End of variables declaration//GEN-END:variables
}
/*jCheckBox1.setText("jCheckBox1");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });*/