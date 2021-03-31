package za.co.shrinkspace.mvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.shrinkspace.mvp.R;
import za.co.shrinkspace.mvp.models.Business;

public class BusinessAdapter  extends RecyclerView.Adapter<BusinessAdapter.MyViewHolder>{

    private List<Business> businessList;
    private Context context;

    public BusinessAdapter(List<Business> businessList, Context context) {
        this.businessList = businessList;
        this.context = context;
    }

    @NonNull
    @Override
    public BusinessAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_business,parent
                ,false);
        return new BusinessAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return businessList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
