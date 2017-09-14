package com.company.test;

import com.company.ui.Login;

import java.awt.*;

public class GetLookNFeel {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
