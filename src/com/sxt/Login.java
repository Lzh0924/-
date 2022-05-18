package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class Login extends JFrame implements ActionListener{
    public Login() {
        this.setResizable(false);
        this.setTitle("Login Interface");
        this.setBounds(200, 100, 400, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("D:\\JAVA project\\FinalProject（俄罗斯方块）\\样品\\Tertris（仅游戏）\\src\\图标.jpg").getImage());
        this.setLayout(null);

        JButton button = new JButton("开 始 游 戏");
        button.setFont(new Font("华文彩云",Font.BOLD,20));
        Color color = new Color(236, 241, 242);
        button.setBackground(color);
        button.setBounds(200, 280, 150, 50);
        this.add(button);

        JButton button1 = new JButton("继 续 游 戏");
        button1.setFont(new Font("华文彩云",Font.BOLD,20));
        Color color1 = new Color(236, 241, 242);
        button1.setBackground(color1);
        button1.setBounds(200, 380, 150, 50);
        this.add(button1);


        ImageIcon background = new ImageIcon("D:\\JAVA project\\FinalProject（俄罗斯方块）\\样品\\Tertris（仅游戏）\\src\\背景.jpg");
        JLabel Bg = new JLabel(background);
        Bg.setBounds(0, 0, 400, 600);
        this.add(Bg);

        this.setVisible(true);

        button.addActionListener(this);
        button1.addActionListener(this);
    }

    /*public void  run(){
        Tertris tertris = new Tertris();
        tertris.isrunning=true;
        tertris.game_begin();

    }

     */
    String bt1;
    @Override
    public void actionPerformed(ActionEvent e) {
        bt1 = e.getActionCommand();

        Thread t1 = new Thread(this::run1);
        t1.start();
        this.setVisible(false);
        //new Thread(this).start();



        //tertris.game_begin();

        //下面不用管，是之前实验用的程序，和游戏无关。

         /*
        JDialog frame = new JDialog();//构造一个新的JFrame，作为新窗口。
        frame.setBounds(// 让新窗口与SwingTest窗口示例错开50像素。
                new Rectangle(
                        (int) this.getBounds().getX() + 50,
                        (int) this.getBounds().getY() + 50,
                        (int) this.getBounds().getWidth(),
                        (int) this.getBounds().getHeight()
                )
        );
        JLabel jl = new JLabel();// 注意类名别写错了。
        frame.getContentPane().add(jl);
        jl.setText("这是新窗口");
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setHorizontalAlignment(JLabel.CENTER);// 注意方法名别写错了。
        // 参数 APPLICATION_MODAL：阻塞同一 Java 应用程序中的所有顶层窗口（它自己的子层次
        frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);    // 设置模式类型。
        frame.setVisible(true);

          */
    }
    public void run1() {
        if(Objects.equals(bt1, "开 始 游 戏")){
            Difficulty difficulty = new Difficulty();
        }
        else if(Objects.equals(bt1, "继 续 游 戏")){
            try {
                Tertris tertris = new Tertris();
                Arr.load1();
                tertris.game_begin();
            } catch (IOException ex) {
                 ex.printStackTrace();
            }
        }
    }
}


