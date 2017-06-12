package project.customlist.com.myapplication.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import project.customlist.com.myapplication.R;
import project.customlist.com.myapplication.adapter.CardAdapter;
import project.customlist.com.myapplication.card.CardResponse;
import project.customlist.com.myapplication.service.APIService;
import project.customlist.com.myapplication.swipelistview.SwipeListView;
import project.customlist.com.myapplication.util.CommonFunc;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    ListView lst_cards;
    SwipeListView lst_swipecards;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst_cards = (ListView) findViewById(R.id.lst_cards);
        lst_swipecards = (SwipeListView) findViewById(R.id.swipe_listview);
        getFeedData();
    }

    public void getFeedData()
    {
        progressDialog = CommonFunc.createProgressDialog(this);
        progressDialog.show();

        APIService.getInstance().getService().getFeed(new Callback<CardResponse>() {
            @Override
            public void success(CardResponse result, Response response) {

                ArrayList<Integer> layouts = new ArrayList<Integer>();

                layouts.add(R.layout.layout_card_2);
                layouts.add(R.layout.layout_card_3);
                layouts.add(R.layout.layout_card_4);
                layouts.add(R.layout.layout_card_5);
                layouts.add(R.layout.layout_card_6);

                CardAdapter cardAdapter = new CardAdapter(MainActivity.this, R.layout.layout_card_1, result.getItems(), layouts);
                lst_cards.setAdapter(cardAdapter);
                lst_swipecards.setAdapter(cardAdapter);


                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, result.getItems().get(0)._id, Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
