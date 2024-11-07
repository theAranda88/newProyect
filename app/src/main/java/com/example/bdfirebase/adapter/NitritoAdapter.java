package com.example.bdfirebase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdfirebase.H2o;
import com.example.bdfirebase.Nitrito;
import com.example.bdfirebase.R;

import java.util.List;

public class NitritoAdapter extends RecyclerView.Adapter<NitritoAdapter.ViewHolder>{
    private List<Nitrito> nitritoList;

    public NitritoAdapter(List<Nitrito> nitritoList) {
        this.nitritoList = nitritoList;
    }
    @NonNull
    @Override
    public NitritoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_h2o, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NitritoAdapter.ViewHolder holder, int position) {
        Nitrito nitrito = nitritoList.get(position);
        holder.txtEstadoSensor.setText(nitrito.getEstadoN());
        holder.txtValorSensor.setText(nitrito.getValorMedidoN());
        holder.txtCodigoSensor.setText(nitrito.getCodigoNitratoN());
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
