package com.example.pedroresende.curriculum.persistence.sqllite.contract;

import android.provider.BaseColumns;

/**
 * Created by pedroresende on 10/23/15.
 */
public class CurriculumContract {

    public CurriculumContract(){

    }

    public static abstract class WorkExperienceEntry implements BaseColumns {
        public static final String TABLE_NAME = "work_experience_entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }

    public static abstract class SchoolInformationEntry implements BaseColumns {
        public static final String TABLE_NAME = "school_information_entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}
