package com.example.root.rttoolbox;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.nio.channels.Pipe;
import java.util.List;

public class PipeRepository {
    private PipeDao mPipeDao;
    private LiveData<List<PipeSizeEntity>> mAllPipes;

    PipeRepository(Application application) {
        PipeRoomDatabase db = PipeRoomDatabase.getDatabase(application);
        mPipeDao = db.pipeDao();
        mAllPipes = mPipeDao.getAllPipeSizes();
    }

    LiveData<List<PipeSizeEntity>> getAllPipes() {return mAllPipes;}

    public void insert (PipeSizeEntity pipeSizeEntity) {
        new insertAsyncTask(mPipeDao).execute((Runnable) pipeSizeEntity);
    }

    private static class insertAsyncTask extends AsyncTask<PipeSizeEntity, Void, Void> {

        private PipeDao mAsyncTaskDao;

        insertAsyncTask(PipeDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final PipeSizeEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
