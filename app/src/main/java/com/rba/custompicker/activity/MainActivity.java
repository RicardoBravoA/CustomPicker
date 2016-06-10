package com.rba.custompicker.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rba.custompicker.R;
import com.rba.custompicker.control.view.CustomDatePickerView;
import com.rba.custompicker.control.listener.OnDateSelectListener;
import com.rba.custompicker.util.Constant;
import com.rba.custompicker.util.Util;
import java.util.Date;

public class MainActivity extends BaseActivity implements OnDateSelectListener, View.OnClickListener {

    private TextView lblSince, lblTo;
    private Date dateSince = null, dateTo = null;
    private Button btnShow;
    CustomDatePickerView cdpView;
    View cpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpView = findViewById(R.id.cpView);
        lblSince = (TextView) findViewById(R.id.lblSince);
        lblTo = (TextView) findViewById(R.id.lblTo);
        btnShow = (Button) findViewById(R.id.btnShow);
        cdpView = new CustomDatePickerView(this, CustomDatePickerView.Type.YEAR_MONTH);

        cdpView.setDate(new Date());
        cdpView.setCyclic(true);
        cdpView.setCancelable(true);
        cdpView.setOnDateSelectListener(this);
        lblSince.setOnClickListener(this);
        btnShow.setOnClickListener(this);
        lblTo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lblSince:
                cdpView.setVariable(Constant.VARIABLE_SINCE);
                if(dateSince!=null){
                    cdpView.setDate(dateSince);
                }
                cdpView.verifyDates(dateSince, dateTo);
                cdpView.show();
                break;
            case R.id.lblTo:
                cdpView.setVariable(Constant.VARIABLE_TO);
                if(dateTo!=null){
                    cdpView.setDate(dateTo);
                }
                cdpView.verifyDates(dateSince, dateTo);
                cdpView.show();
                break;
            case R.id.btnShow:
                validate();
                break;
            default:
                break;
        }
    }

    private boolean validate(){
        if(dateSince==null){
            Toast.makeText(this, getString(R.string.since_date), Toast.LENGTH_SHORT).show();
            return false;
        }

        if(dateTo==null){
            Toast.makeText(this, getString(R.string.to_date), Toast.LENGTH_SHORT).show();
            return false;
        }

        Toast.makeText(this, getString(R.string.show_message,
                Util.getDateString(this, dateSince), Util.getDateString(this, dateTo)), Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onDateSelect(Date date, int variable) {
        cdpView.show();
        switch (variable){
            case Constant.VARIABLE_SINCE:
                dateSince = date;
                lblSince.setText(Util.getDateString(this, date));
                break;
            case Constant.VARIABLE_TO:
                dateTo = date;
                lblTo.setText(Util.getDateString(this, date));
                break;
            default:
                break;
        }
    }

}
