package de.mide.activitylifecycledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Demo für Lifecycle-Methoden einer Activity.
 * Jede Lifecycle-Methode gibt bei Aufruf eine entsprechende Zeile in
 * ein TextView-Element und auf den Logger aus.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity
        implements View.OnClickListener {

    /** Tag für Log-Messages der ganzen App. */
    protected static final String TAG4LOGGING = "LifecycleDemo";


    /** Textview (scrollbar), in dem Logoutput-Zeilen geschrieben werden. */
    protected TextView _textViewLogOutput = null;

    /** Button um eine Activity zu öffnen. */
    protected Button _buttonActivity = null;

    /** Button um Textview mit Logoutput zu leeren. */
    protected Button _buttonLogLeeren = null;


    /**
     * Lifecycle-Methode zur Initialisierung des Activity-Objekts.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _textViewLogOutput = findViewById(R.id.textviewForLogoutput);
        _textViewLogOutput.setMovementMethod( new ScrollingMovementMethod() );

        _buttonActivity  = findViewById(R.id.buttonActivity );
        _buttonLogLeeren = findViewById(R.id.buttonLogLeeren);

        _buttonActivity.setOnClickListener (this);
        _buttonLogLeeren.setOnClickListener(this);

        schreibeZeile("onCreate() aufgerufen");
    }


    /**
     * Event-Handler-Methode für die beiden Buttons.
     *
     * @param view  Button, der das Event ausgelöst hat.
     */
    @Override
    public void onClick(View view) {

        if (view == _buttonActivity) {

            activityOeffnen();

        } else if (view == _buttonLogLeeren) {

            _textViewLogOutput.setText("");

        } else {

            schreibeZeile("Interner Fehler: Event-Handler für unerwartetes View-Objekt aufgerufen");
        }
    }


    /**
     * In dieser Methode wird eine andere Activity geöffnet
     * (mit explizitem Intent).
     */
    protected void activityOeffnen() {

        Intent intent = new Intent(this, AndereActivity.class);
        startActivity(intent);
    }


    /**
     * Lifecycle-Methode: Wird aufgerufen, wenn die unsichtbare Activity sichtbar wird
     * (damit wird sie aber nicht notwendigerweise auch gleich "Aktiv").
     */
    @Override
    protected void onStart() {

        super.onStart();
        schreibeZeile("onStart() aufgerufen");
    }


    /**
     * Lifecycle-Methode: Wir aufgerufen, wenn die Activity schon gestoppt wurde, und
     * jetzt wieder gestartet wird. Hiernach wird immer onStart() aufgerufen.
     */
    @Override
    protected void onRestart() {

        super.onRestart();
        schreibeZeile("onRestart() aufgerufen");
    }


    /**
     * Lifecycle-Methode: Wird aufgerufen für den Übergang von "sichtbar" zu "aktiv"
     * (nur eine aktive Activity kann auf Nutzereingaben reagieren).
     */
    @Override
    protected void onResume() {

        super.onResume();
        schreibeZeile("onResume() aufgerufen");
    }


    /**
     * Lifecycle-Methode: Activity ist jetzt "nur" noch sichtbar, aber nicht mehr
     * "aktiv" (kann also nicht mehr auf Nutzereingaben reagieren).
     * Gegenstück dieser Methode ist "onResume()".
     */
    @Override
    protected void onPause() {

        schreibeZeile("onPause() aufgerufen");
        super.onPause();
    }


    /**
     * Lifecycle-Methode: Sichtbare Activity wird jetzt unsichtbar
     * (wird aber nicht unbedingt gleich zerstört).
     */
    @Override
    protected void onStop() {

        schreibeZeile("onStop() aufgerufen");
        super.onStop();
    }


    /**
     * Lifecycle-Methode: Wird aufgerufen, kurz bevor die Activity "zerstört" wird
     * (also aus dem Speicher gelöscht). Gegenstück dieser Methode ist "onCreate()".
     * Activity kann zerstört werden, weil "finish()"-Methode aufgerufen wurde.
     */
    @Override
    protected void onDestroy() {

        schreibeZeile("onDestroy() aufgerufen");
        super.onDestroy();
    }


    /**
     * Schreibt den übergebenen String in das Logfile und
     * das TextView-Element.
     *
     * @param zeile  Auszugebender String
     */
    protected void schreibeZeile(String zeile) {

        Log.i(TAG4LOGGING, zeile);

        if (_textViewLogOutput != null) {

            _textViewLogOutput.append(zeile + "\n");
        }
    }

}
