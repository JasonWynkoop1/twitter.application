package twitter.api;

import javax.swing.*;
import java.awt.*;

public class SimplerTwitterGUI extends JFrame {

    private JTextPane jTextPane = new JTextPane();

    public SimplerTwitterGUI() {
        setTitle("SimplerTwitter v1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300,500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(jTextPane, BorderLayout.NORTH);
        setVisible(true);
    }

    public void setText(String str){
        jTextPane.setText("FUCK");
    }

}
