import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePage implements ActionListener {

    JFrame frame = new JFrame();
    JButton startBattle = new JButton("START BATTLE");

    WelcomePage(String userID) {

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setBounds(90, 10, 300, 35);
        welcomeLabel.setForeground(new Color(0x123456));
        welcomeLabel.setFont(new Font("MV Boli", Font.BOLD, 25));
        welcomeLabel.setText("Welcome" + " " + userID + " " + "sensei");

        // ImageIcon iwataniIcon = new ImageIcon("src/iwataniIcon.png");
        JLabel iwataniLabel = new JLabel();
        // iwataniLabel.setIcon(iwataniIcon);
        iwataniLabel.setBackground(Color.red);
        iwataniLabel.setVerticalAlignment(JLabel.CENTER);
        iwataniLabel.setHorizontalAlignment(JLabel.CENTER);
        iwataniLabel.setBounds(100, 100, 200, 200);

        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(Color.magenta);
        iconPanel.setBounds(10, 60, 380, 200);
        iconPanel.setLayout(new BorderLayout());

        startBattle.setBounds(110, 300, 200, 25);
        startBattle.setFocusable(false);
        startBattle.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(welcomeLabel);
        frame.add(startBattle);
        frame.add(iconPanel);
        iconPanel.add(iwataniLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startBattle) {
            frame.dispose();
            new GamePanel();
        }
    }

}
