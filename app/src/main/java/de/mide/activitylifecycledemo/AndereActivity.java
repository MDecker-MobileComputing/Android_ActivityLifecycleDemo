package de.mide.activitylifecycledemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


/**
 * Zweite Activity, die die Main-Activity vollständig überdeckt.
 * Zum Verlassen der Activity könnte noch ein Button zum Aufruf
 * der Methode {@link Activity#finish()}  implementiert werden.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class AndereActivity extends AppCompatActivity {

    protected static final String TAG4LOGGING = "AndereActivity";

    /**
     * Lifecycle-Methode zur Initialisierung des Activity-Objekts.
     */
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_andere );

        actionbarInitialisieren();
    }

    /**
     * Actionbar initialisieren.
     */
    private void actionbarInitialisieren() {

        final ActionBar actionBar = getSupportActionBar();
        if ( actionBar == null ) {

            Log.w( TAG4LOGGING, "Keine ActionBar gefunden." );
            return;
        }

        actionBar.setTitle( R.string.title_activity_andere );
    }

};
