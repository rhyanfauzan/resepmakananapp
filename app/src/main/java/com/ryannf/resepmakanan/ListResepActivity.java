package com.ryannf.resepmakanan;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListResepActivity extends AppCompatActivity {

    ListView lv;

    int[] iconList = new int[]{
            R.drawable.ayamgeprek, R.drawable.ayamkatsu, R.drawable.ayamkrispi, R.drawable.bakwan,
            R.drawable.mieramen, R.drawable.muffin, R.drawable.nasikuning, R.drawable.sayurlodeh, R.drawable.telurbalado,
            R.drawable.telurdadar, R.drawable.ayamgeprek, R.drawable.ayamkatsu, R.drawable.ayamkrispi,
            R.drawable.bakwan, R.drawable.mieramen, R.drawable.muffin, R.drawable.nasikuning,
            R.drawable.sayurlodeh, R.drawable.telurbalado, R.drawable.telurdadar,
            R.drawable.ayamgeprek, R.drawable.ayamkatsu, R.drawable.ayamkrispi, R.drawable.bakwan,
            R.drawable.mieramen, R.drawable.muffin, R.drawable.nasikuning,
            R.drawable.sayurlodeh, R.drawable.telurbalado
    };

    String[] Headline = {"Ayam Geprek", "Ayam Katsu", "Ayam Crispy", "SnapChat",
            "WhatsApp", "LINE", "KakaoTalk", "Telegram", "Messenger",
            "YouTube", "TikTok", "Vine", "Vimeo",
            "Figma", "Adobe XD", "Sketch", "Framer",
            "Android", "iOS", "Windows",
            "Opera", "Mozilla", "Safari", "Edge",
            "Paypal", "Mastercard", "Visa",
            "Bitcoin", "Ethereum"
    };

    String[] Subhead = {"Resep Cara membuat Ayam Geprek", "Social Media", "Social Media", "Social Media",
            "Chatting App", "Chatting App", "Chatting App", "Chatting App", "Chatting App",
            "Video Streaming App", "Video Streaming App", "Video Streaming App", "Video Streaming App",
            "UI Design App", "UI Design App", "UI Design App", "UI Design App",
            "Operating System", "Operating System", "Operating System",
            "Browser App", "Browser App", "Browser App", "Browser App",
            "Payment Method", "Payment Method", "Payment Method",
            "Cryptocurrency", "Cryptocurrency"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_resep);

        lv = findViewById(R.id.list);
        ListAdapter listAdapter = new ListAdapter(this, iconList, Headline, Subhead);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Facebook.class);
                    startActivityForResult(intent, 0);
                }

                //Position 1 is Twitter

                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Instagram.class);
                    startActivityForResult(intent, 0);
                }

                //Do the same thing next time

                Toast.makeText(getApplicationContext(),
                        "You have selected : " + Headline[position],
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}