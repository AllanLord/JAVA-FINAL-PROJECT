import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GamePanel {

    JFrame frame = new JFrame();
    JLabel battleLabel = new JLabel();

    GamePanel() {

        battleLabel.setBounds(50, 150, 350, 35);
        battleLabel.setForeground(new Color(0x123456));
        battleLabel.setFont(new Font("MV Boli", Font.BOLD, 25));
        battleLabel.setText("Here goes Jumpei's Code");

        frame.add(battleLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
