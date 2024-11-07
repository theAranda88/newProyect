package com.example.bdfirebase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdfirebase.Nitrito;
import com.example.bdfirebase.R;
import com.example.bdfirebase.Temperatura;

import java.util.List;

public class TemperaturaAdapter extends RecyclerView.Adapter<TemperaturaAdapter.ViewHolder>{
    private List<Temperatura> temperaturaList;

    public TemperaturaAdapter(List<Temperatura> temperaturaList) {
        this.temperaturaList = temperaturaList;
    }

    @NonNull
    @Override
    public TemperaturaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_h2o, parent, false);
        return new TemperaturaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemperaturaAdapter.ViewHolder holder, int position) {
        Temperatura temperatura = temperaturaList.get(position);
        holder.txtEstadoSensor.setText(temperatura.getEstadoT());
        holder.txtValorSensor.setText(temperatura.getValorMedidoT());
        holder.txtCodigoSensor.setText(temperatura.getCodigoSensorT());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtCodigoSensor, txtEstadoSensor, txtValorSensor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCodigoSensor = itemView.findViewById(R.id.txtCodSensor);
            txtEstadoSensor = itemView.findViewById(R.id.txtEstadoSensor);
            txtValorSensor = itemView.findViewById(R.id.txtValorSensor);
        }
    }
}
