package com.user.jattana.config;

public class TableDefinitions {
    public static final String USER_TABLE = "USER";
    public static final String USER_FIELDS[] = {"email","fName","lName","userType","password"};
    public static final String ESTATE_TABLE = "ESTATE";
    public static final String ESTATE_FIELDS[] = {"id","email", "propertyName","propertyNumber","type","leaseType","location","num_of_bedrooms","num_of_bathrooms","size","askingPrice","localAmenities","description"};
    public static final String REPORTING_TABLE="ESTATE_REPORTING";
    public static final String REPORTING_TABLE_FIELDS[]={"reportId","agentEmail", "propertyId", "date_of_Viewing", "interest", "offer_price", "offer_expiry_date", "conditions_of_offer", "viewing_comments"};


    public static final String SQL_CREATE_USER_TABLE =
            "CREATE TABLE " + USER_TABLE + " ( " +
                    USER_FIELDS[0] + " TEXT PRIMARY KEY , " +
                    USER_FIELDS[1] + " TEXT, " +
                    USER_FIELDS[2] + " TEXT, " +
                    USER_FIELDS[3] + " TEXT, "+
                    USER_FIELDS[4] + " TEXT )";

    public static final String SQL_DELETE_USER_TABLE =
            "DROP TABLE IF EXISTS " + USER_TABLE;

    public static final String SQL_CREATE_ESTATE_TABLE =
            "CREATE TABLE " + ESTATE_TABLE + " ( " +
                    ESTATE_FIELDS[0] + " INTEGER PRIMARY KEY autoincrement, " +
                    ESTATE_FIELDS[1] + " TEXT, " +
                    ESTATE_FIELDS[2] + " TEXT, " +
                    ESTATE_FIELDS[3] + " TEXT, " +
                    ESTATE_FIELDS[4] + " TEXT, " +
                    ESTATE_FIELDS[5] + " TEXT, " +
                    ESTATE_FIELDS[6] + " TEXT, " +
                    ESTATE_FIELDS[7] + " INTEGER, " +
                    ESTATE_FIELDS[8] + " INTEGER, " +
                    ESTATE_FIELDS[9] + " TEXT, " +
                    ESTATE_FIELDS[10] + " DOUBLE, " +
                    ESTATE_FIELDS[11] + " TEXT, "+
                    ESTATE_FIELDS[12] + " TEXT )";

    public static final String SQL_DELETE_ESTATE_TABLE =
            "DROP TABLE IF EXISTS " + ESTATE_TABLE;

    public static final String SQL_CREATE_ESTATE_AGENT_TABLE =
            "CREATE TABLE " + REPORTING_TABLE + " ( " +
                    REPORTING_TABLE_FIELDS[0] + " INTEGER PRIMARY KEY autoincrement, " +
                    REPORTING_TABLE_FIELDS[1] + " TEXT, " +
                    REPORTING_TABLE_FIELDS[2] + " INTEGER, " +
                    REPORTING_TABLE_FIELDS[3] + " TEXT, " +
                    REPORTING_TABLE_FIELDS[4] + " TEXT, " +
                    REPORTING_TABLE_FIELDS[5] + " DOUBLE, " +
                    REPORTING_TABLE_FIELDS[6] + " TEXT, " +
                    REPORTING_TABLE_FIELDS[7] + " TEXT, " +
                    REPORTING_TABLE_FIELDS[8] + " TEXT )";

    public static final String SQL_DELETE_ESTATE_AGENT_TABLE =
            "DROP TABLE IF EXISTS " + REPORTING_TABLE;
}
