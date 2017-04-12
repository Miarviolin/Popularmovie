package app.popularmovie.andriod.example.com.popularmovie;

/**
 * Created by STAR on 20/08/2016.
 */
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class DetailActivity extends ActionBarActivity {
 @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(DetailActivityFragment.DETAIL_MOVIE,
            getIntent().getParcelableExtra(DetailActivityFragment.DETAIL_MOVIE));
            DetailActivityFragment fragment = new DetailActivityFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
            .add(R.id.movie_detail_container, fragment)
              .commit();
                    }
           }
    }