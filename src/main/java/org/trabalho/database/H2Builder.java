package org.trabalho.database;

import java.sql.SQLException;

public class H2Builder implements DatabaseBuilder {
    @Override
    public Database build() throws SQLException {
        Database database = new H2Database();
        database.open();

        return database;
    }
}
