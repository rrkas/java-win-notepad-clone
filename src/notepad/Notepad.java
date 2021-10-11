/*
 * Author: Rohnak Agarwal
 * Date: 11/10/2021
 *
 * JAVA version: 15
 *
 * */
package notepad;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {

    JTextArea textArea;
    JScrollPane scrollPane;

    // with shortcut key
    private void createMenuItem(JMenu menu, String menuItemName, Integer keyEvent, Integer actionEvent) {
        JMenuItem menuItem = new JMenuItem(menuItemName);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(keyEvent, actionEvent));
        menuItem.addActionListener(this);
        menu.add(menuItem);
    }

    // without shortcut key
    private void createMenuItem(JMenu menu, String menuItemName) {
        JMenuItem menuItem = new JMenuItem(menuItemName);
        menuItem.addActionListener(this);
        menu.add(menuItem);
    }

    private void loadMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // ----------- File menu -----------
        JMenu file = new JMenu("File");

        createMenuItem(file, "New", KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK);
        createMenuItem(file, "Open", KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK);
        createMenuItem(file, "Save", KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
        createMenuItem(file, "Print", KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK);
        createMenuItem(file, "Exit", KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK);

        menuBar.add(file);

        // ----------- Edit menu -----------
        JMenu edit = new JMenu("Edit");

        createMenuItem(edit, "Copy", KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK);
        createMenuItem(edit, "Cut", KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK);
        createMenuItem(edit, "Paste", KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK);
        createMenuItem(edit, "Select All", KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK);

        menuBar.add(edit);

        // ----------- Help menu -----------
        JMenu help = new JMenu("Help");

        createMenuItem(help, "About");

        menuBar.add(help);

        setJMenuBar(menuBar);
    }

    Notepad() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        loadMenuBar();

        textArea = new JTextArea();
        textArea.setFont(new Font("SAN_SARIF", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Notepad().setVisible(true); // by default false
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "New": {
                textArea.setText("");
                break;
            }
            case "Open": {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter txtFilter = new FileNameExtensionFilter(
                        "Only .txt files",
                        "txt"
                );
                fileChooser.addChoosableFileFilter(txtFilter);
                int action = fileChooser.showOpenDialog(this);
                if(action!=JFileChooser.APPROVE_OPTION){
                    return;
                }
                File file = fileChooser.getSelectedFile();
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    textArea.read(reader, null);

                }catch (Exception ex){
                    System.out.println(ex.toString());
                }
                break;
            }
            case "Save": {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setApproveButtonText("Save");
                int action = fileChooser.showOpenDialog(this);
                if(action != JFileChooser.APPROVE_OPTION){
                    return;
                }
                String filename = fileChooser.getSelectedFile().toString();
                if(!filename.endsWith(".txt")){
                    filename += ".txt";
                }
                File file = new File(filename);
                BufferedWriter writer = null;
                try{
                    writer = new BufferedWriter(new FileWriter(file));
                    textArea.write(writer);
                }catch (Exception ex){
                    System.out.println(ex.toString());
                }
                break;
            }
            case "Print":{
                try {
                    textArea.print();
                }catch (Exception ex){
                    System.out.println(ex.toString());
                }
                break;
            }
            case "Exit":{
                System.exit(0);
            }
            default: {
                break;
            }
        }
    }
}
