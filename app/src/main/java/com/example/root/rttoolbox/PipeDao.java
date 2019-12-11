package com.example.root.rttoolbox;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PipeDao {
    /**
     * @param pipeSizeEntity
     */
    @Insert
    void insert(PipeSizeEntity pipeSizeEntity);

    @Query("DELETE FROM pipe_table")
    void deleteAll();

    @Query("SELECT * from pipe_table ORDER BY mSizeCategory ASC")
    LiveData<List<PipeSizeEntity>> getAllPipeSizes();

    //TODO: Finish building QUERY to add all pipe schedules.
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * from pipe_table WHERE mNPSPipeSize = :searchparam LIMIT 1")
    PipeSizeEntity getPipeSched(String searchparam);

    //TODO: Fix this onconflict strategy thing below. Returns error.
    // @Insert(onConflict = OnConflictStrategy.REPLACE);


}
