package com.magic.deckbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DeckActivity extends AppCompatActivity {

    private Button Creatures;
    private Button Instants;
    private Button Sorceries;
    private Button Artefacts;
    private Button Enchantments;
    private Button Planeswalkers;
    private Button BasicLand;
    private Button NonBasicLand;
    private AlertDialog.Builder alertDialog;
    private AlertDialog dialog;

    public String fileText = "";

    static final int READ_BLOCK_SIZE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Creatures = (Button) findViewById(R.id.creatures);
        Instants = (Button) findViewById(R.id.intsants);
        Sorceries = (Button) findViewById(R.id.sorceries);
        Artefacts = (Button) findViewById(R.id.Artifacts);
        Enchantments = (Button) findViewById(R.id.Enchantments);
        Planeswalkers = (Button) findViewById(R.id.Planeswaker);
        BasicLand = (Button) findViewById(R.id.BasicLand);
        NonBasicLand = (Button) findViewById(R.id.nonbasicland);



        PopupWindow popUpWindow = new PopupWindow(this);

        //myRef.setValue(mStorageRef);


        Creatures.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO copy into all click methods and cange text file name
                fileText = readFile("Creatures.txt");
                Intent intent = new Intent(getApplicationContext(), DeckContents.class);
                intent.putExtra("File", fileText);
                startActivity(intent);
            }
        });

        Instants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileText = readFile("Instants");
                Intent intent = new Intent(getApplicationContext(), DeckContents.class);
                intent.putExtra("File", fileText);
                startActivity(intent);
                }
        });

        Sorceries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileText = readFile("Sorcery");
                Intent intent = new Intent(getApplicationContext(), DeckContents.class);
                intent.putExtra("File", fileText);
                startActivity(intent);
             }
         });

        Artefacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileText = readFile("Artifacts");
                Intent intent = new Intent(getApplicationContext(), DeckContents.class);
                intent.putExtra("File", fileText);
                startActivity(intent);
            }
        });

        Enchantments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileText = readFile("Enchantments");
                Intent intent = new Intent(getApplicationContext(), DeckContents.class);
                intent.putExtra("File", fileText);
                startActivity(intent);
            }
        });

        Planeswalkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileText = readFile("Planeswalker");
                Intent intent = new Intent(getApplicationContext(), DeckContents.class);
                intent.putExtra("File", fileText);
                startActivity(intent);
            }
        });

        BasicLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileText = readFile("Basic-Land");
                Intent intent = new Intent(getApplicationContext(), DeckContents.class);
                intent.putExtra("File", fileText);
                startActivity(intent);
            }
        });

        NonBasicLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fileText = readFile("Non-Basic-Land");
                Intent intent = new Intent(getApplicationContext(), DeckContents.class);
                intent.putExtra("File", fileText);
                startActivity(intent);
            }
        });
    }
    public void showInputDialog() {
        //Build custom alert dialog
        alertDialog = new AlertDialog.Builder(DeckActivity.this);
        View view = getLayoutInflater().inflate(R.layout.content_dialog_view, null);
        alertDialog.setView(view);
        dialog = alertDialog.create();
        dialog.show();
    }

//    public boolean onCreateOptionsMenu(Menu myMenu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, myMenu);
//        return onCreateOptionsMenu(myMenu);
//    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        if (id == R.id.deck) {
            Intent intent = new Intent(getApplicationContext(), DeckActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.home) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            return true;
        }
        return onOptionsItemSelected(item);
    }

    public String readFile(String file) {
        String text = "";
        try{
            InputStream inputStream = getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(),text,
                Toast.LENGTH_SHORT).show();
        return text;
    }
}
