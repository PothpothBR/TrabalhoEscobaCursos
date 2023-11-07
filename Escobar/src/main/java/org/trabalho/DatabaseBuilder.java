package org.trabalho;

public class DatabaseBuilder implements DatabaseFactory{
    @Override
    public Database build(DatabaseType type) {
        return switch (type) {
            case SQLITE -> new SqliteDatabase();
            case H2 -> new H2Database();
            default -> null;
        };
    }
}
