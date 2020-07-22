package com.jeremy.findIP;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class FindIPAddress extends Frame implements ActionListener {

    public static void main(String[] args) {
        new FindIPAddress();
    }

    JLabel l = new JLabel("Enter the domain name: ");
    JTextField tf = new JTextField();
    JLabel l2 = new JLabel();
    JButton b = new JButton("Find the IP");
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    Color customColor = new Color(115, 150, 158);
    Color customColor2 = new Color(57, 75, 87);
    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    FindIPAddress() {

        p.setBorder(new EmptyBorder(50, 50, 50, 50));

        p.add(l);
        l.setAlignmentX(CENTER_ALIGNMENT);
        l.setForeground(customColor2.darker());

        p.add(Box.createRigidArea(new Dimension(0, 10)));

        p.add(tf);
        tf.setMaximumSize(new Dimension(250, 25));
        tf.setBackground(Color.gray.brighter());
        tf.setBorder(javax.swing.BorderFactory.createLineBorder(customColor2.darker()));
        tf.setForeground(customColor2.darker());
        tf.setHorizontalAlignment(JTextField.CENTER);
        p.add(Box.createRigidArea(new Dimension(0, 10)));

        p.add(l2);
        l2.setAlignmentX(CENTER_ALIGNMENT);
        l2.setForeground(customColor2.darker());

        p.add(Box.createRigidArea(new Dimension(0, 10)));

        p.add(b);
        b.addActionListener(this);
        b.setAlignmentX(CENTER_ALIGNMENT);
        b.setBackground(customColor2);
        b.setForeground(Color.white);
        b.setBorder(javax.swing.BorderFactory.createLineBorder(customColor2.darker()));
        b.setMaximumSize(new Dimension(100, 30));
        b.setCursor(cursor);
        b.setFocusPainted(false);

        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBackground(customColor);

        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,250);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    public void actionPerformed (ActionEvent e){
        try {
            String host = tf.getText();
            String ip = java.net.InetAddress.getByName(host).getHostAddress();
            if (host.matches("\\d+")) {
                l2.setText("This website doesn't exist");
            } else if (host.length() <= 15) {
                l2.setText("IP of " + host + " is: " + ip);
            } else if ((host.length() > 15) && (host.length() <= 25)) {
                f.setSize(600,250);
                l2.setText("IP of " + host + " is: " + ip);
            } else if ((host.length() > 25) && (host.length() <= 40)) {
                f.setSize(700, 250);
                l2.setText("IP of " + host + " is: " + ip);
            } else if (host.length() > 40) {
                f.setSize(900,250);
                l2.setText("IP of " + host + " is: " + ip);
                }
        } catch (Exception ex) {
            l2.setText("This website doesn't exist");
        }
    }
}