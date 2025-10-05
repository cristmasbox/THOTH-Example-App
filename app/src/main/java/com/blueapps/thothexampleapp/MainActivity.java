package com.blueapps.thothexampleapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.blueapps.thothexampleapp.databinding.MainActivityBinding;
import com.rw.keyboardlistener.KeyboardUtils;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;

    private static final int[] Colors = {Color.BLACK, Color.WHITE, Color.GRAY, Color.CYAN, Color.MAGENTA, Color.YELLOW};
    private int textColorCursor = 0;
    private int bgColorCursor = 0;
    private int altTextCursor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Define inputText
        binding.inputText.setText(binding.thothView.getText());
        binding.inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TextChangerThread textChangerThread = new TextChangerThread(binding, false);
                textChangerThread.setText(charSequence);
                textChangerThread.start();
            }
        });

        // Define verticalOrientation RadioGroup
        binding.VerticalOrientation.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.top){
                binding.thothView.setVerticalOrientation(0);
            } else if (i == R.id.middle){
                binding.thothView.setVerticalOrientation(1);
            } else if (i == R.id.bottom){
                binding.thothView.setVerticalOrientation(2);
            } else {
                binding.thothView.setVerticalOrientation(1);
            }
        });

        // Define writingLayout RadioGroup
        binding.WritingLayout.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.lines){
                binding.thothView.setWritingLayout(0);
            } else if (i == R.id.columns){
                binding.thothView.setWritingLayout(1);
            } else {
                binding.thothView.setWritingLayout(0);
            }
        });

        // Define TextSize Seekbar
        binding.textSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textSizeTitle.setText(getString(R.string.text_size_title) + i + "sp");
                binding.thothView.setTextSize(spToPx(i, MainActivity.this));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Define AltTextSize Seekbar
        binding.altTextSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.altTextSizeTitle.setText(getString(R.string.alt_text_size_title) + i + "sp");
                binding.thothView.setAltTextSize(spToPx(i, MainActivity.this));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Define text color Button
        binding.changeTextColor.setOnClickListener(view -> {
            binding.thothView.setPrimarySignColor(Colors[textColorCursor]);
            textColorCursor++;
            if (textColorCursor >= Colors.length){
                textColorCursor = 0;
            }
        });

        // Define bg color Button
        binding.changeBGColor.setOnClickListener(view -> {
            binding.thothView.setBackgroundColor(Colors[bgColorCursor]);
            bgColorCursor++;
            if (bgColorCursor >= Colors.length){
                bgColorCursor = 0;
            }
        });

        // Define alt text color Button
        binding.changeAltTextColor.setOnClickListener(view -> {
            binding.thothView.setAltTextColor(Colors[altTextCursor]);
            altTextCursor++;
            if (altTextCursor >= Colors.length){
                altTextCursor = 0;
            }
        });

        // Define show alt text switch
        binding.showAltText.setOnCheckedChangeListener((compoundButton, b) -> {
            binding.thothView.showAltText(b);
        });

        // Define test alt text switch
        binding.testAltText.setOnCheckedChangeListener((compoundButton, b) -> {
            binding.thothView.testAltText(b);
        });

        // Define alt text input text here
        binding.altText.setText(binding.thothView.getAltText());
        binding.altText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TextChangerThread textChangerThread = new TextChangerThread(binding, true);
                textChangerThread.setText(charSequence);
                textChangerThread.start();
            }
        });

        // some layout stuff

        KeyboardUtils.addKeyboardToggleListener(this, isVisible -> {
            if(binding.inputText.hasFocus()) {
                if (isVisible) {
                    binding.scrollView2.setVisibility(View.GONE);
                } else {
                    binding.scrollView2.setVisibility(View.VISIBLE);
                }
            } else {
                if (isVisible) {
                    binding.inputText.setVisibility(View.GONE);
                } else {
                    binding.inputText.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public static int spToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

}
