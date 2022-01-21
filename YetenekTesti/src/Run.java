import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Run extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(5, this);

    public int sure = 0;
    private int top = 10;
    private int ucak_konum_y = 225;
    private int ucak_hareket = 20;
    private int kova_konum_x = 745;
    private int kova_hareket = 20;
    private int ates1X = 490;
    private int ates1Y = 300;
    private double atesHareket = 2.5;
    private int ates2X = 300;
    private int ates2Y = 100;
    private int ates3X = 200;
    private int ates3Y = 200;
    private int top1X = 700;
    private int top1Y = 0;
    private int top2X = 800;
    private int top2Y = 250;
    private int puan = 0;


    private BufferedImage png;
    private BufferedImage kova_png;

    public int sayac() {

        if (new Rectangle(10, ucak_konum_y, 50, 50).intersects(ates1X, ates1Y, 20, 20)) {
            ates1X = 500;
            ates1Y = (int) (Math.random() * 480 + 10);
            puan = puan - 1;
        }
        if (new Rectangle(10, ucak_konum_y, 50, 50).intersects(ates2X, ates2Y, 20, 20)) {
            ates2X = 500;
            ates2Y = (int) (Math.random() * 480 + 10);
            puan = puan - 1;
        }
        if (new Rectangle(10, ucak_konum_y, 50, 50).intersects(ates3X, ates3Y, 20, 20)) {
            ates3X = 500;
            ates3Y = (int) (Math.random() * 480 + 10);
            puan = puan - 1;
        }
        if (new Rectangle(kova_konum_x, 460, 50, 50).intersects(top1X, top1Y, 20, 20)) {
            top1Y = 0;
            top1X = (int) (Math.random() * 480 + 520);
            puan = puan + 1;
        }
        if (new Rectangle(kova_konum_x, 460, 50, 50).intersects(top2X, top2Y, 20, 20)) {
            top2Y = 0;
            top2X = (int) (Math.random() * 480 + 520);
            puan = puan + 1;
        }

        return puan;
    }


    public Run() throws IOException {

        try {
            png = ImageIO.read(new FileImageInputStream(new File("Başlıksız-1.png")));
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setBackground(Color.BLACK);
        png = ImageIO.read(new FileImageInputStream(new File("Başlıksız-1.png")));
        kova_png = ImageIO.read(new FileImageInputStream(new File("kova.png")));

        timer.start();

    }

    @Override
    public void paint(Graphics g) {

        super.paintComponent(g);
        sure += 1;

        g.setColor(Color.GRAY);

        g.fillRect(510, 0, 10, 520);
        g.fillRect(0, 0, 1030, 10);
        g.fillRect(0, 510, 1030, 10);
        g.fillRect(0, 0, 10, 520);
        g.fillRect(1020, 0, 10, 520);

        g.setColor(Color.RED);

        g.fillOval(ates1X, ates1Y, 20, 20);
        g.fillOval(ates2X, ates2Y, 20, 20);
        g.fillOval(ates3X, ates3Y, 20, 20);

        g.setColor(Color.LIGHT_GRAY);

        g.fillOval(top1X, top1Y, 20, 20);
        g.fillOval(top2X, top2Y, 20, 20);



        g.drawImage(png, 10, ucak_konum_y, 50, 50, this);
        repaint();
        g.drawImage(kova_png, kova_konum_x, 460, 50, 50, this);

        sayac();

        if (sure == 60000) {

            timer.stop();

            String mesaj = "Süreniz Doldu\nPuanınız: ";
            JOptionPane.showMessageDialog(this, mesaj + " " + puan);
            System.exit(0);

        }


    }

    @Override
    public void repaint(Rectangle r) {
        super.repaint(r);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ates1X -= atesHareket;
        ates2X -= atesHareket;
        ates3X -= atesHareket;
        top1Y += atesHareket;
        top2Y += atesHareket;

        if (ates1X <= 10) {
            ates1X = 490;
            ates1Y = (int) (Math.random() * 480 + 10);
        }

        if (ates2X <= 10) {
            ates2X = 490;
            ates2Y = (int) (Math.random() * 480 + 10);
        }
        if (ates3X <= 10) {
            ates3X = 490;
            ates3Y = (int) (Math.random() * 480 + 10);
        }
        if (top1Y >= 490) {
            top1Y = 10;
            top1X = (int) (Math.random() * 480 + 520);
        }
        if (top2Y >= 490) {
            top2Y = 10;
            top2X = (int) (Math.random() * 480 + 520);
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int a = e.getKeyCode();
        if (a == KeyEvent.VK_LEFT) {
            if (kova_konum_x <= 520) {
                kova_konum_x = 520;
            } else {
                kova_konum_x = kova_konum_x - kova_hareket;
            }

        } else if (a == KeyEvent.VK_RIGHT) {
            if (kova_konum_x >= 970) {
                kova_konum_x = 970;
            } else {
                kova_konum_x = kova_konum_x + kova_hareket;
            }
        }


        if (a == KeyEvent.VK_UP) {

            if (ucak_konum_y <= 10) {
                ucak_konum_y = 10;
            } else {
                ucak_konum_y = ucak_konum_y - ucak_hareket;
            }

        } else if (a == KeyEvent.VK_DOWN) {


            if (ucak_konum_y >= 460) {
                ucak_konum_y = 460;
            } else {
                ucak_konum_y = ucak_konum_y + ucak_hareket;
            }

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
