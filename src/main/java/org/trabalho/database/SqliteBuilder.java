package org.trabalho.database;

import java.sql.SQLException;

public class SqliteBuilder implements DatabaseBuilder {

    @Override
    public Database build() throws SQLException {
        Database database = new SqliteDatabase();
        database.open();

        return database;
    }
}
