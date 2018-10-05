package com.vagner.apsi.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.vagner.apsi.R;
import com.vagner.apsi.contants.CarrosContants;
import com.vagner.apsi.data.CarMock;
import com.vagner.apsi.entities.Car;

public class DetailsActivity extends AppCompatActivity {

    // Variáveis da classe
    private ViewHolder mViewHolder = new ViewHolder();
    private CarMock mCarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Instancia variáveis
        this.mCarMock = new CarMock(this);

        // Instancia elementos de interfacew
        this.mViewHolder.imgCarPicture = (ImageView) this.findViewById(R.id.img_car_pic);
        this.mViewHolder.textModel = (TextView) this.findViewById(R.id.text_model);
        this.mViewHolder.textManufacturer = (TextView) this.findViewById(R.id.text_manufacturer);
        this.mViewHolder.textHorsePower = (TextView) this.findViewById(R.id.text_horse_power);
        this.mViewHolder.textPrice = (TextView) this.findViewById(R.id.text_price);

        // Obtém o valor passado por parâmetro
        this.getDataFromActivity();

        // Atribui os valores aos elementos de interface
        this.setData();

    }

    /**
     * Atribui os valores aos elementos de interface
     */
    private void setData() {
        this.mViewHolder.imgCarPicture.setImageDrawable(this.mCar.picture);
        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textManufacturer.setText(String.valueOf(this.mCar.manufacturer));
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.mViewHolder.textPrice.setText("R$ " + String.valueOf(this.mCar.price));
    }

    /**
     * Obtém o valor passado por parâmetro
     */
    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mCar = this.mCarMock.get(extras.getInt(CarrosContants.CARRO_ID));
        }
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder {
        ImageView imgCarPicture;
        TextView textModel;
        TextView textManufacturer;
        TextView textHorsePower;
        TextView textPrice;
    }

}
