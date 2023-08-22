package com.trkmn.javalandmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trkmn.javalandmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    //MainActivity'de landmarkArrayList boyutunu parametre olarak alabilmek için bunu yaptık
    ArrayList<Landmark> landmarkArrayList;
    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ViewHolder sınıfından obje oluşturulduğunda çalışacak metod
        //Xml bağlama işlemini burada yapıyoruz

        //parent.getContext() -> Bağlanacağı yerdeki context
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        //ViewHolder bağlandığında neler olacak onları yazdığımız sınıf
        //Kısacası layout içinde hangi verileri göstermek istiyorsak burada göstereceğiz

        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { //xml'in kaç defa oluşturulacağını söyleyecek
        return landmarkArrayList.size();
    }

    //Görünümlerimizi tutan yardımcı bir sınıf - View holder
    public class LandmarkHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}


/** 4 adımı var
 * 1. adım view holder oluşturmak
 * 3 tane de implement etmemiz gereken metod var
 */
