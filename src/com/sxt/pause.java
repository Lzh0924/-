package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class pause extends JFrame implements ActionListener,Runnable {
    public pause(){
        this.setResizable(false);
        this.setTitle("Pause Interface");
        this.setBounds(300, 150, 400, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        JButton button1 = new JButton("继 续 游 戏");
        Color color = new Color(236, 241, 242);
        button1.setBackground(color);
        button1.setBounds(250, 230, 100, 30);
        this.add(button1);

        JButton button2 = new JButton("保 存 游 戏");
        button2.setBackground(color);
        button2.setBounds(250, 280, 100, 30);
        this.add(button2);

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
