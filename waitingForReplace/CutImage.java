package niit.ten.util.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * 进行图片裁剪
 *
 * @author chosen0ne
 */
public class CutImage extends JLabel {

    private JDialog jDialog;
    private Rectangle2D rect = new Rectangle2D.Double();//剪裁区域
    private BufferedImage image;//当前显示的图像
    private Point2D source = new Point2D.Double();//被选择区域的顶点
    private ImageStack current = new ImageStack();//当前组件显示的图像对应的操作栈
    private HashMap<String, ImageStack> imageStacks = new HashMap<String, ImageStack>();//每个图像对应的裁剪操作栈
    private Rectangle2D rectCover = new Rectangle2D.Double();//剪裁时，用于遮挡图像的矩形，这样可以区分剪裁框
    private boolean doCover = false;//指示是否进行遮掩
    private MouseHandler mouseHandler = new MouseHandler(this);
    private MouseMotionListener motionListener = new MouseMotionHandler(this);
    private Color colorCover = new Color(0.7f, 0.7f, 0.7f, 0.3f);//遮掩的颜色
    private Color colorBorder = Color.yellow;//裁剪矩形的边框的颜色

    public CutImage(JDialog jDialog, BufferedImage image) {
        this.jDialog = jDialog;
        this.image = image;

        addOrdinary(image);
        this.setIcon(new ImageIcon(image));
        this.addMouseListener(this.mouseHandler);
        this.addMouseMotionListener(motionListener);
        this.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);//设置水平左对齐
        this.setVerticalAlignment(javax.swing.SwingConstants.TOP);//设置垂直上对齐
    }

    /**
     * 删除裁剪功能
     */
    public void removeCutAbility() {
        this.removeMouseListener(mouseHandler);
        this.removeMouseMotionListener(motionListener);
    }

    /**
     * 添加裁剪功能
     */
    public void addCutAbility() {
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(motionListener);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (doCover) {//如果进行裁剪，将图像遮掩
            g2.setColor(colorCover);
            g2.fill(rectCover);
        }
        g2.setColor(Color.YELLOW);
        g2.draw(rect);
    }

    /**
     * 设置是否进行颜色覆盖
     *
     * @param f
     */
    public void setDoCover(boolean cover) {
        this.doCover = cover;
    }

    /**
     * 返回是否进行颜色覆盖
     *
     * @return
     */
    public boolean getDoCover() {
        return this.doCover;
    }

    /**
     * 返回显示的图像
     *
     * @return
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * 设置显示的图像
     *
     * @param image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * 删除所有在裁剪过程中，生成的图像
     */
    public void removeAllImages() {
        this.imageStacks.clear();
    }

    /**
     * 设置剪裁区域
     *
     * @param r
     */
    public void setSelectRegion(Rectangle2D r) {
        this.rect.setFrame(r);
    }

    /**
     * 清除剪裁区域
     */
    public void clearSelectRegion() {
        this.rect.setFrame(0, 0, 0, 0);
    }

    /**
     * 得到剪裁区域
     *
     * @return
     */
    public Rectangle2D getSelectRegion() {
        return this.rect;
    }

    /**
     * 对JLabel的方法进行覆盖，调用此方法时同时设置显示的图像指向该图片
     * 并设置覆盖矩形的大小
     *
     * @param icon
     */
    @Override
    public void setIcon(Icon icon) {
        super.setIcon(icon);
        ImageIcon imageIcon = (ImageIcon) icon;
        if (imageIcon != null) {
            this.image = this.convertImageToBuffer(imageIcon.getImage());
            rectCover = new Rectangle2D.Double(0, 0, image.getWidth(null), image.getHeight(null));
        }
    }

    /**
     * 取得裁剪矩形的左上角顶点
     *
     * @return
     */
    public Point2D getSource() {
        return this.source;
    }

    /**
     * 设置裁剪矩形的左上角的顶点
     *
     * @param p
     */
    public void setSource(Point2D p) {
        this.source = p;
    }

    /**
     * 进行裁剪
     */
    public void doCut() {
        int result = JOptionPane.showConfirmDialog(this, "进行裁剪", "提示", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (result == JOptionPane.NO_OPTION) {
            this.clearSelectRegion();
            this.repaint();
            return;
        }
        Image bImage = this.doResize(image, rect);
        current.add(bImage);
        this.setIcon(new ImageIcon(bImage));
        this.clearSelectRegion();
        this.repaint();
        this.jDialog.dispose();
    }

    /**
     * 返回点p在图像上对应的点，不能超过图像的长、宽
     *
     * @param p
     * @return
     */
    public Point2D getPoint(Point2D p) {
        if (image == null)
            return new Point2D.Double();
        int imageWidth = image.getWidth(this);
        int x = (int) (p.getX() > imageWidth ? imageWidth : p.getX());
        int imageHeight = image.getHeight(this);
        int y = (int) (p.getY() > imageHeight ? imageHeight : p.getY());
        return new Point2D.Double(x, y);
    }

    /**
     * 判断某点是否在图像内
     *
     * @param p
     * @return
     */
    public boolean inImage(Point2D p) {
        if (image == null)
            return false;
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        if (p.getX() < imageWidth && p.getY() < imageHeight)
            return true;
        return false;
    }

    /**
     * 操作栈中是否有前一个图像
     *
     * @return
     */
    public boolean hasPrevious() {
        return current.hasPrevious();
    }

    /**
     * 操作栈中是否有后一个图像
     *
     * @return
     */
    public boolean hasNext() {
        return current.hasNext();
    }

    /**
     * 设置遮掩颜色
     *
     * @param color
     */
    public void setColorCover(Color color) {
        this.colorCover = color;
    }

    /**
     * 返回遮掩颜色
     *
     * @return
     */
    public Color getColorCover() {
        return this.colorCover;
    }

    /**
     * 设置裁剪矩形的边框颜色
     *
     * @param color
     */
    public void setColorBorder(Color color) {
        this.colorBorder = color;
    }

    /**
     * 返回裁剪矩形边框的颜色
     *
     * @return
     */
    public Color getColorBorder() {
        return this.colorBorder;
    }

    /**
     * 返回操作栈中前一个图像
     */
    public Image previous() {
        Image img = current.previous();
        this.setIcon(new ImageIcon(img));
        return img;
    }

    /**
     * 返回操作栈中后一个图像
     */
    public Image next() {
        Image img = current.next();
        this.setIcon(new ImageIcon(img));
        return img;
    }

    /**
     * 为每个文件添加原始图像
     *
     * @param image
     */
    public void addOrdinary(Image image) {
        this.current.add(image);
    }

    /**
     * 设置当前操作栈current指向文件fileName对应的操作栈
     *
     * @param fileName
     */
    public void setCurrent(String fileName) {
        if (!imageStacks.containsKey(fileName))
            imageStacks.put(fileName, new ImageStack());
        current = imageStacks.get(fileName);
    }

    /**
     * 返回图像file在操作栈对应的当前图像
     *
     * @param file
     * @return
     */
    public Image getCurrentImage(String file) {
        return imageStacks.get(file).getCurrent();
    }

    private BufferedImage convertImageToBuffer(Image pic) {
        BufferedImage bufferedImage = new BufferedImage(pic.getWidth(null), pic.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        g.drawImage(pic, 0, 0, null);
        g.dispose();
        return bufferedImage;
    }

    /**
     * 对图像进行裁剪
     *
     * @param image
     * @param rect  裁剪的区域
     * @return
     */
    public Image doResize(BufferedImage image, Rectangle2D rect) {
        return image.getSubimage((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
    }

    /**
     * 图像操作栈
     *
     * @author chosen0ne
     */
    private class ImageStack {
        private Vector<Image> vec = new Vector<Image>();
        private int index = -1;

        public boolean hasNext() {
            return index < vec.size() - 1;
        }

        public boolean hasPrevious() {
            return index > 0;
        }

        public Image next() {
            return vec.get(++index);
        }

        public Image previous() {
            return vec.get(--index);
        }

        public void add(Image i) {
            vec.add(i);
            index++;
        }

        public Image getCurrent() {
            return vec.get(index);
        }
    }

    /**
     * @author chosen0ne
     */
    public class MouseHandler extends MouseAdapter {
        private CutImage component;

        public MouseHandler(CutImage l) {
            this.component = l;
        }

        /**
         * 当鼠标按下，设置裁剪的起点和并设置进行遮掩
         *
         * @param e
         */
        @Override
        public void mousePressed(MouseEvent e) {
            this.component.setSource(component.getPoint(e.getPoint()));
            this.component.setDoCover(true);
        }

        /**
         * 当释放鼠标，进行图像的裁剪并设置不进行遮掩
         *
         * @param e
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            if (component.inImage(e.getPoint()) && component.getSelectRegion().getWidth() != 0
                    && component.getSelectRegion().getHeight() != 0) {
                this.component.doCut();
                this.component.setDoCover(false);
            }
        }
    }

    /**
     * @author chosen0ne
     */
    class MouseMotionHandler implements MouseMotionListener {
        private CutImage component;

        public MouseMotionHandler(CutImage l) {
            this.component = l;
        }

        /**
         * 拖拽时，设置裁剪矩形的大小
         *
         * @param e
         */
        @Override
        public void mouseDragged(MouseEvent e) {
            Rectangle2D rect = getRectangle(component.getSource(), component.getPoint(e.getPoint()));
            this.component.setSelectRegion(rect);
            this.component.repaint();
        }

        public void mouseMoved(MouseEvent e) {
        }

        private Rectangle2D getRectangle(Point2D p1, Point2D p2) {
            int x = (int) Math.min(p1.getX(), p2.getX());
            int y = (int) Math.min(p1.getY(), p2.getY());
            double h = Math.abs(p1.getY() - p2.getY());
            double w = Math.abs(p1.getX() - p2.getX());
            return new Rectangle2D.Double(x, y, w, h);
        }
    }


}
