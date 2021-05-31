package sg.edu.rp.c346.id20011262.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvUOB, tvOCBC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    String wordClick = "";
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == tvDBS) {
            wordClick = "DBS";
        } else if (v == tvOCBC) {
            wordClick = "OCBC";
        } else if (v == tvUOB) {
            wordClick = "UOB";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(R.string.dbs);
            tvOCBC.setText(R.string.ocbc);
            tvUOB.setText(R.string.uob);
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(R.string.dbschinese);
            tvOCBC.setText(R.string.ocbcchinese);
            tvUOB.setText(R.string.uobchinese);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(wordClick.equalsIgnoreCase("DBS")) {
            if(id == R.id.websiteSelection) {
                Intent intentWebsite = new Intent (Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbswebsite)));
                startActivity(intentWebsite);
            } else if (id == R.id.CTBSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbsnumber)));
                startActivity(intentCall);
            } else if (id == R.id.favouriteSelection) {
                if (tvDBS.getCurrentTextColor() == (Color.BLACK)) {
                    tvDBS.setTextColor(Color.RED);
                } else {
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
        } else if(wordClick.equalsIgnoreCase("OCBC")) {
            if(id == R.id.websiteSelection) {
                Intent intentWebsite = new Intent (Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcwebsite)));
                startActivity(intentWebsite);
            } else if (id == R.id.CTBSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbcnumber)));
                startActivity(intentCall);
            } else if (id == R.id.favouriteSelection) {
                if (tvOCBC.getCurrentTextColor() == (Color.BLACK)) {
                    tvOCBC.setTextColor(Color.RED);
                } else {
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }
        } else if (wordClick.equalsIgnoreCase("UOB")) {
            if(id == R.id.websiteSelection) {
                Intent intentWebsite = new Intent (Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobwebsite)));
                startActivity(intentWebsite);
            } else if (id == R.id.CTBSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uobnumber)));
                startActivity(intentCall);
            } else if (id == R.id.favouriteSelection) {
                if (tvUOB.getCurrentTextColor() == (Color.BLACK)) {
                    tvUOB.setTextColor(Color.RED);
                } else {
                    tvUOB.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }
}