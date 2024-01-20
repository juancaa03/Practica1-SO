<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database SQL Load</title>
    </head>
    <style>
        .error {
            color: red;
        }
        pre {
            color: green;
        }
    </style>
    <body>
        <h2>Database SQL Load</h2>
        <%
            /* How to customize:
             * 1. Update the database name on dbname.
             * 2. Create the list of tables, under tablenames[].
             * 3. Create the list of table definition, under tables[].
             * 4. Create the data into the above table, under data[]. 
             * 
             * If there is any problem, it will exit at the very first error.
             */
            String dbname = "homework1";
            String schema = "ROOT";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            /* this will generate database if not exist */
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbname, "root", "root");
            Statement stmt = con.createStatement();
            
            /* inserting data */
            /* you have to exclude the id autogenerated from the list of columns if you have use it. */
            String data[] = new String[]{
                //Credentials (username, password)
                "INSERT INTO " + schema + ".CREDENTIALS VALUES (NEXT VALUE FOR CREDENTIALS_GEN, 'sob', 'sob')",
                //Usuaris (id, nomUsuari, contrasenya, correu)
                "INSERT INTO " + schema + ".USUARI (id, nomUsuari, contrasenya, correu) VALUES (NEXT VALUE FOR Usuari_Gen, 'MarcJimenez', 'marc123', 'marcj16@gmail.com')",
                "INSERT INTO " + schema + ".USUARI (id, nomUsuari, contrasenya, correu) VALUES (NEXT VALUE FOR Usuari_Gen, 'CarlosEscrit', 'carlos123', 'carlos12@gmail.com')",
                "INSERT INTO " + schema + ".USUARI (id, nomUsuari, contrasenya, correu) VALUES (NEXT VALUE FOR Usuari_Gen, 'JuancaAlonso', 'juanca123', 'juanca8@gmail.com')",
                "INSERT INTO " + schema + ".USUARI (id, nomUsuari, contrasenya, correu) VALUES (NEXT VALUE FOR Usuari_Gen, 'AbrilGuzman', 'abril123', 'abril8@gmail.com')",
                "INSERT INTO " + schema + ".USUARI (id, nomUsuari, contrasenya, correu) VALUES (NEXT VALUE FOR Usuari_Gen, 'sob', 'sob', 'sob@gmail.com')",
                "INSERT INTO " + schema + ".USUARI (id, nomUsuari, contrasenya, correu) VALUES (NEXT VALUE FOR Usuari_Gen, 'CocoIbbie', 'coco123', 'coco8@gmail.com')",
                //Videojoc (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues)
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'Super Mario Land', 'GameBoy', 1, 10.99, 'Clásico juego de plataformas', 'Plataforma', 'The Retro Games Store- pl. del Blat 3- Valls- 43800')",
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'Quake', 'PC', 0, 15.99, 'Juego de acción en primera persona', 'Accion', 'Game Haven- Calle de Ejemplo 123- Ciudad- 12345')",
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'The Legend of Zelda', 'GameBoy', 1, 12.99, 'Aventura', 'Aventura', 'Gamer Paradise- Av. Principal 456- Pueblo- 56789')",
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'Fifa 23', 'PS5', 1, 69.99, 'Juego de futbol', 'Deporte', 'The Retro Games Store- pl. del Blat 3- Valls- 43800')",
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'Minecraft', 'PC', 0, 15.99, 'Juego de aventura', 'Aventura', 'Game Haven- Calle de Ejemplo 123- Ciudad- 12345')",
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'Roquet League', 'PS5', 1, 18.99, 'Coches', 'Deporte', 'Gamer Paradise- Av. Principal 456- Pueblo- 56789')",
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'Fortnite', 'PC', 0, 9.95, 'Juego de aventura', 'Aventura', 'Game Haven- Calle de Ejemplo 123- Ciudad- 12345')",
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'Brawl Stars', 'GameBoy', 0, 199.95, 'Juego de pelea', 'Lucha', 'Game Haven- Calle de Ejemplo 123- Ciudad- 12345')",
                "INSERT INTO " + schema + ".VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues) VALUES (NEXT VALUE FOR Videojoc_Gen, 'WWE', 'PS5', 1, 199.95, 'Juego de lucha libre', 'Lucha', 'Gamer Paradise- Av. Principal 456- Pueblo- 56789')",
                //Lloguer (id, dataFi, dataInici, usuari_id, videojoc_id)
                "INSERT INTO " + schema + ".LLOGUER (id, dataFi, dataInici, usuari_id, videojoc_id) VALUES (NEXT VALUE FOR Lloguer_Gen, '2024-02-02', '2023-01-01', 1, 1)",
                "INSERT INTO " + schema + ".LLOGUER (id, dataFi, dataInici, usuari_id, videojoc_id) VALUES (NEXT VALUE FOR Lloguer_Gen, '2024-04-04', '2023-03-03', 2, 2)",
                "INSERT INTO " + schema + ".LLOGUER (id, dataFi, dataInici, usuari_id, videojoc_id) VALUES (NEXT VALUE FOR Lloguer_Gen, '2024-06-06', '2023-05-05', 3, 3)",
                "INSERT INTO " + schema + ".LLOGUER (id, dataFi, dataInici, usuari_id, videojoc_id) VALUES (NEXT VALUE FOR Lloguer_Gen, '2024-08-08', '2023-07-07', 4, 2)",
                "INSERT INTO " + schema + ".LLOGUER (id, dataFi, dataInici, usuari_id, videojoc_id) VALUES (NEXT VALUE FOR Lloguer_Gen, '2024-10-10', '2023-09-09', 5, 1)"
                //Botiga
                //RebutLloguer (id, dataAlquiler, dataRetorn, preuTotal, usuari_id)
                //"INSERT INTO " + schema + ".REBUTLLOGUER (id, dataAlquiler, dataRetorn, preuTotal, usuari_id) VALUES (NEXT VALUE FOR RebutLloguer_Gen, '2024-12-')",
            };
            for (String datum : data) {
                if (stmt.executeUpdate(datum)<=0) {
                    out.println("<span class='error'>Error inserting data: " + datum + "</span>");
                    return;
                }
                out.println("<pre> -> " + datum + "<pre>");
            }
        %>
        <button onclick="window.location='<%=request.getSession().getServletContext().getContextPath()%>'">Go home</button>
    </body>
</html>
