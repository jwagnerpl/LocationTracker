package teamtreehouse.com.locationtracker.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import teamtreehouse.com.locationtracker.Model.MapLocation;

@Database(entities = {MapLocation.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LocationDao locationDao();

}
