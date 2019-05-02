package ejercicio3;

import ejercicio1.EntidadSerializable;
import ejercicio2.AtributoSerializable;
import restaurant.Conexion;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Serializador {

    public void serializar(Object objeto) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        if (objeto == null) throw new IllegalStateException();

        Class tipo = objeto.getClass();

        if ( tipo.getAnnotation(EntidadSerializable.class) == null )
            throw new IllegalStateException();

        BufferedWriter writer = new BufferedWriter( new FileWriter(tipo.getName()) );

        Annotation entidadSerializable = tipo.getAnnotation(EntidadSerializable.class);

        Object nombreAmigable = entidadSerializable
                .annotationType()
                .getMethod("nombreAmigable")
                .invoke(entidadSerializable);

        writer.write( nombreAmigable.toString() + ">>" );

        for ( Field f : tipo.getDeclaredFields() )
        {
            Annotation attributoSerializable = f.getAnnotation(AtributoSerializable.class);

            if ( attributoSerializable != null )
            {
                nombreAmigable = attributoSerializable
                        .annotationType()
                        .getMethod("nombreAmigable")
                        .invoke(attributoSerializable);

                f.setAccessible(true);
                Object value = f.get(objeto);

                String valueToWrite = value.toString();

                if (value instanceof String) valueToWrite = "\"" + valueToWrite + "\"";

                // TODO: que pasa si el atributo es null?
                writer.write( nombreAmigable.toString() + ":" + valueToWrite + ",");
            }
        }

        writer.flush();
        writer.close();
    }

    public void bdInsert(Object objeto, Connection con) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, SQLException {

        Class tipo = objeto.getClass();

        String sql = "INSERT INTO %s (%s) VALUES (%s)";
        String columns = "";
        String values = "";

        List<Object> params = new LinkedList<>();

        for ( Field f : tipo.getDeclaredFields() ){

            Annotation atributoSerializable = f.getAnnotation(AtributoSerializable.class);

            if ( atributoSerializable != null ) {

                if ( !f.getType().isPrimitive() && !f.getType().equals(String.class) ) throw new IllegalStateException();

                String nombreAmigable = atributoSerializable
                        .annotationType()
                        .getMethod("nombreAmigable")
                        .invoke(atributoSerializable)
                        .toString();

                f.setAccessible(true);
                Object value = f.get(objeto);

                columns += nombreAmigable + ",";
                values += "?,";
            }
        }

        // Remueve la ultima coma a las columnas del insert
        //if ( !columns.isEmpty() )
        columns.substring(0, columns.length() - 1);

        // Remueve la ultima coma a los valores que se van a insertar
        //if ( !values.isEmpty() )
        values.substring(0, values.length() - 1);

        String.format(sql, tipo.getName(), values, columns);

        write(sql, params);
    }

    public void crearTabla(Class tipo) throws ClassNotFoundException, SQLException
    {
        String columns = "";

        for ( Field f : tipo.getDeclaredFields() )
        {
            Annotation atributoSerializable = f.getAnnotation(AtributoSerializable.class);

            if ( atributoSerializable != null )
            {
                if ( !f.getType().isPrimitive() && !f.getType().equals(String.class) ) throw new IllegalStateException();

                columns += f.getName() + " ";

                if ( f.getType().equals(int.class) )
                {
                    columns += "int,";
                }
                else if ( f.getType().equals(short.class) )
                {
                    columns += "smallint,";
                }
                else if ( f.getType().equals(float.class) )
                {
                    columns += "float,";
                }
                else if ( f.getType().equals(String.class) )
                {
                    columns += "varchar(30),";
                }
            }
        }

        // Remueve la ultima coma
        //if ( !columns.isEmpty() )
        columns.substring(0, columns.length() - 1);

        String sql =
                "IF OBJECT_ID(N'dbo.Customers', N'U') IS NOT NULL " +
                "BEGIN " +
                    "CREATE TABLE " + tipo.getName() + " ( " +
                    columns + ")" +
                "END";


        write(sql, null);
    }

    public static void write (String sql, List<Object> params) throws ClassNotFoundException, SQLException {
        cargarDriver();

        Connection con = createConnection();

        PreparedStatement statement = con.prepareStatement(sql);

        if ( params != null )
        {
            int i = 1;

            for (Object val : params) {
                statement.setObject(i, val);
            }
        }

        statement.close();
        con.close();
    }

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public static void cargarDriver() throws ClassNotFoundException {
        Class.forName(DB_DRIVER);
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_CONNECTION,
                DB_USER,
                DB_PASSWORD);
    }
}
