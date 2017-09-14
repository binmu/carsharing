package com.company.test;

import com.company.ui.editCarInformation.EditCarInfPage;

import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        EditCarInfPage frame = new EditCarInfPage(1);
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


}
