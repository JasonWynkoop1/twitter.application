package twitter.api;

import javax.swing.*;
import java.awt.*;

public class SimplerTwitterGUI extends JFrame {

    private JTextArea jTextPane = new JTextArea();

    public SimplerTwitterGUI() {
        setTitle("SimplerTwitter v0.0.1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300,500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(jTextPane, BorderLayout.NORTH);
        setVisible(true);
    }

    public void addText(String str){
        jTextPane.setText("FUCK");
    }

}
