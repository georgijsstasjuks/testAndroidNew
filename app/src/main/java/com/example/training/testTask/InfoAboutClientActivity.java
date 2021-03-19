package com.example.training.testTask;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.training.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InfoAboutClientActivity extends AppCompatActivity {
    private LinearLayout mLinearLayout;
    private TextView mTextViewFirstName;
    private TextView mTextViewLastName;
    private TextView mTextViewCountry;
    private TextView mTextViewDescription;
    private ActionBar mActionBar;
    private MenuInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_about_client);
        mActionBar = getSupportActionBar();
        mLinearLayout = (LinearLayout)findViewById(R.id.info);
        mTextViewFirstName = (TextView)findViewById(R.id.text_view_first_name);
        mTextViewLastName = (TextView)findViewById(R.id.text_view_last_name);
        mTextViewCountry = (TextView)findViewById(R.id.text_view_country);
        mTextViewDescription = (TextView)findViewById(R.id.text_view_description);
        Bundle arguments = getIntent().getExtras();
        ClientModel client;
        if( arguments != null ){
            client = arguments.getParcelable(ClientModel.class.getSimpleName());
            String userName = client.getUserName();
            String firstName = client.getFirstName();
            String lastName = client.getLastName();
            String country = client.getCountry();
            String description = client.getDescription();
            mTextViewFirstName.setText(firstName);
            mTextViewLastName.setText(lastName);
            mTextViewCountry.setText(country);
            mTextViewDescription.setText(Html.fromHtml(description));
            mTextViewDescription.setMovementMethod(LinkMovementMethod.getInstance());
            mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            mActionBar.setCustomView(R.layout.menu_toolbar_title);
            TextView title = (TextView) mActionBar.getCustomView().findViewById(R.id.text_view_toolbar_title);
            title.setText(userName);
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        mInflater = getMenuInflater();
        mInflater.inflate(R.menu.activity_info_about_client, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_remove:
                int position = getIntent().getIntExtra("position",-1);
                String newJsonString = deleteJson(position);
                Intent intent = new Intent();
                intent.putExtra("newJsonString", newJsonString);
                setResult(RESULT_OK, intent);
                Toast toast = Toast.makeText(getApplicationContext(),"User has been deleted", Toast.LENGTH_SHORT);
                toast.show();
                finish();
                this.finish();

            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public String deleteJson(int position){
        String json = getIntent().getStringExtra("allData");
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("clients");
            JSONArray copyJsonArray = new JSONArray();
            for (int i = 0; i < jsonArray.length(); i++){
                if( i != position ){
                    JSONObject userInfo = jsonArray.getJSONObject(i);
                    copyJsonArray.put(userInfo);
                }
            }
            JSONObject newJsonObject = new JSONObject();
            newJsonObject.put("clients",copyJsonArray);
            return String.valueOf(newJsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }


}