package com.example.mydesk.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mydesk.MainActivity;
import com.example.mydesk.R;
import com.example.mydesk.model.AgendamentoModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Appointment extends AppCompatActivity {

    private Button buttonDatePicker;
    private Button  btn_agendar;
    private RadioGroup radioGroup;
    private Spinner spinner_horario;
    private DatePickerDialog datePickerDialog;
    private ArrayList<String> list ;
    private ArrayAdapter<String> adapter ;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;
    private RadioButton radioButton8;
    private RadioButton radioButton9;
    private RadioButton radioButton10;
    private RadioButton radioButton11;
    private RadioButton radioButton12;
    private RadioButton radioButton13;
    private RadioButton radioButton14;
    private RadioButton radioButton15;
    private RadioButton radioButton16;
    private RadioButton radioButton17;
    private RadioButton radioButton18;
    private RadioButton radioButton19;
    private RadioButton radioButton20;
    private RadioButton radioButton21;
    private RadioButton radioButton22;
    private RadioButton radioButton23;
    private RadioButton radioButton24;
    private RadioButton radioButton25;
    private RadioButton radioButton26;
    private RadioButton radioButton27;
    private RadioButton radioButton28;
    private RadioButton radioButton29;
    private RadioButton radioButton30;
    private RadioButton radioButton31;
    private RadioButton radioButton32;
    private RadioButton radioButton33;
    private RadioButton radioButton34;
    private RadioButton radioButton35;
    private RadioButton radioButton36;

    private CompoundButton previousCheckedCompoundButton;
    private List<RadioButton> radios;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        initDatePicker();

        list = new ArrayList<>();
        radios = new ArrayList<RadioButton>();
        adapter = new ArrayAdapter<String>(this, R.layout.list_horarios, list);
        initHorarios();
        verificaDisponibilidade();
        buttonDatePicker = findViewById(R.id.buttonDatePicker);
        buttonDatePicker.setText(getTodaysDate());
        btn_agendar = findViewById(R.id.btn_agendar);
        spinner_horario = findViewById(R.id.spinner_horario);
        spinner_horario.setAdapter(adapter);

        setViewbyID();
        setRadioButtons();
        addListRadios();

        btn_agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                AgendamentoModel agendamento = new AgendamentoModel();

                agendamento.setId_cliente(currentUser.getUid());
                agendamento.setData(buttonDatePicker.getText().toString());
                agendamento.setHorario(getRadioButtonSelected().getText().toString());

                agendamento.salvar();
                Toast.makeText(Appointment.this, "Reserva efetuada com sucesso!", Toast.LENGTH_SHORT).show();
                abrirTelaPrincipal();
            }
        });
    }

    private void addListRadios() {
        radios.add(radioButton);
        radios.add(radioButton2);
        radios.add(radioButton3);
        radios.add(radioButton4);
        radios.add(radioButton5);
        radios.add(radioButton6);
        radios.add(radioButton7);
        radios.add(radioButton8);
        radios.add(radioButton9);
        radios.add(radioButton10);
        radios.add(radioButton11);
        radios.add(radioButton12);
        radios.add(radioButton13);
        radios.add(radioButton14);
        radios.add(radioButton15);
        radios.add(radioButton16);
        radios.add(radioButton17);
        radios.add(radioButton18);
        radios.add(radioButton19);
        radios.add(radioButton20);
        radios.add(radioButton21);
        radios.add(radioButton22);
        radios.add(radioButton23);
        radios.add(radioButton24);
        radios.add(radioButton25);
        radios.add(radioButton26);
        radios.add(radioButton27);
        radios.add(radioButton28);
        radios.add(radioButton29);
        radios.add(radioButton30);
        radios.add(radioButton31);
        radios.add(radioButton32);
        radios.add(radioButton33);
        radios.add(radioButton34);
        radios.add(radioButton35);
        radios.add(radioButton36);

    }

    private void setViewbyID() {
        radioButton  =  findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);
        radioButton7 = findViewById(R.id.radioButton7);
        radioButton8 = findViewById(R.id.radioButton8);
        radioButton9 = findViewById(R.id.radioButton9);
        radioButton10 = findViewById(R.id.radioButton10);
        radioButton11 = findViewById(R.id.radioButton11);
        radioButton12 = findViewById(R.id.radioButton12);
        radioButton13 =  findViewById(R.id.radioButton13);
        radioButton14 = findViewById(R.id.radioButton14);
        radioButton15 = findViewById(R.id.radioButton15);
        radioButton16 = findViewById(R.id.radioButton16);
        radioButton17 =findViewById(R.id.radioButton17);
        radioButton18 = findViewById(R.id.radioButton18);
        radioButton19 = findViewById(R.id.radioButton19);
        radioButton20 = findViewById(R.id.radioButton20);
        radioButton21 = findViewById(R.id.radioButton21);
        radioButton22 = findViewById(R.id.radioButton22);
        radioButton23 = findViewById(R.id.radioButton23);
        radioButton24 = findViewById(R.id.radioButton24);
        radioButton25 = findViewById(R.id.radioButton25);
        radioButton26 = findViewById(R.id.radioButton26);
        radioButton27 = findViewById(R.id.radioButton27);
        radioButton28 = findViewById(R.id.radioButton28);
        radioButton29 = findViewById(R.id.radioButton29);
        radioButton30 = findViewById(R.id.radioButton30);
        radioButton31 = findViewById(R.id.radioButton31);
        radioButton32 = findViewById(R.id.radioButton32);
        radioButton33 = findViewById(R.id.radioButton33);
        radioButton34 = findViewById(R.id.radioButton34);
        radioButton35 = findViewById(R.id.radioButton35);
        radioButton36 = findViewById(R.id.radioButton36);
    }

    private void initHorarios() {
        list.add("A1");
        list.add("A2");
        list.add("A3");
        list.add("A4");
        list.add("A5");
        list.add("A6");
        list.add("A7");
        list.add("A8");
        list.add("A9");
        list.add("B1");
        list.add("B2");
        list.add("B3");
        list.add("B4");
        list.add("B5");
        list.add("B6");
        list.add("B7");
        list.add("B8");
        list.add("B9");
        list.add("C1");
        list.add("C2");
        list.add("C3");
        list.add("C4");
        list.add("C5");
        list.add("C6");
        list.add("C7");
        list.add("C8");
        list.add("C9");
        list.add("D1");
        list.add("D2");
        list.add("D3");
        list.add("D4");
        list.add("D5");
        list.add("D6");
        list.add("D7");
        list.add("D8");
        list.add("D9");
    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(Appointment.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private String getTodaysDate() {
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        mes += 1;
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        return makeDateString(dia,mes,ano);
    }

    public void initDatePicker(){

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = makeDateString(dayOfMonth,month,year);
                buttonDatePicker.setText(date);
                list.clear();
                initHorarios();
                verificaDisponibilidade();
            }
        };

        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, ano, mes, dia);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//        datePickerDialog.getDatePicker().setMaxDate((System.currentTimeMillis() - 1000)+(1000*60*60*24*7));
    }

    private void verificaDisponibilidade() {
        DatabaseReference referenceAgendamento = FirebaseDatabase.getInstance().getReference().child("agendamentos");
        referenceAgendamento.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot snapshot : datasnapshot.getChildren()){
                    if (buttonDatePicker.getText().toString().equals(snapshot.child("data").getValue().toString())){
                        for (int i=0; i<list.size();i++){
                            if (list.get(i).equals(snapshot.child("horario").getValue().toString())){
                                list.remove(i);
                            }
                        }
                    }
                }
                Collections.sort(list);
                adapter.notifyDataSetChanged();
                enableRadioButtons();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private String makeDateString(int dayOfMonth, int month, int year) {
        return dayOfMonth + " " + getMonthFormat(month) + " " + year;
    }
    public RadioButton getRadioButtonSelected(){

        RadioButton radio;
        for(int i=0;i<radios.size();i++){
            if(radios.get(i).isChecked()){
                return radios.get(i);
            }
        }
        return null;
    }

    public void enableRadioButtons(){
        for(int i=0;i<radios.size();i++){
            radios.get(i).setEnabled(false);
            for(int j=0;j<list.size();j++){
                if(radios.get(i).getText().equals(list.get(j))){
                    radios.get(i).setEnabled(true);
                    if(j==0){
                        radios.get(i).setChecked(true);
                    }
                }
            }
        }
    }

    private String getMonthFormat(int month) {
        switch (month){
            case 1:
                return "de janeiro de ";
            case 2:
                return "de fevereiro de";
            case 3:
                return "de março de ";
            case 4:
                return "de abril de ";
            case 5:
                return "de maio de";
            case 6:
                return "de junho de";
            case 7:
                return "de julho de";
            case 8:
                return "de agosto de";
            case 9:
                return "de setembro de";
            case 10:
                return "de outubro de";
            case 11:
                return "de novembro de";
            case 12:
                return "de dezembro de";
            default:
                return "de janeiro de";
        }
    }

    public void setRadioButtons(){

        CompoundButton.OnCheckedChangeListener onRadioButtonCheckedListener = new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) return;
                if (previousCheckedCompoundButton != null) {
                    previousCheckedCompoundButton.setChecked(false);
                    previousCheckedCompoundButton = buttonView;
                } else {
                    previousCheckedCompoundButton = buttonView;
                }
            }
        };

        radioButton.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton2.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton3.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton4.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton3.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton4.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton5.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton6.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton7.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton8.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton9.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton10.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton11.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton12.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton13.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton14.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton15.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton16.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton17.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton18.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton19.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton20.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton21.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton22.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton23.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton24.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton25.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton26.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton27.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton28.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton29.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton30.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton31.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton32.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton33.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton34.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton35.setOnCheckedChangeListener(onRadioButtonCheckedListener);
        radioButton36.setOnCheckedChangeListener(onRadioButtonCheckedListener);
    }

    public void openDataPicker(View view) {
        datePickerDialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Appointment.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}