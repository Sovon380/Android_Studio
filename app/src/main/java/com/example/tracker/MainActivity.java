package com.example.tracker;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare the BeerExpert class object
    public BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method called when the button is clicked
    public void onClickFindRole(View view) {
        // Get a reference to the TextView
        TextView textView = findViewById(R.id.textView);

        // Get a reference to the Spinner
        Spinner color = findViewById(R.id.color);

        // Get the selected item from the Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        // Get recommendations from the BeerExpert class
        List<String> brandsList = expert.getBrands(beerType);

        // Create a SpannableStringBuilder to format the brand names
        SpannableStringBuilder brandsFormatted = new SpannableStringBuilder();
        for (String brand : brandsList) {
            // Add the text with style
            int start = brandsFormatted.length();
            brandsFormatted.append(brand).append('\n');
            brandsFormatted.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), start, brandsFormatted.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            brandsFormatted.setSpan(new AbsoluteSizeSpan(24, true), start, brandsFormatted.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // Increase font size to 24sp
        }

        // Display the brands in the TextView
        textView.setText(brandsFormatted);

        // Get a reference to the ImageView
        ImageView imageView = findViewById(R.id.imageView);

        // Set the image based on the selected beer type
        switch (beerType) {
            case "Google":
                imageView.setImageResource(R.drawable.google);
                break;
            case "Meta":
                imageView.setImageResource(R.drawable.meta);
                break;
            case "Apple":
                imageView.setImageResource(R.drawable.apple);
                break;
            case "Amazon":
                imageView.setImageResource(R.drawable.amazon);
                break;
            case "Netflix":
                imageView.setImageResource(R.drawable.netflix);
                break;
            default:
                imageView.setImageResource(R.drawable.blank); // No image
                break;
        }
    }
}
