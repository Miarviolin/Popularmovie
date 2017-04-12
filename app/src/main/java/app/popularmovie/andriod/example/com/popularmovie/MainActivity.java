package app.popularmovie.andriod.example.com.popularmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements MainActivityFragment.Callback  {
    private boolean mTwoPane;
    @Override
       protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

        if (findViewById(R.id.movie_detail_container) != null) {
                       mTwoPane = true;
                       if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                  .replace(R.id.movie_detail_container, new DetailActivityFragment(),
                   DetailActivityFragment.TAG).commit();
                          }
                    } else {
                        mTwoPane = false;
                    }
            }


       public void onItemSelected(Movie movie) {
                if (mTwoPane) {
                      Bundle arguments = new Bundle();
                        arguments.putParcelable(DetailActivityFragment.DETAIL_MOVIE, movie);

                         DetailActivityFragment fragment = new DetailActivityFragment();
                        fragment.setArguments(arguments);

                       getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.movie_detail_container, fragment, DetailActivityFragment.TAG)
                                        .commit();
                    } else {
                        Intent intent = new Intent(this, DetailActivity.class)
                                        .putExtra(DetailActivityFragment.DETAIL_MOVIE, movie);
                        startActivity(intent);
                    }
    }		      }


