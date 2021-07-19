package poo.grupo27.trabalhofinalpoo.gui.auxiliar;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 * Classe usada para criar um botão de noticias
 */
public class ButtonNoticia extends javax.swing.JPanel {

    /**
     * Cria o botão para uma noticia
     * @param title Titulo da noticia
     * @param body Corpo da noticia
     */
    public ButtonNoticia(String title, String body ) {
        initComponents();
        btn.setText(title);
        btn.addActionListener((ActionEvent avt) -> {
            FrameNoticia temp = new FrameNoticia(title);
            temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            temp.setVisible(true);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn = new javax.swing.JButton();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    // End of variables declaration//GEN-END:variables
}
