import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Field extends JFrame{
        
        JLabel label;
        JLabel textlabel;
        JPanel panel1;
        JPanel panel2;
        JPanel panel3;
        ImageIcon icon;
        Action upAction;
        Action downAction;
        Action leftAction;
        Action rightAction;
        
        
    Field(){
        this.setTitle("Ultimate Iwatani Quest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(680, 520);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(null);

        textlabel = new JLabel();
        textlabel.setText("Let's go dute!!");
        textlabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        textlabel.setBounds(80,0,300,100);

        panel1 = new JPanel();
        panel1.setBackground(Color.darkGray);
        panel1.setBounds(0,200,250,200);
       
        panel2 = new JPanel();
        panel2.setBackground(Color.darkGray);
        panel2.setBounds(350,0,400,220);
       
        panel3 = new JPanel();
        panel3.setBackground(Color.darkGray);
        panel3.setBounds(380,320,300,200);
       
        label = new JLabel();
        icon = new ImageIcon(getClass().getResource("mainchar.png"));
        label.setBounds(0,0,100,100);
        // label.setBackground(Color.red);
        // label.setOpaque(true);
        label.setIcon(icon);

        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        label.getInputMap().put(KeyStroke.getKeyStroke('w'), "upAction");
        label.getActionMap().put("upAction", upAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
        label.getActionMap().put("downAction", downAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
        label.getActionMap().put("leftAction", leftAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
        label.getActionMap().put("rightAction", rightAction);
        
        this.add(textlabel);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(label);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

}

    public class UpAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            label.setLocation(label.getX(), label.getY()-10);
        }}

    public class DownAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            label.setLocation(label.getX(), label.getY()+10);
        }}

    public class LeftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            label.setLocation(label.getX()-10, label.getY());
        }}

    public class RightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            label.setLocation(label.getX()+10, label.getY());
            
        }}

    
        
}
