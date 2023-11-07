package org.trabalho;

public interface DatabaseFactory {
    Database build(DatabaseType type);
}
