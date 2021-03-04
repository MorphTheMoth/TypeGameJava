package typinggame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Locale;
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

    static String text = "test";
    static TypingGame typinggame;
    static JFrame frame;
    static Thread t;
    static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) {
        int frameHeight = 500, frameWidth = 800;
        text = RandomTextApi.getText();
        //System.out.println(text);
        typinggame = new TypingGame();
        frame = new JFrame("KeyTyping Game");
        frame.getContentPane().add(typinggame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation((dimension.width - frameWidth) / 2, (dimension.height - frameHeight) / 2);        //center frame

        RandomInsultAPI.initialize();
        SpeakerThread.initialize();

        frame.setVisible(true);


    }

    StyledDocument doc = new DefaultStyledDocument();
    SimpleAttributeSet set = new SimpleAttributeSet();
    JTextPane textPane = new JTextPane(doc);
    JLabel label = new JLabel();
    JButton button = new JButton("start");
    JButton dashboard = new JButton("dashboard");

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
        sottotitoli.setFont(new Font("big", Font.PLAIN, 15));
        timerPanel.add(label);
        buttonPanel.add(button);
        rootPanel.add(timerPanel, BorderLayout.LINE_START);
        rootPanel.add(buttonPanel, BorderLayout.CENTER);
        super.add(new JScrollPane(textPane), BorderLayout.NORTH);
        super.add(rootPanel, BorderLayout.CENTER);
        
        JPanel southGrid = new JPanel(new GridLayout(2, 1));
        southGrid.add(sottotitoli);
        southGrid.add(dashboard);

        super.add(sottotitoli, BorderLayout.SOUTH);
        super.add(dashboard, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vittoria){
                    vittoria = false;
                    timer = 0;
                    StyleConstants.setBackground(set, Color.white);
                    StyleConstants.setForeground(set, Color.black);
                    doc.setCharacterAttributes(0, text.length(), set, true);
                    count=0;
                }
                
                if (!vittoria) {
                    textPane.requestFocus();
                    button.setEnabled(false);

                    t = new Thread(typinggame);
                    t.start();

                }
                
                
            }
        });

        dashboard.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ApiPortal apiPortal = new ApiPortal();
                apiPortal.setVisible(true);
                frame.setVisible(false);
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
                button.setEnabled(true);
                textPane.removeKeyListener(this);
                t.stop();


            }
        }
        
        //set subtitles
        sottotitoli.setText("[" + SpeakerThread.threads.get(SpeakerThread.threads.size()-1).currentText + "]");
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
