package com.example.bdfirebase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdfirebase.H2o;
import com.example.bdfirebase.R;

import java.util.List;

public class H2oAdapter extends RecyclerView.Adapter<H2oAdapter.ViewHolder>{
    private List<H2o> H2oList;

    public H2oAdapter(List<H2o> H2oList) {
        this.H2oList = H2oList;
    }
    @NonNull
    @Override
    public H2oAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_h2o, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull H2oAdapter.ViewHolder holder, int position) {
        H2o h2o = H2oList.get(position);
        holder.txtEstadoSensor.setText(h2o.getEstadoH2o());
        holder.txtValorSensor.setText(h2o.getValorMedidoH2o());
        holder.txtCodigoSensor.setText(h2o.getCodigoSensorH2o());
    }

    @Override
    public int getItemCount() {
        return H2oList.size();
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
