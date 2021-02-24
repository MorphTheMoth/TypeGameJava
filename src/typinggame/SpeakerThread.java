/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typinggame;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


/**
 * 
 * @author green
 */

public class SpeakerThread extends Thread {

    private static Voice voice;
    private static int ThreadNum = 0;
    private final static int MAXTHREAD = 2;
    private String currentText; //Thread variable
    

    public static void initialize() {
        dospeak("kevin16");
    }

    public static void speak(String text) {
        if( ThreadNum < MAXTHREAD )     //non ne mette più di uno in coda 
            new SpeakerThread(text).start();
    }

    public SpeakerThread(String text) {
        currentText = text;
    }

    public void run() {
        
        ThreadNum++;
        freettsVoice.speak(currentText);
        ThreadNum--;
        
    }

    
    static VoiceManager freettsVM;
    static Voice freettsVoice;
    
    public static void dospeak(String voicename) {
        System.setProperty("freetts.voices", "de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");

        System.setProperty("mbrola.base", "C:\\Users\\Federico\\Desktop\\ScuolaPortatile\\TPSIT\\TypeGameJava\\mbrola\\");

        //System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        
        
        freettsVM = VoiceManager.getInstance();

        Voice[] arr = VoiceManager.getInstance().getVoices();
        for(int i=0; i<arr.length; i++)
            System.out.println("   --   "+arr[i].getName());
        
        // Simply change to MBROLA voice
        freettsVoice = freettsVM.getVoice("mbrola_us1");

        // Allocate your chosen voice
        freettsVoice.allocate();
        
        
        
        /*voice = VoiceManager.getInstance().getVoice("us1");
        if (voice != null) {
            voice.allocate();// Allocating Voice
            try {
                voice.setRate(130);// Setting the rate of the voice
                voice.setPitch(100);// Setting the Pitch of the voice
                voice.setVolume(1);// Setting the volume of the voice

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } else {
            throw new IllegalStateException("Cannot find voice: kevin16");
        }*/
    }
    
    
}
