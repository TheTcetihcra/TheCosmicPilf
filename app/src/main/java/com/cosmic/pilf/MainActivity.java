package com.cosmic.pilf;

import android.os.Bundle;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import android.view.View;
import android.content.Context;
import androidx.appcompat.app.AlertDialog;
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
        new AlertDialog.Builder(this)
            .setTitle("Phase 1")
            .setMessage(getString(R.string.phase_one_prompt))
            .setPositiveButton("Continue", null)
            .setCancelable(false)
            .show();

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }
}