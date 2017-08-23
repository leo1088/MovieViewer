package demo.man.movieviewer.ui.popular.fragment.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.man.movieviewer.R;
import demo.man.movieviewer.data.moviepopular.Movie;

/**
 * Created by duong on 23/08/2017.
 */

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private List<Movie> movies;
    private Context context;
    private PopularView popularView;

    public PopularAdapter(PopularView view, List<Movie> movies) {
        this.movies = movies;
        popularView = view;
    }

    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.movie_grid_item, parent, false);
        return new PopularViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PopularViewHolder holder, int position) {
        holder.movie = movies.get(position);
        holder.name.setText(holder.movie.getTitle());
        Glide.with(context)
                .load(holder.movie.getPosterPath())
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_poster)
        ImageView poster;
        @BindView(R.id.title_background)
        View titleBackground;
        @BindView(R.id.movie_name)
        TextView name;
        public Movie movie;
        public PopularViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

