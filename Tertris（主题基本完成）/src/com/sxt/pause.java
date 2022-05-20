package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class pause extends JFrame implements ActionListener,Runnable {
    File file1 = new File("图标.jpg");
    File file2 = new File("背景.jpg");
    public pause(){
        this.setResizable(false);
        this.setTitle(" 暂 停 中 ");
        this.setBounds(300, 150, 400, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(file1.getAbsolutePath()).getImage());
        this.setLayout(null);

        JButton button1 = new JButton("继 续 游 戏");
        button1.setContentAreaFilled(false);//设置按钮透明
        button1.setBorder(null);//取消边框
        button1.setFont(new Font("幼圆",Font.BOLD,20));
        button1.setForeground(Color.GRAY);
        //Color color = new Color(236, 241, 242);
        button1.setBounds(250, 260, 140, 30);
        this.add(button1);

        JButton button2 = new JButton("保 存 游 戏");
        button2.setContentAreaFilled(false);//设置按钮透明
        button2.setBorder(null);//取消边框
        button2.setFont(new Font("幼圆",Font.BOLD,20));
        button2.setForeground(Color.GRAY);
        button2.setBounds(250, 300, 140, 30);
        this.add(button2);

        ImageIcon background = new ImageIcon(file2.getAbsolutePath());
        JLabel Bg = new JLabel(background);
        Bg.setBounds(0, 0, 400, 600);
        this.add(Bg);

        this.setVisible(true);
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    String bt;
    @Override
    public void actionPerformed(ActionEvent e) {

        bt = e.getActionCommand();

        new Thread(this).start();
    }


    public void run() {

        Tertris.isrunning =true;

        if(bt.equals("继 续 游 戏")){
            Tertris.pause_times++;
//            Tertris.game_pause = false;
//            Tertris.pause_times = 0;
//            Tertris.label1.setText("游戏状态: 正在进行中!");
//            Tertris.game_begin();
            this.setVisible(false);
            if (Tertris.pause_times == 2) {
                Tertris.game_pause = false;
                Tertris.pause_times = 0;
                Tertris.label1.setText("游戏状态: 正在进行中!");
            }
        }
        else if(bt.equals("保 存 游 戏")){
            try {
                Arr.save1();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
