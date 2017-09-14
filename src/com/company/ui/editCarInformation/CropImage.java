package com.company.ui.editCarInformation;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CropImage extends JDialog implements MouseListener, MouseMotionListener {
    int drag_status = 0, c1, c2, c3, c4, w, h;
    private File file;
    private ImagePanel im;
    private JButton sure;

    public CropImage(File pic) {
        setModal(true);
        file = pic;
        try {
            Thumbnails.of(file)
                    .size(400, 400)
                    .keepAspectRatio(false)
                    .toFile("C:\\temp.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        im = new ImagePanel(file.getPath());
        iniButton();
        add(im);
        setSize(400, 400);
        addMouseListener(this);
        addMouseMotionListener(this);
        setLocationRelativeTo(null);
    }

    private void iniButton() {
        sure = new JButton("È·¶¨");
        sure.setBounds(140, 280, 84, 40);
        sure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage img = null;
                try {
                    img = Thumbnails.of("C:\\temp.jpg")
                            .sourceRegion(c1, c2, w, h)
                            .size(w, h)
                            .keepAspectRatio(true)
                            .asBufferedImage();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                File save_path = new File("C:\\temp2.jpg");
                try {
                    ImageIO.write(img, "JPG", save_path);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("Cropped image saved successfully.");
                dispose();
            }
        });
        sure.setVisible(false);
        im.add(sure);
    }

    public void draggedScreen() throws Exception {
        w = c1 - c3;
        h = c2 - c4;
        w = w * -1;
        h = h * -1;
        sure.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        repaint();
        c1 = arg0.getX();
        c2 = arg0.getY();
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        repaint();
        if (drag_status == 1) {
            c3 = arg0.getX();
            c4 = arg0.getY();
            try {
                draggedScreen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        repaint();
        drag_status = 1;
        c3 = arg0.getX();
        c4 = arg0.getY();
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

    public void paint(Graphics g) {
        super.paint(g);
        int w = c1 - c3;
        int h = c2 - c4;
        w = w * -1;
        h = h * -1;
        if (w < 0)
            w = w * -1;
        g.drawRect(c1, c2, w, h);
    }
}