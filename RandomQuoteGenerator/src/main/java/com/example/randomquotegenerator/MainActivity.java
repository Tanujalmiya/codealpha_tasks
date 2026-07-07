package com.example.randomquotegenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button, shareButton, copyButton;

    String[] quotes = {
            "Believe in yourself.",
            "Dream big and work hard.",
            "Success is earned, not given.",
            "Never give up.",
            "Stay positive.",
            "Every day is a new beginning.",
            "Small steps lead to big success.",
            "Push yourself because no one else will.",
            "Hard work beats talent.",
            "Your future starts today.",
            "Don't stop until you're proud.",
            "Focus on your goals.",
            "Every day is a fresh start.",
            "Stay hungry, stay foolish.",
            "Be fearless.",
            "Create your own future.",
            "Success starts with action.",
            "Learn something new every day.",
            "Winners never quit.",
            "Impossible is just an opinion."
    };

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        shareButton = findViewById(R.id.shareButton);
        copyButton = findViewById(R.id.copyButton);

        button.setOnClickListener(v -> {
            int index = random.nextInt(quotes.length);
            textView.setText(quotes[index]);
        });

        shareButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
            startActivity(Intent.createChooser(intent, "Share Quote"));
        });

        copyButton.setOnClickListener(v -> {
            ClipboardManager clipboard =
                    (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

            ClipData clip = ClipData.newPlainText(
                    "Quote",
                    textView.getText().toString()
            );

            clipboard.setPrimaryClip(clip);

            Toast.makeText(
                    MainActivity.this,
                    "Quote Copied!",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}