package hr.ferit.tomislavmarkovica.lv5_orwima_zadaca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

    private EditText editTextDescription;

    private Button buttonInspiration;
    private Button buttonEditDescription;

    private TextView textViewDescription1;
    private TextView textViewDescription2;
    private TextView textViewDescription3;

    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewClick();
        buttonInspirationClick();
        initializeTextViewDescriptions();
        initializeRadioButtons();
        buttonEditDescriptionClick();
    }


    private void imageViewClick() {
        this.imageView1 = (ImageView) findViewById(R.id.imageView1);
        this.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setVisibility(View.INVISIBLE);
            }
        });

        this.imageView2 = (ImageView) findViewById(R.id.imageView2);
        this.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setVisibility(View.INVISIBLE);
            }
        });

        this.imageView3 = (ImageView) findViewById(R.id.imageView3);
        this.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView3.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void initializeTextViewDescriptions() {
        this.textViewDescription1 = (TextView) findViewById(R.id.textViewDescription1);
        this.textViewDescription2 = (TextView) findViewById(R.id.textViewDescription2);
        this.textViewDescription3 = (TextView) findViewById(R.id.textViewDescription3);
    }

    private void buttonInspirationClick() {
        this.buttonInspiration = (Button) findViewById(R.id.buttonInspiration);

        this.buttonInspiration.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int randomNumber = getRandomNumberFrom1To3();

                if(randomNumber == 1) {
                    Toast.makeText(getBaseContext(), textViewDescription1.getText() , Toast.LENGTH_SHORT ).show();
                }
                else if(randomNumber == 2) {
                    Toast.makeText(getBaseContext(), textViewDescription2.getText() , Toast.LENGTH_SHORT ).show();
                }
                else if(randomNumber == 3) {
                    Toast.makeText(getBaseContext(), textViewDescription3.getText() , Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }

    private int getRandomNumberFrom1To3() {
        Random rn = new Random();
        int randomNumber = rn.nextInt(3) + 1;
        return randomNumber;
    }

    private void initializeRadioButtons() {
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        this.radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        this.radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        this.radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
    }

    private void buttonEditDescriptionClick() {
        this.buttonEditDescription = (Button) findViewById(R.id.buttonEditDescription);
        this.editTextDescription = (EditText) findViewById(R.id.editTextDescription);

        this.buttonEditDescription.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CheckRadioButtonClicked();
            }
        });
    }

    private void CheckRadioButtonClicked() {
        if (this.radioButton1.isChecked()) {
            this.textViewDescription1.setText(this.editTextDescription.getText());
        }
        else if (this.radioButton2.isChecked()) {
            this.textViewDescription2.setText(this.editTextDescription.getText());
        }
        else if (this.radioButton3.isChecked()) {
            this.textViewDescription3.setText(this.editTextDescription.getText());
        }
    }
}