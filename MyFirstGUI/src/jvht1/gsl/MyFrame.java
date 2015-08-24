/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvht1.gsl;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


/**
 *
 * @author Administrator
 */
public class MyFrame extends JFrame implements ActionListener,MouseListener,MouseWheelListener ,KeyListener,FocusListener{
    
    JButton but , btnShow;
    JTextField txt1;
    
    public static void main(String[] args) {
        
        MyFrame mf = new MyFrame();
        mf.initComponent();
        
        JFrame jf = new JFrame();        
        
        jf.setTitle("New Frame");
        jf.setSize(300, 200);
        jf.setLocation(400, 300);
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }
    
    private void initComponent(){
        JPanel jp1 = new JPanel(); // Create a panel object
        jp1.setLayout(null); 
        jp1.setSize(350,250);
        jp1.setBackground(java.awt.Color.LIGHT_GRAY);// Without importing the package;
        
        txt1 = new JTextField();
        int x = 100, y = 20, w = 150, h = 20;
        
        //Create button.
        but = new JButton("Submit");
        but.setBounds(10, 40, w, h);
        but.addActionListener(this);
        
        //Create second button
        btnShow = new JButton("Show");
        btnShow.setBounds(170, 40, w, h);
        btnShow.addActionListener(this);
        btnShow.addMouseListener(this);
        jp1.addMouseWheelListener(this);
        
        JButton jb = new JButton("Single action Button");
        jb.setBounds(200,100,w,h);
        
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, txt1.getText());
            }
            
        });
        
//        jp1.addAdjustmentListener(new AdjustmentListener() {
//
//            @Override
//            public void adjustmentValueChanged(AdjustmentEvent e) {
//                System.out.println("JScrollBar's current value = " + scrollBar.getValue());
//            }
//
//            @Override
//            public void adjustmentValueChanged(AdjustmentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
        
        txt1.setBounds(x, y, w, h);
        txt1.addKeyListener(this );
        txt1.addFocusListener(this);
        btnShow.addFocusListener(this);
        super.setTitle("My Frame");
        Container c = super.getContentPane();
        c.setLayout(null);
        
        super.setSize(400, 300);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        jp1.add(txt1);
        jp1.add (but);
        jp1.add (btnShow);
        jp1.add(jb);
                
        jp1.setVisible(true);
        c.add(jp1);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == but){
            JOptionPane.showMessageDialog(null, "Button Submit Clicked");
        }else if(e.getSource() == btnShow){
            JOptionPane.showMessageDialog(null, txt1.getText());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)){
            JOptionPane.showMessageDialog(null, "Right Button Clicked");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        btnShow.setLocation(btnShow.getX()+50, btnShow.getY()+50);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        btnShow.setLocation(btnShow.getX()-50, btnShow.getY()-50);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
       System.out.println(e.getWheelRotation());
       but.setLocation(but.getX() + e.getWheelRotation(), but.getY()+0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        btnShow.setBackground(Color.red);
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        btnShow.setBackground(Color.GREEN);
    }
    
   
}
