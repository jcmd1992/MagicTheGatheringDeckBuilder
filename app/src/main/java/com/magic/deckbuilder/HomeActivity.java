package com.magic.deckbuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button DeckButton;
    private Button DeckInfoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DeckButton = (Button) findViewById(R.id.deck);
        DeckInfoButton = (Button) findViewById(R.id.deck_info);

        DeckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Deck();
            }
        });

        DeckInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeckInfo();

            }
        });
    }

    public void Deck(){
        Intent intent = new Intent(this, DeckActivity.class);
        startActivity(intent);
    }

    public void DeckInfo(){
    Intent intent = new Intent(this, DeckContents.class);
    startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        if (id == R.id.deck_info) {
            Intent intent = new Intent(getApplicationContext(), DeckContents.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.deck) {
            Intent intent = new Intent(getApplicationContext(), DeckActivity.class);
            startActivity(intent);
            return true;
        }
        return onOptionsItemSelected(item);
    }
}
