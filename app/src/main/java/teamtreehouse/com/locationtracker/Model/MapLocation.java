package teamtreehouse.com.locationtracker.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "maplocation")
public class MapLocation {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "latitude")
    Double latitude;

    @ColumnInfo(name = "longitude")
    Double longitude;

    @ColumnInfo(name = "locationDate")
    Long locationDate;

    public MapLocation(Double latitude, Double longitude, Long locationDate) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDate = locationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getLocationDate() {
        return locationDate;
    }

    public void setLocationDate(Long locationDate) {
        this.locationDate = locationDate;
    }
}
