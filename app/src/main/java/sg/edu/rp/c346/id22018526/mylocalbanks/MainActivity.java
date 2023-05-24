package sg.edu.rp.c346.id22018526.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button dbs;
    Button ocbc;
    Button uob;

    TextView dbsview;
    TextView ocbcview;
    TextView uobview;

    String bankpicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.DBSbutton);
        ocbc = findViewById(R.id.OCBCbutton);
        uob = findViewById(R.id.UOBbutton);
        dbsview = findViewById(R.id.subDBSview);
        ocbcview = findViewById(R.id.subOCBCview);
        uobview = findViewById(R.id.subUOBview);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo) {
        super.onCreateContextMenu(menu, v, menuinfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        if(v == dbs) {
            bankpicked = "DBS";
        }
        else if(v == ocbc){
            bankpicked = "OCBC";
        }
        else if(v == uob){
            bankpicked = "UOB";
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (bankpicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(websiteIntent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent contactIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(contactIntent);
                return true;
            }

        }
        if (bankpicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(websiteIntent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent contactIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                startActivity(contactIntent);
                return true;
            }


        }
        if (bankpicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(websiteIntent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent contactIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222122"));
                startActivity(contactIntent);
                return true;
            }


        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbsview.setText("DEVELOPMENT BANK OF SINGAPORE");
            ocbcview.setText("OVERSEA CHINESE BANKING CORPORATION");
            uobview.setText("UNITED OVERSEAS BANKING");
            dbs.setText("PRESS FOR OPTIONS");
            ocbc.setText("PRESS FOR OPTIONS");
            uob.setText("PRESS FOR OPTIONS");
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbsview.setText("星展银行");
            ocbcview.setText("华侨银行");
            uobview.setText("大华银行");
            dbs.setText("按选项");
            ocbc.setText("按选项");
            uob.setText("按选项");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}