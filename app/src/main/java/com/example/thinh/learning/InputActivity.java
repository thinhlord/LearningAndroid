package com.example.thinh.learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.thinh.learning.model.HeadlineItems;
import com.example.thinh.learning.modelForUetm.ListDemoActivity;

// This is the home activity
public class InputActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.example.thinh.learning.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.input, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            case R.id.action_take_picture:
                openTakePicture();
                return true;
            case R.id.action_radio_button:
                openRadioButton();
                return true;
            case R.id.action_app_share:
                openShareTest();
                return true;
            case R.id.action_test_db:
                openDbTest();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openDbTest() {
        Intent dbIntent = new Intent(this, ListDemoActivity.class);
        startActivity(dbIntent);
    }

    public void openRadioButton() {
        Intent radioIntent = new Intent(this, TestRadioActivity.class);
        startActivity(radioIntent);
    }

    public void openSearch() {
        Intent searchIntent = new Intent(this, SearchActivity.class);
        startActivity(searchIntent);
    }

    public void openSettings() {
        Intent searchIntent = new Intent(this, SettingActivity.class);
        startActivity(searchIntent);
    }

    public void openTakePicture() {
        Intent takePictureIntent = new Intent(this, TakePictureActivity.class);
        startActivity(takePictureIntent);
    }

    public void openShareTest() {
        Intent shareTestIntent = new Intent(this, PhoneNumberActivity.class);
        startActivity(shareTestIntent);
    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox1:
                if (checked)
                    HeadlineItems.setSaved(0);
                else
                    HeadlineItems.setNoSaved(0);
                break;
            case R.id.checkBox2:
                if (checked)
                    HeadlineItems.setSaved(1);
                else
                    HeadlineItems.setNoSaved(1);
                break;
            case R.id.checkBox3:
                if (checked)
                    HeadlineItems.setSaved(2);
                else
                    HeadlineItems.setNoSaved(2);
                break;
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        SharedPreferences fileContent = getSharedPreferences(getString(R.string.preference_file),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editContent = fileContent.edit();
        for (int i = 0; i <= 2; i++) {
            if (HeadlineItems.saved[i]) {
                editContent.putString("Option" + i, message);
            }
        }
        editContent.commit();

        startActivity(intent);
    }
}
