private void showPhaseOnePrompt() {
    new AlertDialog.Builder(this)
        .setTitle("Phase 1")
        .setMessage(getString(R.string.phase_one_prompt))
        .setPositiveButton("Continue", (dialog, which) -> {
            // Unlock the input field
            EditText inputField = findViewById(R.id.phase_one_input);
            inputField.setEnabled(true);
            inputField.setFocusable(true);
            inputField.setFocusableInTouchMode(true);
            inputField.requestFocus();

            // Show the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.showSoftInput(inputField, InputMethodManager.SHOW_IMPLICIT);
            }
        })
        .setNegativeButton("×", (dialog, which) -> {
            // User skipped the prompt
            dialog.dismiss();
        })
        .setCancelable(false)
        .show();
}