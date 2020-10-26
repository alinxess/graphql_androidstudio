package com.example.mytry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.mytry.util.AplClient;

import org.jetbrains.annotations.NotNull;

public class  MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textID);
        getStuff();
    }

    private void getStuff(){
        AplClient.getmApolloClient()
                .query(GreetingQuery.builder().build())
                .enqueue(new ApolloCall.Callback<GreetingQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<GreetingQuery.Data> response) {
                       final String msg= response.data().hello();

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(msg);
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException t) {

                    }
                });
    }
}
