package com.example.market;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_option_market;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_option_market = findViewById(R.id.recyclerViewMain);

        ArrayList<Item> itemList = new ArrayList<Item>();

        ListItemMarketAdapterActivity adapter = new ListItemMarketAdapterActivity(R.layout.activity_list_item_market_adapter, itemList);

        rv_option_market.setAdapter(adapter);
        rv_option_market.setLayoutManager(new LinearLayoutManager(this));

        for (int i=0; i<10; i++){
            itemList.add(new Item("Frutas", "Frutas frescas do jardim", R.drawable.frutas));
            itemList.add(new Item("Vegetais", "Vegetais cozidos ou crus", R.drawable.vegetais));
            itemList.add(new Item("Padaria", "Diversos tipos de Pães e Massas", R.drawable.padaria));
            itemList.add(new Item("Bebidas", "Suco, Café, e Refrigerante", R.drawable.bebidas));
        }

        adapter.notifyDataSetChanged();
    }
}