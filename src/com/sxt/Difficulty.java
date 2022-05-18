package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficulty extends JFrame implements ActionListener,Runnable {
    public Difficulty(){
        this.setResizable(false);
        this.setTitle("Login Interface");
        this.setBounds(300, 150, 400, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("D:\\JAVA project\\FinalProject（俄罗斯方块）\\样品\\Tertris（仅游戏）\\src\\图标.jpg").getImage());
        this.setLayout(null);

        JButton button1 = new JButton("简  单");
        Color color = new Color(236, 241, 242);
        button1.setBackground(color);
        button1.setBounds(250, 230, 100, 30);
        this.add(button1);

        JButton button2 = new JButton("一  般");
        button2.setBackground(color);
        button2.setBounds(250, 280, 100, 30);
        this.add(button2);

        JButton button3 = new JButton("困  难");
        button3.setBackground(color);
        button3.setBounds(250, 330, 100, 30);
        this.add(button3);

        ImageIcon background = new ImageIcon("D:\\JAVA project\\FinalProject（俄罗斯方块）\\样品\\Tertris（仅游戏）\\src\\背景.jpg");
        JLabel Bg = new JLabel(background);
        Bg.setBounds(0, 0, 400, 600);
        this.add(Bg);

        this.setVisible(true);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    String bt;
    @Override
    public void actionPerformed(ActionEvent e) {

        bt = e.getActionCommand();

        new Thread(this).start();
        this.setVisible(false);
    }


    public void run() {

        Tertris tertris = new Tertris();
        Tertris.isrunning =true;

        if(bt.equals("简  单")){
            Tertris.upbond = 700;
            Tertris.rate = 0.5;
        }
        else if(bt.equals("一  般")){
            Tertris.upbond = 500;
            Tertris.rate = 0.75;
        }
        else if(bt.equals("困  难")){
            Tertris.upbond = 300;
            Tertris.rate = 1;
        }

        tertris.game_begin();
    }
}
