package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Difficulty extends JFrame implements ActionListener,Runnable {
    File file1 = new File("图标.jpg");
    File file2 = new File("背景.jpg");
    public Difficulty(){
        this.setResizable(false);
        this.setTitle(" 选 择 难 度 ");
        this.setBounds(250, 100, 400, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(file1.getAbsolutePath()).getImage());
        this.setLayout(null);

        JButton button1 = new JButton("简  单");
        button1.setContentAreaFilled(false);//设置按钮透明
        button1.setBorder(null);//取消边框
        button1.setFont(new Font("幼圆",Font.BOLD,20));
        button1.setForeground(Color.GRAY);
        //Color color = new Color(236, 241, 242);
        button1.setBounds(250, 270, 100, 30);
        this.add(button1);

        JButton button2 = new JButton("一  般");
        button2.setContentAreaFilled(false);//设置按钮透明
        button2.setBorder(null);//取消边框
        button2.setFont(new Font("幼圆",Font.BOLD,20));
        button2.setForeground(Color.GRAY);
        button2.setBounds(250, 300, 100, 30);
        this.add(button2);

        JButton button3 = new JButton("困  难");
        button3.setContentAreaFilled(false);//设置按钮透明
        button3.setBorder(null);//取消边框
        button3.setFont(new Font("幼圆",Font.BOLD,20));
        button3.setForeground(Color.GRAY);
        button3.setBounds(250, 330, 100, 30);
        this.add(button3);

        ImageIcon background = new ImageIcon(file2.getAbsolutePath());
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
            Tertris.upbond = 350;
            Tertris.rate = 0.5;
        }
        else if(bt.equals("一  般")){
            Tertris.upbond = 250;
            Tertris.rate = 0.75;
        }
        else if(bt.equals("困  难")){
            Tertris.upbond = 150;
            Tertris.rate = 1;
        }

        tertris.game_begin();
    }
}
