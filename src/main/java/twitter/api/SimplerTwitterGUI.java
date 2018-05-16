package twitter.api;

import javax.swing.*;
import java.awt.*;

public class SimplerTwitterGUI extends JFrame {

    private JTextArea jTextArea;

    public SimplerTwitterGUI() {
        setTitle("SimplerTwitter v0.0.1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300,500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        add(jTextArea, BorderLayout.NORTH);
        setVisible(true);
    }

    public void addText(String str){
        jTextArea.append(str + "\n");
    }

}
