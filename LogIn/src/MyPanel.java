import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {

    JFrame frame = new JFrame();
    JButton iwatani = new JButton("¡¡¡ I W A T A N I !!!");

    final int PANEL_WIDHT = 500;
    final int PANEL_HEIGHT = 500;

    Image icon;
    Image background;
    Timer timer;

    int xVelocity = 3;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    MyPanel() {

        this.add(iwatani);
        this.setPreferredSize(new Dimension(PANEL_WIDHT, PANEL_HEIGHT));
        this.setBackground(Color.black);

        icon = new ImageIcon("src/badbunny.png").getImage();
        background = new ImageIcon("src/background.png").getImage();
        timer = new Timer(10, this);
        timer.start();

        iwatani.setBounds(125, 300, 200, 25);
        iwatani.setForeground(Color.red);
        // iwatani.setFont(new Font("MV Boli", Font.BOLD, 25));
        iwatani.setFocusable(false);
        iwatani.addActionListener(this);

    }

    /*
     * public void launchGame() {
     * 
     * iwatani.setBounds(125, 200, 200, 25);
     * iwatani.setFocusable(false);
     * iwatani.addActionListener(this);
     * 
     * frame.add(iwatani);
     * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     * frame.setSize(420, 420);
     * frame.setLayout(null);
     * frame.setLocationRelativeTo(null);
     * frame.setVisible(true);
     * }
     */

    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(background, 0, 0, null);
        g2D.drawImage(icon, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (x >= PANEL_WIDHT - icon.getWidth(null) || x < 0) {
            xVelocity = xVelocity * (-1);
        }
        x = x + xVelocity;

        if (y >= PANEL_HEIGHT - icon.getHeight(null) || y < 0) {
            yVelocity = yVelocity * (-1);
        }
        y = y + yVelocity;
        repaint();

        if (e.getSource() == iwatani) {
            frame.dispose();
            IDnPassword iPassword = new IDnPassword();
            new LoginPage(iPassword.getLoginInfo());
        }
    }
}
