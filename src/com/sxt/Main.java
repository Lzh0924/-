package com.sxt;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {

        try {
            Login m=new Login();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //m.setVisible(true);


    }
}