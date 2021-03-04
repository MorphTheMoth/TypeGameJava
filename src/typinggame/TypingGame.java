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
public class TypingGame extends JPanel {

    static String text = "test";
    static TypingGame typinggame;
    static JFrame frame;
    static Thread t;
    static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) {
        StartPage sp = new StartPage();
        sp.setVisible(true);
    }
}
