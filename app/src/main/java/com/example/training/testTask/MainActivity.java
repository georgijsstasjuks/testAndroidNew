package com.example.training.testTask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.training.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String mJsonString = "{\n" +
            "  \"clients\": [\n" +
            "    {\n" +
            "      \"id\": 99872,\n" +
            "      \"username\": \"Client 1\",\n" +
            "      \"first_name\": \"Jonh\",\n" +
            "      \"last_name\": \"Snow\",\n" +
            "      \"country\": \"USA\",\n" +
            "      \"description\": \"long text with html tags <a href=\\\"http://www.google.com\\\">Google</a> some text <a href=\\\"#\\\">test link </a>\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99873,\n" +
            "      \"username\": \"Client 2\",\n" +
            "      \"first_name\": \"Vova\",\n" +
            "      \"last_name\": \"Surkov\",\n" +
            "      \"country\": \"LV\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99874,\n" +
            "      \"username\": \"Client 3\",\n" +
            "      \"first_name\": \"Jonh\",\n" +
            "      \"last_name\": \"Smith\",\n" +
            "      \"country\": \"USA\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99875,\n" +
            "      \"username\": \"Client 4\",\n" +
            "      \"first_name\": \"Nigga\",\n" +
            "      \"last_name\": \"Niggovich\",\n" +
            "      \"country\": \"NIGGER\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99876,\n" +
            "      \"username\": \"Client 5\",\n" +
            "      \"first_name\": \"Jonh\",\n" +
            "      \"last_name\": \"Snow\",\n" +
            "      \"country\": \"USA\",\n" +
            "      \"description\": \"long text with html tags <a href=\\\"http://www.google.com\\\">Google</a> some text <a href=\\\"#\\\">test link </a>\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99877,\n" +
            "      \"username\": \"Client 6\",\n" +
            "      \"first_name\": \"Vova\",\n" +
            "      \"last_name\": \"Surkov\",\n" +
            "      \"country\": \"LV\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99878,\n" +
            "      \"username\": \"Client 7\",\n" +
            "      \"first_name\": \"Jonh\",\n" +
            "      \"last_name\": \"Smith\",\n" +
            "      \"country\": \"USA\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99879,\n" +
            "      \"username\": \"Client 8\",\n" +
            "      \"first_name\": \"Nigga\",\n" +
            "      \"last_name\": \"Niggovich\",\n" +
            "      \"country\": \"NIGGER\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99880,\n" +
            "      \"username\": \"Client 9\",\n" +
            "      \"first_name\": \"Jonh\",\n" +
            "      \"last_name\": \"Snow\",\n" +
            "      \"country\": \"USA\",\n" +
            "      \"description\": \"long text with html tags <a href=\\\"http://www.google.com\\\">Google</a> some text <a href=\\\"#\\\">test link </a>\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99881,\n" +
            "      \"username\": \"Client 10\",\n" +
            "      \"first_name\": \"Vova\",\n" +
            "      \"last_name\": \"Surkov\",\n" +
            "      \"country\": \"LV\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99882,\n" +
            "      \"username\": \"Client 11\",\n" +
            "      \"first_name\": \"Jonh\",\n" +
            "      \"last_name\": \"Smith\",\n" +
            "      \"country\": \"USA\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99883,\n" +
            "      \"username\": \"Client 12\",\n" +
            "      \"first_name\": \"Nigga\",\n" +
            "      \"last_name\": \"Niggovich\",\n" +
            "      \"country\": \"NIGGER\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99884,\n" +
            "      \"username\": \"Client 13\",\n" +
            "      \"first_name\": \"Jonh\",\n" +
            "      \"last_name\": \"Snow\",\n" +
            "      \"country\": \"USA\",\n" +
            "      \"description\": \"long text with html tags <a href=\\\"http://www.google.com\\\">Google</a> some text <a href=\\\"#\\\">test link </a>\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99885,\n" +
            "      \"username\": \"Client 14\",\n" +
            "      \"first_name\": \"Vova\",\n" +
            "      \"last_name\": \"Surkov\",\n" +
            "      \"country\": \"LV\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99886,\n" +
            "      \"username\": \"Client 15\",\n" +
            "      \"first_name\": \"Jonh\",\n" +
            "      \"last_name\": \"Smith\",\n" +
            "      \"country\": \"USA\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 99887,\n" +
            "      \"username\": \"Client 16\",\n" +
            "      \"first_name\": \"Nigga\",\n" +
            "      \"last_name\": \"Niggovich\",\n" +
            "      \"country\": \"NIGGER\",\n" +
            "      \"description\": \"long text with html tags\"\n" +
            "    }\n" +
            "  ]\n" +
            "\n" +
            "}";
    private ArrayList<ClientModel> mClients = new ArrayList<>();
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getJson();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setItemsToRecycler();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null) {
            mJsonString = data.getStringExtra("newJsonString");
            mClients.clear();
            getJson();
            setItemsToRecycler();
        }
    }

    public void setItemsToRecycler(){
        RecyclerViewAdapter.OnStateClickListener stateClickListener = new RecyclerViewAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(ClientModel client, int position) {
                Intent intent = new Intent(MainActivity.this, InfoAboutClientActivity.class);
                intent.putExtra(ClientModel.class.getSimpleName(),client);
                intent.putExtra("allData",mJsonString);
                intent.putExtra("position",position);
                startActivityForResult(intent,1);
            }
        };
        RecyclerViewAdapter adapter  = new RecyclerViewAdapter(this, mClients,stateClickListener);
        mRecyclerView.setAdapter(adapter);
    }

    public void getJson(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("clients");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject userInfo = jsonArray.getJSONObject(i);
                int id = (userInfo.getInt("id"));
                String username = (userInfo.getString("username"));
                String firstName = (userInfo.getString("first_name"));
                String lastName = (userInfo.getString("last_name"));
                String country = (userInfo.getString("country"));
                String description = (userInfo.getString("description"));
                ClientModel client = new ClientModel(id,username,firstName,lastName,country,description);
                mClients.add(client);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}