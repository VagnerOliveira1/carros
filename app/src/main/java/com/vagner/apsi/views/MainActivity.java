package com.vagner.apsi.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vagner.apsi.R;
import com.vagner.apsi.adapter.CarListAdapter;
import com.vagner.apsi.contants.CarrosContants;
import com.vagner.apsi.data.CarMock;
import com.vagner.apsi.entities.Car;
import com.vagner.apsi.listener.OnListClickInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Variáveis da classe
    private ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Instancia variáveis
        this.mContext = this;

        // Instacia mock
        CarMock carMock = new CarMock(this);
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        // 1 - Obter a recyclerview
        this.mViewHolder.mRecyclerCars = (RecyclerView) this.findViewById(R.id.recycler_cars);

        // Implementa o evento de click para passar por parâmetro para a ViewHolder
        OnListClickInteractionListener listener = new OnListClickInteractionListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosContants.CARRO_ID, id);

                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        };

        // 2 - Definir adapter passando listagem de carros e listener
        CarListAdapter carListAdapter = new CarListAdapter(carList, listener);
        this.mViewHolder.mRecyclerCars.setAdapter(carListAdapter);

        // 3 - Definir um layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.mRecyclerCars.setLayoutManager(linearLayoutManager);

    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        RecyclerView mRecyclerCars;
    }

}
