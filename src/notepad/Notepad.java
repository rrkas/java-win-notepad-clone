/*
* Author: Rohnak Agarwal
* Date: 11/10/2021
*
* JAVA version: 15
*
* */
package notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Notepad extends JFrame {

    private void loadMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        // ----------- File menu -----------
        JMenu file = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        file.add(newFile);

        JMenuItem openFile = new JMenuItem("Open");
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        file.add(openFile);

        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        file.add(saveFile);

        JMenuItem printFile = new JMenuItem("Print");
        printFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        file.add(printFile);

        JMenuItem exitFile = new JMenuItem("Exit");
        exitFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
        file.add(exitFile);

        menuBar.add(file);

        // ----------- Edit menu -----------
        JMenu edit = new JMenu("Edit");

        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        edit.add(copy);

        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        edit.add(cut);

        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        edit.add(paste);

        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        edit.add(selectAll);

        menuBar.add(edit);

        // ----------- Help menu -----------
        JMenu help = new JMenu("Help");

        JMenuItem about = new JMenuItem("About");
        help.add(about);

        menuBar.add(help);

        setJMenuBar(menuBar);
    }

    Notepad() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        loadMenuBar();
    }

    public static void main(String[] args) {
        new Notepad().setVisible(true); // by default false
    }
}
