INSERT INTO VIDEOJOC (id, nom, videoconsola, disponibilitat, preuLloguer, descripcio, tipus, adrecaBotigues)
VALUES 
  (10, 'Super Mario Land', 'Game Boy', 1, 10.99, 'Clásico juego de plataformas', 'Plataforma', 'The Retro Games Store, pl. del Blat 3, Valls, 43800'),
  (11, 'Quake', 'PC', 0, 15.99, 'Juego de acción en primera persona', 'Acción', 'Game Haven, Calle de Ejemplo 123, Ciudad, 12345'),
  (12, 'The Legend of Zelda', 'Nintendo Entertainment System', 1, 12.99, 'Aventura épica', 'Aventura', 'Gamer Paradise, Av. Principal 456, Pueblo, 56789');

INSERT INTO USUARI (id, nomUsuari, contrasenya, correu)
VALUES
    (100, 'MarcJimenez', 'marc123', 'marcj16@gmail.com'),
    (101, 'CarlosEscrit', 'carlos123', 'carlos12@gmail.com'),
    (102, 'JuancaAlonso', 'juanca123', 'juanca8@gmail.com'),
    (103, 'AbrilGuzman', 'abril123', 'abril8@gmail.com'),
    (104, 'CocoIbbie', 'coco123', 'coco8@gmail.com');

INSERT INTO LLOGUER (id, dataFi, dataInici, usuari_id, videojoc_id)
VALUES
    (200, '2023-01-01', '2024-02-02', 100, 10),
    (201, '2023-03-03', '2024-04-04', 101, 11),
    (202, '2023-05-05', '2024-06-06', 102, 12),
    (203, '2023-07-07', '2024-08-08', 103, 10),
    (204, '2023-09-09', '2024-10-10', 104, 11);