package org.trabalho.database;

import java.sql.SQLException;

public interface DatabaseBuilder {
    Database build() throws SQLException;
}
