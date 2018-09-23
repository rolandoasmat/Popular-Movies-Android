package com.asmat.rolando.popularmovies.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.asmat.rolando.popularmovies.R;
import com.asmat.rolando.popularmovies.models.Cast;
import com.asmat.rolando.popularmovies.models.RoundedTransformation;
import com.squareup.picasso.Picasso;

public class CastLinearAdapter extends BaseLinearAdapter<Cast, CastLinearAdapter.ViewHolder> {

    @Override
    int getLayoutForLinearItem() {
        return R.layout.cast_linear_item;
    }

    @Override
    ViewHolder createViewHolder(View view) {
        return new CastLinearAdapter.ViewHolder(view);
    }

    class ViewHolder extends BaseLinearAdapter.ViewHolder {
        private final ImageView thumbnail;
        private final TextView name;
        private final TextView role;

        ViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            name = itemView.findViewById(R.id.name);
            role = itemView.findViewById(R.id.role);
        }

        @Override
        void bind(Object item) {
            if (item instanceof Cast) {
                Cast cast = (Cast) item;
                name.setText(cast.getName());
                role.setText(cast.getCharacter());
                String url = cast.getThumbnailURL();
                Picasso.with(thumbnail.getContext())
                        .load(url)
                        .transform(new RoundedTransformation(50, 0))
                        .into(thumbnail);
            }
        }
    }
}