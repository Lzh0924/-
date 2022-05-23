package com.sxt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class Login extends JFrame implements ActionListener{
    File file1 = new File("图标.jpg");
    File file2 = new File("背景.jpg");
    public Login() {
        this.setResizable(false);//不可改变大小
        this.setTitle(" 俄 罗 斯 方 块 ");//标题
        this.setBounds(200, 100, 400, 650);//窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭程序
        this.setIconImage(new ImageIcon(file1.getAbsolutePath()).getImage());//窗口小图标
        this.setLayout(null);

        //设置按钮格式
        JButton button = new JButton("开 始 游 戏");
        button.setContentAreaFilled(false);//设置按钮透明
        button.setBorder(null);//取消边框
        button.setFont(new Font("幼圆",Font.BOLD,20));//设置字体、大小、加粗
        button.setForeground(Color.GRAY);
        Color color = new Color(236, 241, 242);
        button.setBounds(240, 260, 140, 40);
        this.add(button);

        JButton button1 = new JButton("继 续 游 戏");
        button1.setContentAreaFilled(false);//设置按钮透明
        button1.setBorder(null);//取消边框
        button1.setFont(new Font("幼圆",Font.BOLD,20));
        button1.setForeground(Color.GRAY);
        button1.setBounds(240, 300, 140, 40);
        this.add(button1);

        //设置背景
        ImageIcon background = new ImageIcon(file2.getAbsolutePath());
        JLabel Bg = new JLabel(background);
        Bg.setBounds(0, 0, 400, 600);
        this.add(Bg);

        this.setVisible(true);

        new rePlay();

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


