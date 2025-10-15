package de.mide.activitylifecycledemo;

import android.app.Activity;
import android.os.Bundle;


/**
 * Zweite Activity, die die Main-Activity vollständig überdeckt.
 * Zum Verlassen der Activity könnte noch ein Button zum Aufruf
 * der Methode {@link Activity#finish()}  implementiert werden.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class AndereActivity extends Activity {


    /**
     * Lifecycle-Methode zur Initialisierung des Activity-Objekts.
     */
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_andere );
    }

};
