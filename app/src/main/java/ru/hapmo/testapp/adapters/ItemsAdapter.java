package ru.hapmo.testapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import ru.hapmo.testapp.R;
import ru.hapmo.testapp.models.Item;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private List<Item> items;
    private int itemWidth;
    private int itemRadius;
    private int logoWidth;

    public ItemsAdapter(Context context) {
        itemWidth = (int) context.getResources().getDimension(R.dimen.item_width);
        itemRadius = (int) context.getResources().getDimension(R.dimen.item_radius);
        logoWidth = (int) context.getResources().getDimension(R.dimen.logo_width);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivLogo;
        ImageView ivItemImage;

        TextView tvItemName;
        TextView tvShopName;
        TextView tvDistance;
        TextView tvPrice;

        ViewHolder(View view) {
            super(view);

            ivLogo = view.findViewById(R.id.ivLogo);
            ivItemImage = view.findViewById(R.id.ivItemImage);
            tvItemName = view.findViewById(R.id.tvName);
            tvShopName = view.findViewById(R.id.tvShopName);
            tvDistance = view.findViewById(R.id.tvDistance);
            tvPrice = view.findViewById(R.id.tvPrice);
        }
    }

    public void setList(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position) {
        Item item = items.get(position);

        int distance = item.getPointDistance() / 1000;
        holder.tvDistance.setText(String.format("%d km", distance));
        holder.tvItemName.setText(item.getItemName());
        holder.tvPrice.setText("$" + item.getItemPrice());
        holder.tvShopName.setText(item.getShopName());

        //noinspection SuspiciousNameCombination
        Picasso.with(holder.ivItemImage.getContext())
                .load(item.getItemImage())
                .transform(new RoundedCornersTransformation(itemRadius, 0))
                .resize(itemWidth, itemWidth)
                .centerCrop()
                .into(holder.ivItemImage);

        //noinspection SuspiciousNameCombination
        Picasso.with(holder.ivLogo.getContext())
                .load(item.getShopLogo())
                .resize(logoWidth, logoWidth)
                .centerCrop()
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }
}
