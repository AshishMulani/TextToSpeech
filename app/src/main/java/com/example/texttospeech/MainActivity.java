package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Create Objects

    EditText et1;
    Button b1;
    TextToSpeech my_tts_object;


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(my_tts_object!=null)
        {
            my_tts_object.stop();
            my_tts_object.shutdown();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fetch the Ref. from XML file

        et1=(EditText) findViewById(R.id.editTextTextPersonName3);
        b1=(Button) findViewById(R.id.button5);

        my_tts_object=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i)
            {
                //Check the Initialization of TTS Engine

                if(i!=TextToSpeech.ERROR)
                {
                    //set The Language

                    my_tts_object.setLanguage(Locale.US);

                }


            }
        });

        //Event handling Code for Button

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Fetch the Value of Edittext

                String txt_speak=et1.getText().toString();


                //Call Speak Method

                my_tts_object.speak(txt_speak,TextToSpeech.QUEUE_FLUSH,null,null);

                Toast.makeText(MainActivity.this,""+txt_speak, Toast.LENGTH_LONG).show();

            }
        });




    }
}