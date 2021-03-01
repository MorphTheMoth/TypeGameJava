package typinggame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * lmao
 *
 * @author Federico
 */
public class TypingGame extends JPanel implements KeyListener, Runnable {

    private static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vel aliquam ex. Fusce eu sapien tempus, varius erat eget, aliquam magna. Curabitur quis velit id mi ornare molestie quis a ipsum. Etiam ullamcorper ornare feugiat. Fusce aliquet pharetra felis eu pharetra. Praesent pellentesque pellentesque ligula vel fermentum. Fusce placerat molestie ante, rhoncus laoreet lectus ultricies eget. Fusce quis purus lacus. Donec eget sagittis nibh, quis iaculis augue. Pellentesque in lectus ut sapien venenatis pellentesque id sed quam.\n"
            + "\n"
            + "Curabitur tempor consequat nisl, ut pretium ligula rhoncus nec. Donec feugiat iaculis justo, vel consectetur quam egestas quis. Cras sodales non orci at aliquam. Praesent vulputate, magna et bibendum maximus, lectus metus finibus justo, id egestas nisi velit ut tellus. Vivamus eget mauris sit amet lacus iaculis euismod a non ex. Pellentesque consequat sem vitae felis aliquam, sit amet vehicula dolor dignissim. Aenean vel odio sagittis, placerat ligula in, vulputate mi. In pretium tristique sodales. Nulla sed nibh lobortis, fringilla urna quis, tristique diam. Integer lobortis dictum mauris, eget consectetur ex vehicula gravida. Proin lobortis, felis et vehicula rutrum, mauris nulla ultricies massa, in volutpat magna ante eget turpis. ";
    //String text = "test";

    
    
    static Thread t;

    public static void main(String[] args) {

        text = RandomTextApi.getText();
        
        //System.out.println(text);
        
        
        JFrame frame = new JFrame("KeyTyping Game");
        TypingGame typinggame = new TypingGame();
        frame.getContentPane().add(typinggame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        RandomInsultAPI.initialize();
        SpeakerThread.initialize();

        frame.setVisible(true);

        t = new Thread(typinggame);

    }

    StyledDocument doc = new DefaultStyledDocument();
    SimpleAttributeSet set = new SimpleAttributeSet();
    JTextPane textPane = new JTextPane(doc);
    JLabel label = new JLabel();
    JButton button = new JButton("start");

    JPanel rootPanel = new JPanel();
    JPanel timerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    public static double timer = 0;
    public static JLabel sottotitoli = new JLabel();
    private boolean vittoria = false;

    public TypingGame() {
        super(new BorderLayout());
        textPane.setText(text);
        textPane.setEditable(false);
        label.setText("Timer: 0.00");
        sottotitoli.setHorizontalAlignment(JLabel.CENTER);
        sottotitoli.setVerticalAlignment(JLabel.BOTTOM);
        timerPanel.add(label);
        buttonPanel.add(button);
        rootPanel.add(timerPanel, BorderLayout.LINE_START);
        rootPanel.add(buttonPanel, BorderLayout.CENTER);
        super.add(new JScrollPane(textPane), BorderLayout.NORTH);
        super.add(rootPanel, BorderLayout.CENTER);
        super.add(sottotitoli, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!t.isAlive()) {
                    textPane.requestFocus();
                    button.setEnabled(false);

                    t.start();
                }
            }
        });

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    private int count = 0;

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar());
        if (e.getKeyCode() != KeyEvent.VK_SHIFT) {

            if (e.getKeyChar() == textPane.getText().charAt(count)) {
                //System.out.println("giusto");

                StyleConstants.setBackground(set, Color.green);
                StyleConstants.setForeground(set, Color.black);
                doc.setCharacterAttributes(count, 1, set, true);
                count++;

            } else {
                StyleConstants.setBackground(set, Color.red);
                StyleConstants.setForeground(set, Color.white);
                doc.setCharacterAttributes(count, 1, set, true);

                SpeakerThread.speak(RandomInsultAPI.getInsult());           //dice la stringa immessa

                //System.out.println("sbagliato");
            }

            if (count == text.length()) {
                System.out.println("vittoria");
                vittoria = true;
                t.stop();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    public void run() {

        textPane.addKeyListener(this);

        while (true) {
            timer += 0.01;
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TypingGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            label.setText("Timer: " + df2.format(timer));
        }
    }

}
