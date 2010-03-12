package com.ravenxq.houseCommand;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.JSMLException;
import javax.speech.synthesis.Synthesizer;

public class CommandAnswer {

    public static void say(final String toSay) {
        try {
            final Synthesizer synth = Central.createSynthesizer(null);
            synth.allocate();
            synth.resume();

            synth.speak(toSay, null);
            synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
            synth.deallocate();
        } catch (final IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final EngineException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final EngineStateError e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final AudioException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final JSMLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
