package com.example.sir_c.grafica;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarChart bcGrafica = (BarChart) findViewById(R.id.chbDemo);

        //Valores de cada columna
        List<BarEntry> datos = new ArrayList<>();
        datos.add(new BarEntry(0f, 30f));
        datos.add(new BarEntry(1f, 80f));
        datos.add(new BarEntry(2f, 60f));
        datos.add(new BarEntry(3f, 50f));
        datos.add(new BarEntry(4f, 70f));
        datos.add(new BarEntry(5f, 60f));

        //Declaramos un DataSet para las columnas
        BarDataSet setY = new BarDataSet(datos, "Calificaciones");
        //Ponemos el color de la barra
        setY.setColor(Color.GREEN);

        //Transformamos el DataSet a un BarData
        BarData barData = new BarData(setY);

        //Creamos un Arreglo de Datos para las etiquetas de cada barra
        final String[] setX = new String[] { "Ene", "Feb", "Mar", "Abr", "May", "Jun" };

        //Creamos un objeto para modificar las etiquetas de cada barra
        IAxisValueFormatter formatter = new IAxisValueFormatter() {
           @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return setX[(int) value];
            }
        };

        //Creamos las etiquetas de cada barra
        XAxis xDato = bcGrafica.getXAxis();
        xDato.setGranularity(1f);
        xDato.setValueFormatter(formatter);
        xDato.setPosition(XAxis.XAxisPosition.BOTTOM);

        //Agregamos una descripción a la grafica
        Description descripcion = new Description();
        descripcion.setText("Datos de Prueba");

        //Configuramos la gráfica
        barData.setBarWidth(0.9f);
        barData.setValueTextColor(Color.BLUE);
        barData.setValueTextSize(10f);
        //Asignamos los datos
        bcGrafica.setData(barData);

        bcGrafica.setDescription(descripcion);
        bcGrafica.setFitBars(true);

        //Refrescamos la gráfica
        bcGrafica.invalidate();
    }

}