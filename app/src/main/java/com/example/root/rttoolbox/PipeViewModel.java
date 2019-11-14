package com.example.root.rttoolbox;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.nio.channels.Pipe;
import java.util.List;

public class PipeViewModel extends AndroidViewModel {
    private PipeRepository mPipeRepository;
    private LiveData<List<PipeSizeEntity>> mAllPipes;
    private final PipeDao pipeDao;

    public PipeViewModel(@NonNull Application application) {
        super(application);
        mPipeRepository = new PipeRepository(application);
        mAllPipes = mPipeRepository.getAllPipes();
        PipeRoomDatabase db = PipeRoomDatabase.getDatabase(application);
        pipeDao = db.pipeDao();/*
        mPipe = querier.getAllPipeSizes();
        setmPipes(querier.getAllPipeSizes());*/
    }

    LiveData<List<PipeSizeEntity>> getmAllPipes() {return pipeDao.getAllPipeSizes();}

    //public void insert(PipeSizeEntity pipe) {mPipeRepository.insert(pipe);}
}
