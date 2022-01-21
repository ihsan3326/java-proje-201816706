import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        JFrame pencere = new JFrame();
        pencere.setTitle("Yetenek Testi");
        pencere.setSize(1050, 560);
        pencere.setLocation(100, 75);
        pencere.setResizable(false);
        pencere.setFocusable(false);


        Run run = new Run();
        run.requestFocus();
        run.addKeyListener(run);
        run.setFocusable(true);
        run.setFocusTraversalKeysEnabled(false);

        pencere.add(run);
        pencere.setVisible(true);
        pencere.setDefaultCloseOperation(pencere.EXIT_ON_CLOSE);


    }
}
