package com.cosmic.pilf;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;
import android.view.View;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final int PHASE_1_PROMPT_INTERVAL = 22 * 60 * 1000 + 22000; // 22m22s

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startPhaseOneTimer();
    }

    private void startPhaseOneTimer() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            showPhaseOnePrompt();
        }, PHASE_1_PROMPT_INTERVAL);
    }

    private void showPhaseOnePrompt() {
        Toast.makeText(this,
            "Are the lies truth yet? Are the truths becoming liars?",
            Toast.LENGTH_LONG).show();

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }
}