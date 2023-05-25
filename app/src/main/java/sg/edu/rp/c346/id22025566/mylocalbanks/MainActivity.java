package sg.edu.rp.c346.id22025566.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DECLARE VARIABLES
    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    String wordClicked="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BIND THE VARIABLES
        btnDBS=findViewById(R.id.buttonDBS);
        btnOCBC=findViewById(R.id.buttonOCBC);
        btnUOB=findViewById(R.id.buttonUOB);

        //REGISTER FOR CONTEXT MENU FOR ALL BUTTONS
        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
    }


    //CREATE A CONTEXT MENU for each one of the 3 buttons
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == btnDBS) {
            wordClicked = "DBS";

        } else if (v == btnOCBC) {
            wordClicked = "OCBC";

        } else if (v == btnUOB) {
            wordClicked = "UOB";


        }

        //group id is 0. meaning it is for 1st button

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact");


    }

    // what will happen if any option in the context menu is clicked
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) { // if context menu for dbs is clicked


            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0 (DBS Website)
                //code for action
                String websiteUrl = "https://www.dbs.com.sg/index/default.page"; // Replace with your desired website URL
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);


                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1 (DBS Hotline)
                //create an intent called intentCall
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
        }


        if (wordClicked.equalsIgnoreCase("ocbc")) { // if context menu for ocbc is clicked


            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0 (OCBC Website)
                //code for action
                String websiteUrl = "https://www.ocbc.com/group/gateway.page"; // Replace with your desired website URL
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);


                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1 (OCBC Hotline)
                //create an intent called intentCall
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
        }

        if (wordClicked.equalsIgnoreCase("UOB")) { // if context menu for uob is clicked


            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0 (uob Website)
                //code for action
                String websiteUrl = "https://www.uobgroup.com/uobgroup/index.page"; // Replace with your desired website URL
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);


                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1 (uob Hotline)
                //create an intent called intentCall
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
        }








        return true;
    }








    // create the options menu for language
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_lang, menu);
        return true;
    }

    // what will happen if individual language is selected from options menu created in lines 30 to 34
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.indonesianSelection) { //if indonesian is selected
            btnDBS.setText("Bank Pembangunan Singapura (DBS)");
            btnOCBC.setText("Korporasi Perbankan Cina Luar Negeri (OCBC)");
            btnUOB.setText("Bersatu Bank Luar Negeri (UOB)");
            return true;
        } else if (id == R.id.englishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else {
            btnDBS.setText("Error translation");
            btnOCBC.setText("Error translation");
            btnUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}