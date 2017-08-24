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
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.man.movieviewer.R;
import demo.man.movieviewer.data.moviepopular.Movie;
import demo.man.movieviewer.util.alog.MyLog;
import demo.man.movieviewer.util.define.DfLink;

/**
 * Created by duong on 23/08/2017.
 */

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    private List<Movie> movies;
    private Context context;
    private PopularView popularView;
    private RequestOptions requestOptions;

    public PopularAdapter(PopularView view, List<Movie> movies) {
        this.movies = movies;
        popularView = view;
        requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }

    @Override
    public PopularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.movie_grid_item, parent, false);
        return new PopularViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PopularViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        holder.movie = movies.get(position);
        holder.name.setText(holder.movie.getTitle());
        MyLog.e("load image:" + position);
        Glide.with(context)
                .load(DfLink.POSTER_PATH + holder.movie.getPosterPath())
                .apply(requestOptions)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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

        @Override
        public void onClick(View view) {
//            PopularAdapter.this.popularView.onItemClick(movie);

        }
    }

}

