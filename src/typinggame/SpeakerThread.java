/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typinggame;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.util.ArrayList;


/**
 * 
 * @author green
 */

public class SpeakerThread extends Thread {

    private static int ThreadNum = 0;
    private final static int MAXTHREAD = 2;
    public static ArrayList<SpeakerThread> threads = new ArrayList<SpeakerThread>();
    
    public String currentText; //Thread variable

    public static void initialize() {
        System.setProperty("freetts.voices", "de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");

        System.setProperty("mbrola.base", System.getProperty("user.dir") + "\\mbrola\\");

        //System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        
        
        freettsVM = VoiceManager.getInstance();

        Voice[] arr = VoiceManager.getInstance().getVoices();
        //for(int i=0; i<arr.length; i++)
        //    System.out.println("   --   "+arr[i].getName());
        
        // Simply change to MBROLA voice
        freettsVoice = freettsVM.getVoice("mbrola_us1");
        freettsVoice.setPitch(160);
        freettsVoice.setPitchRange(30);
        freettsVoice.setRate(120);
        // Allocate your chosen voice
        freettsVoice.allocate();
        
        freettsVoice.setRate(145);
        freettsVoice.setPitch(200);
        freettsVoice.setVolume(1);
    }

    public static void speak(String text) {
        if( ThreadNum < MAXTHREAD )     //non ne mette più di uno in coda 
        {
            threads.add(0, new SpeakerThread(text) );
            threads.get(0).start();
        }
    }

    public SpeakerThread(String text) {
        currentText = text;
    }

    public void run() {
        
        ThreadNum++;
        freettsVoice.speak(currentText);
        ThreadNum--;
        
        threads.remove(this);
    }

    
    static VoiceManager freettsVM;
    static Voice freettsVoice;
    
    
}
