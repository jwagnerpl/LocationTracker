package teamtreehouse.com.locationtracker.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import teamtreehouse.com.locationtracker.Model.MapLocation;

@Dao
public interface LocationDao {

    @Query("SELECT * FROM maplocation WHERE locationDate > :startDate AND locationDate < :endDate")
    public List<MapLocation> getAllLocations(Long startDate, Long endDate);

    @Insert
    public void insertAll (MapLocation... locations);

}
