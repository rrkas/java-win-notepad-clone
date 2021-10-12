/*
 * Author: Rohnak Agarwal
 * Email: rrka79wal@gmal.com
 * Date: 11/10/2021
 *
 * JAVA version: 15
 *
 * */

package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

public class About extends JFrame implements ActionListener {
    About() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = 700, screenHeight = 600;
        int startx = (screenSize.width - screenWidth) / 2, starty = (screenSize.height - screenHeight) / 2;
        setBounds(startx, starty, screenWidth, screenHeight);
        setLayout(null);

        int iconSize = 100;

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("assets/icons/Notepad.png"));
        Image image = imageIcon.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.setBounds((screenWidth - iconSize) / 2, 40, iconSize, iconSize);
        add(label);

        JLabel label1 = new JLabel(
                "<html>" +
                        "Rohnak Agarwal<br>" +
                        "This is a practice project for JAVA Swing." +
                        "</html>"
        );
        label1.setBounds(50, iconSize + 40, 500, 100);
        label1.setFont(new Font("SAN_SARIF", Font.PLAIN, 18));
        add(label1);

        class OpenUrlAction implements ActionListener {

            final URI uri;

            OpenUrlAction(URI uri) {
                this.uri = uri;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(uri);
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                    }
                }
            }
        }

        try {
            final URI uri = new URI("mailto:rrka79wal@gmail.com");
            JButton mailButton = new JButton("Contact");
            mailButton.setToolTipText(uri.toString());
            mailButton.addActionListener(new OpenUrlAction(uri));
            mailButton.setBounds(50, iconSize + 150, 100, 30);
            add(mailButton);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        JButton ok = new JButton("OK");
        ok.setBounds(580, 500, 80, 25);
        ok.addActionListener(this);
        add(ok);
    }

    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
