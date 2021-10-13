package com.example.mydesk.model;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AgendamentoModel {

    private String id;
    private String id_cliente;
    private String data;
    private String horario;


    public AgendamentoModel(String id, String id_cliente, String data, String horario) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.data = data;
        this.horario = horario;
    }

    public AgendamentoModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public  void removerReserva(String reservaSelecionada){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        ArrayList<String> list  = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("agendamentos");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list.clear();
                AgendamentoModel registro = new AgendamentoModel();
                for(DataSnapshot snapshot : datasnapshot.getChildren()) {
                    if (currentUser.getUid().equals(snapshot.child("id_cliente").getValue().toString())
                    && reservaSelecionada.equals(snapshot.child("horario").getValue().toString())){
                        snapshot.getRef().removeValue();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public  void salvar(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("agendamentos").push().setValue(this);
    }
}
