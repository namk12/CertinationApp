package pls.certination.com.Pls.learning.Result;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import pls.certination.com.certination.R;


public class graph_view extends Activity {

    private View mChart;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_view);
        // Getting reference to the button btn_chart
        Button btnChart = (Button) findViewById(R.id.btn_chart);
        // Defining click event listener for the button btn_chart
        btnChart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Draw the pie Chart
                openChart();

            }
        });



        // Setting event click listener for the button btn_chart of the
        // MainActivity layout

    }

    private void openChart() {

        // Pie Chart Section Names
        String[] code = new String[] { "English", "Hindi", "Math", "Physics", "Chemistry" };


        // Pie Chart Section Value
        float[] data1;
        Bundle bundle;
        bundle = getIntent().getExtras();
        data1 = bundle.getFloatArray("marks");
        // Color of each Pie Chart Sections
        int[] colors = { Color.BLUE, Color.MAGENTA, Color.GREEN, Color.CYAN, Color.RED };
        // Instantiating CategorySeries to plot Pie Chart
        CategorySeries distributionSeries = new CategorySeries("Marks of Student");
        for (int i = 0; i < data1.length; i++) {
            // Adding a slice with its values and name to the Pie Chart
            distributionSeries.add(code[i],data1[i]);
        }
        // Instantiating a renderer for the Pie Chart
        DefaultRenderer defaultRenderer = new DefaultRenderer();

        for (int i = 0; i < data1.length; i++) {
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            seriesRenderer.setDisplayChartValues(true);
//Adding colors to the chart
            defaultRenderer.setBackgroundColor(R.drawable.download);
            defaultRenderer.setApplyBackgroundColor(true);
            // Adding a renderer for a slice
            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }
        defaultRenderer.setChartTitle("Marks of Student");
        defaultRenderer.setChartTitleTextSize(20);
        defaultRenderer.setZoomButtonsVisible(true);
        defaultRenderer.setPanEnabled(false);
        // this part is used to display graph on the xml
        // Creating an intent to plot bar chart using dataset and
        // multipleRenderer
        // Intent intent = ChartFactory.getPieChartIntent(getBaseContext(),
        // distributionSeries , defaultRenderer, "AChartEnginePieChartDemo");

        // Start Activity
        // startActivity(intent);

        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart);
        // remove any views before u paint the chart
        chartContainer.removeAllViews();
        // drawing pie chart
        mChart = ChartFactory.getPieChartView(getBaseContext(),
                distributionSeries, defaultRenderer);
        // adding the view to the linearlayout
        chartContainer.addView(mChart);

    }

}
