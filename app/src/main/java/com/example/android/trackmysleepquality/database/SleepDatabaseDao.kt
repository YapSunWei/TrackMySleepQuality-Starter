/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.*




@Dao
interface SleepDatabaseDao {

    /*
    * 1. Insert new night into daily_sleep_quality_table
    * @param night new value to insert
    * */
    @Insert
    fun insert(night: SleepNight)


    /*
    * 2. Update an existing night to update an end time and a quality rating.
    *
    * @param night new value to update
    * */
    @Update
    fun update(night: SleepNight)

    /*
    * 3. Get a specific night based on its key.
    *
    * @param key to get specific nights*/
    @Query("SELECT * from daily_sleep_quality_table WHERE nightId= :key")
    fun get(key: Long): SleepNight?

    /*
    * 4. Get all nights, so you can display them.
    *
    **/
    @Query("SELECT * from daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>

    /*
    * 5. Get the most recent night.
    *
    * */
    @Query("SELECT * from daily_sleep_quality_table ORDER BY nightId DESC Limit 1")
    fun getTonight(): SleepNight?

    /*
    * 6. Delete all entries in the database.
    *
    * */
    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()
}

