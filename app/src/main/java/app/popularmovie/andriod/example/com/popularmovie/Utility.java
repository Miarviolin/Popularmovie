package app.popularmovie.andriod.example.com.popularmovie;

/**
 * Created by STAR on 10/09/2016.
 */
import android.content.Context;
import android.database.Cursor;

import app.popularmovie.andriod.example.com.popularmovie.data.MovieContract;

public class Utility {

    public static int isFavorited(Context context, int id) {
        Cursor cursor = context.getContentResolver().query(
                MovieContract.MovieEntry.CONTENT_URI,
                null,   // projection
                MovieContract.MovieEntry.COLUMN_MOVIE_ID + " = ?", // selection
                new String[] { Integer.toString(id) },   // selectionArgs
                null    // sort order
        );
        int numRows = cursor.getCount();
        cursor.close();
        return numRows;
    }
    public static String buildImageUrl(int width, String fileName) {
                return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
            }
}