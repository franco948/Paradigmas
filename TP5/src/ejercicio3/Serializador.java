package ejercicio3;

import ejercicio1.EntidadSerializable;
import ejercicio2.AtributoSerializable;

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
                params.add(value);

                columns += nombreAmigable + ",";
                values += "?,";
            }
        }

        // Remueve la ultima coma a las columnas del insert
        //if ( !columns.isEmpty() )
        columns = columns.substring(0, columns.length() - 1);

        // Remueve la ultima coma a los valores que se van a insertar
        //if ( !values.isEmpty() )
        values = values.substring(0, values.length() - 1);

        sql = String.format(sql, getClassName(tipo), columns, values);

        crearTabla(tipo, con);

        Conexion.write(sql, params, con);

        //con.close();
    }

    private String getClassName(Class tipo) {
        String[] nombre = tipo.getName().split("\\.");

        return nombre[nombre.length - 1];
    }

    public void crearTabla(Class tipo, Connection con) throws ClassNotFoundException, SQLException
    {
        String columns = "";

        for ( Field f : tipo.getDeclaredFields() )
        {
            Annotation atributoSerializable = f.getAnnotation(AtributoSerializable.class);

            if ( atributoSerializable != null )
            {
                // TODO: Crear un metodo que realice la condicion
                if ( !f.getType().isPrimitive() && !f.getType().equals(String.class) ) throw new IllegalStateException();

                columns += f.getName() + " ";

                if ( f.getType().equals(int.class) )
                {
                    columns += "int,";
                }
                /*else if ( f.getType().equals(short.class) )
                {
                    columns += "smallint,";
                }*/
                /*else if ( f.getType().equals(float.class) )
                {
                    columns += "float,";
                }*/
                else if ( f.getType().equals(String.class) )
                {
                    columns += "varchar(30),";
                }
                else if ( f.getType().equals(boolean.class) )
                {
                    columns += "bit,";
                }
            }
        }

        // Remueve la ultima coma
        //if ( !columns.isEmpty() )
        columns = columns.substring(0, columns.length() - 1);

        //String sql ="CREATE TABLE " + getClassName(tipo) + " ( " +
          //      columns + ")";
          String sql =
                  //"IF OBJECT_ID(N'" + getClassName(tipo) + "', N'U') IS NOT NULL " +
                  //"BEGIN " +
                      "CREATE TABLE IF NOT EXISTS " + getClassName(tipo) + " ( " +
                      columns + ")";// +
                  //"END";

        Conexion.write(sql, null, con);
    }
}
