package com.LlanquihueTour.ui;


import javax.swing.*;

/**
 * Punto de entrada de la aplicacion Llanquihue Tour.
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScreenPrincipal().setVisible(true);
            }
        });
    }
}
