package src;

import javax.swing.*;
import java.awt.*;

public class DrivingSimLauncher {

    private static JFrame createWindow(){
        JFrame frame = new JFrame("Driving Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(1750, 1000));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        return frame;
    }

    private static void showFrame(JFrame frame){
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = createWindow();
                showFrame(frame);
            }
        });
    }
}
