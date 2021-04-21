package com.example.sharkgym3.Models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sharkgym3.R;
import com.example.sharkgym3.views.MyApplication;

import java.util.ArrayList;

public class PersonAdapter  extends RecyclerView.Adapter<PersonAdapter.personViewHolder>
    implements View.OnClickListener {

    private ArrayList<PersonEntity> items;
    private View.OnClickListener listener;

    public static class personViewHolder extends RecyclerView.ViewHolder {

        private TextView TextView_id;
        private TextView TextView_nombre;
        private ImageView ImageView_foto;

        public personViewHolder(View itemView) {
            super(itemView);
            ImageView_foto=(ImageView) itemView.findViewById(R.id.photo);
            TextView_id = (TextView) itemView.findViewById(R.id.firstName);
            TextView_nombre = (TextView) itemView.findViewById(R.id.firstName2);
        }

        public void PersonBind(PersonEntity item) {
            if(!item.getImage().equals("")){
                byte[] decodedString = Base64.decode(item.getImage(), Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                ImageView_foto.setImageBitmap(decodedByte);
            }else{
                ImageView_foto.setImageDrawable(MyApplication.getContext().getDrawable(R.drawable.ic_launcher_foreground));
            }
            TextView_id.setText(item.getName());
            TextView_nombre.setText(item.getSurname());
        }
    }

    // Contruye el objeto adaptador recibiendo la lista de datos
    public PersonAdapter(@NonNull ArrayList<PersonEntity> items) {
        this.items = items;
    }


    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    @NonNull
    @Override
    public personViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_user, parent, false);
        row.setOnClickListener(this);

        personViewHolder avh = new personViewHolder(row);
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull personViewHolder holder, int position) {
        PersonEntity item = items.get(position);
        holder.PersonBind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // Asigna un listener al elemento
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }



}
