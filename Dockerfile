FROM mysql
COPY create_database.sql /docker-entrypoint-initdb.d/create_database.sql
RUN chmod 755 /docker-entrypoint-initdb.d/create_database.sql
