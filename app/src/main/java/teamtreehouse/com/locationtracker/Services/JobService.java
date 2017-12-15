package teamtreehouse.com.locationtracker.Services;

import android.app.job.JobParameters;
import android.content.Intent;
import android.util.Log;

public class JobService extends android.app.job.JobService {
    private static final String TAG = "SyncService";

    @Override
    public boolean onStartJob(JobParameters params) {
        Intent service = new Intent(getApplicationContext(), MappingService.class);
        getApplicationContext().startService(service);
        Util.scheduleJob(getApplicationContext()); // reschedule the job
        Log.d(TAG, "jobStarted");
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }
}
