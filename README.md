# Practica1-SO
Pràctica 1
En els darrers anys, hi ha hagut un ressorgiment de l'interès pels videojocs "retro" com Super Mario Land, el videojoc de plataformes de desplaçament lateral que va ser desenvolupat per la videoconsola portàtil Game Boy l'any 1989. 

Per cobrir aquest necessitat de mercat, l'objectiu d'aquesta pràctica serà proporcionar una API Web per a poder llogar videojocs "retro" de forma en línia.

1. Objectius
En la primera part de la pràctica construirem una API Web que implementarà la funcionalitat necessària per llogar videojocs.

2. Funcionament general
Com que encara no implementarem cap "front-end" web, només ens haurem de preocupar en aquesta pràctica d'implementar les interfícies RESTful definides en l'API Web. Específicament, l'API Web servirà per exposar el model de dades relacional implementat amb JPA, juntament amb la implementació d'una part de la lògica de negoci de l'aplicació.

Les aplicacions web de lloguer de videojocs  en línia mostren un llistat dels diferents videojocs més populars. Aquest llistat inclou imatge de la caràtula frontal de la capsa de videojoc. I a sota de la fotografia o al costat, el títol del videojoc, per quina videoconsola està disponible, la disponibilitat o no del videojoc en el moment actual i el preu del seu lloguer per una setmana. Un exemple, podria ser el següent:



Quan es clica damunt de la imatge, típicament s'obre una nova pàgina on a més de la informació anterior, s'inclou informació addicional com una breu descripció del videojoc, el seu tipus (plataforma, d'acció, de lluita, de tir en primera persona, etc.) i l'adreça de les botigues físiques on es pot passar a recollir i un botó per afegir el videojoc a la cistella de lloguer. Un exemple podria ser:



En resum, per aquesta primera pràctica considerarem, la informació següent:

El nom del videojoc, p. ex., Super Mario Land, etc.;
Amb quina videoconsola s'hi pot jugar, p. ex., Game Boy, Mega Drive, etc.;
La seva disponibilitat actual;
El preu del lloguer setmanal.
Una descripció del videojoc, p. ex., Quake és un videojoc d'acció en primera persona, desenvolupat per ID Software i publicat per GT Interactive el 1996.
El tipus de videojoc (plataforma, d'acció, de lluita, de tir en primera persona, etc.)
L'adreça de les botigues físiques on es pot recollir. L'adreça ha de ser completa, p. ex., The Retro Games Store, pl. del Blat 3, Valls, 43800.
Tota aquesta informació s'haurà de representar correctament mitjançant JPA.

3. Enunciat
Haurem de suportar les funcionalitats següents:

Definirem una API REST comuna per tothom i que els grups hauran d’implementar a les seves pràctiques.

Cal implementar els serveis REST perquè treballin i retornin JSON. Eines que us poden ser d'interès: Gson, JAXB (exemple d'ús)

Fer servir versionat per la sostenibilitat de l’API.

Cal implementar un client REST per a poder interaccionar i testejar la vostra pràctica. No esteu obligats a fer servir cap tecnologia per implementar els serveis o clients REST, és més, l’essència d’aquest sistema és la simplicitat, i això serà el que més es valorarà de la vostra solució. Suggeriment PostMan API: https://www.postman.com/. Podeu fer servir TDD de manera simple amb Postam també:

Play Video
.
3.1 API
Els serveis web exposats relatius als tres recursos principals: videojocs, lloguers i usuaris, hauran de seguir la següent especificació:

Pels videojocs:

GET /rest/api/v1/game?type=${type}&console=${console}

Per defecte, llistat JSON amb tots els videojocs ordenats alfabèticament per nom. 

Els paràmetres "type" i "console" són opcionals. Si s'especifica el paràmetre "type", només s'inclouran en el llistat els videojocs del tipus ${type}. Si s'especifica el paràmetre "console", es retornaran només els videojocs d'una determinada videoconsola ${console}. Els dos filtres es poden aplicar alhora i, per tant, haver de retornar els videojocs d'un cert tipus i per una certa videoconsola. Si s'especifiquen valors incorrectes a qualsevol d'aquests paràmetres, es retornarà el codi d'error HTTP 400 Bad Request, indicant en el cos de la resposta quin paràmetre és incorrecte.

El filtratge s'ha de fer mitjançant una consulta a la base de dades. No s'acceptarà com a vàlid retornar el llistat de tots els videojocs i filtrar-los de forma programàtica amb Java.
POST/rest/api/v1/game

Opcional! Permetre afegir un videojoc nou a partir de les dades proporcionades en format JSON/XML. 

Cal retornar el codi HTTP 201 Created en cas afirmatiu. Aquesta crida haurà de verificar que el videojoc no existeixi prèviament, i retornar el codi HTTP 409 Conflict en cas que ja existeixi.

Per aquesta operació, cal que el client estigui autentificat.

Pels lloguers:

POST /rest/api/v1/rental

Formalitza el lloguer dels videojocs afegits a la cistella. 

La resposta de la crida ha de retornar l'identificador del rebut de lloguer, el preu total a l'usuari i la data de retorn dels videojocs adquirits.

Per aquesta operació, cal que el client estigui autentificat.

GET /rest/api/v1/rental/${id}

Opcional! Retorna els detalls del lloguer a partir de l'identificador del rebut ${id}. 

Per aquesta operació, cal que el client estigui autentificat.

Pels usuaris:

GET /rest/api/v1/customer

 Llistat JSON dels clients.

Aquesta crida no pot retornar informació confidencial, p. ex., la  contrasenya dels usuaris.

GET /rest/api/v1/customer/${id}

Retorna la informació de l'usuari amb identificador ${id}. 

Aquesta crida no pot retornar informació confidencial, p. ex., la  contrasenya d'aquest usuari.

PUT /rest/api/v1/customer/${id}

Opcional! Modifica les dades del client amb identificador ${id} al sistema amb les dades JSON/XML proporcionades.

Per aquesta operació, cal que el client estigui autentificat.
 

3.2 Autentificació dels usuaris
Per aquells serveis web que requereixen que el client estigui autentificat, s'ha creat una anotació de tipus Runtime Java anomenada @Secured. Quan anoteu un mètode amb aquesta anotació, el servidor intentarà autentificar a l'usuari amb el mètode d'autenticació d'accés bàsica (en anglès, HTTP Basic Authentication), que usa la capçalera HTTP Authorization per passar al servidor les credencials de l'usuari.

Hi ha formes més professionals de realitzar aquesta autentificació i autorització d'operacions REST via JAX-RS. Com a solució simple i sense seguir cap estàndard, podríeu implementar un petit mecanisme d'API Key Authentication. O fer servir altres mecanismes d'autentificació com JWT, etc.

Resumint tot això, tindrem les següents funcionalitats obligatòries a implementar:

De l'API REST:

Les crides API REST obligatòries.
Versionat en l'API REST.
Dades enviades i rebudes en format JSON.
L'autentificació de les crides que així ho requereixen.
Ús de codis HTTP adequats als resultats de les operacions de l'API REST.
Proveir un client per l'API REST.
Proveir un joc de proves per aquest client.
Nota. Cal que diferencieu els recursos de l'API REST (game, rental i customer) de les entitats o objectes de domini que necessiteu per poder implementar l'API web.

Ampliacions opcionals:

Sempre i quant la part obligatòria estigui ben dissenyada i desenvolupada, amb els següents punts s’aconseguirà pujar nota:

Àmbit actuació REST:

Permetre que els serveis REST rebin i retornin XML com a l’alternativa a JSON.
Cuinar codis i missatges HTTP per la gestió de les excepcions remotes (ex,. 404 Not Found, 403 Forbidden, 201 Created, ...).
Ampliar l’API REST per incorporar les parts opcionals indicades.
Preparació de tests unitaris automàtics amb Postman (https://learning.postman.com/docs/writing-scripts/test-scripts/)
Sistema d'autentificació diferents a l'HTTP Basic Authentication.
4. Documentació
Juntament amb el codi font caldrà lliurar un informe en format PDF amb la següent estructura:  

Introducció. Presentació general de la pràctica i dels objectius.  

Estructura de la pràctica. Per exemple, caldrà especificar l’estructura del projecte, dels fitxers, les entitats JPA, entre d’altres.  

Decisions de disseny. Quines alternatives heu considerat a l’hora de fer el projecte i perquè heu escollit l’alternativa escollida enfront de les altres. Aquí, entre altres coses, hauríeu d’explicar quin model dels vistos a classe heu fet servir, quines parts opcionals o millores addicionals heu fet i com heu decidit implementar-les. Heu emprat eines i recursos externs?  

Jocs de proves realitzats. Quines proves heu fet per assegurar-vos que el vostre projecte funciona correctament en tots els casos possibles. És molt important realitzar un joc de proves extensiu, que cobreixi tots els casos, tant els positius com els negatius, com aquells que puguin produir excepcions d'algun tipus. Per tot això, heu aplicat TDD i/o BDD?  

Conclusions. A quines conclusions heu arribat en finalitzar aquest primer projecte.

Manual d’instal·lació. La instal·lació s'ha de reduir als següents passos:
1. Obrir projecte NetBeans;
2. Donar-li a deploy de la vostra pràctica;
3. (Opcionalment) Executar scripts per crear la base de dades;
4. Passos per executar el client REST i petit joc de proves.

A més, ha d'haver-hi un usuari de prova anomenat sob i contrasenya sob per poder provar el correcte funcionament del mecanisme de les revisions o reviews. Si necessiteu forçosament alguna altra acció, expliciteu-la adequadament.

La nom de la vostra base de dades ha de ser com segueix: "sob_grup_NN", on "NN" és el número del vostre grup de pràctiques del Moodle.

5. Lliurament del projecte

El projecte es lliurarà via Moodle abans de la data màxima d’entrega que consti allà, la qual està prevista que sigui el 4 de desembre de 2023.

Cal que entregueu:

Un arxiu .zip anomenat SOB_P1_nom1_nom2.zip, on nom1 i nom2 seran el nom (i cognoms) de cada un dels components del grup que entrega la pràctica.
Hi ha d’haver una carpeta anomenada projecte on hi haurà tots els fitxers que formen el projecte en NetBeans, de manera que es pugui obrir directament en el mateix entorn del laboratori.
Cal deixar ben clar l’ús dels passos addicionals que siguin necessaris per posar en funcionament la vostra pràctica.
Un fitxer anomenat documentacio.pdf amb la documentació de la pràctica que segueixi el format explicat en el punt anterior.
6. Avaluació 
Cal fer com a mínim les parts obligatòries que us permetran aconseguir fins a un 9.5 de la nota del projecte.

Si implementeu 1 ampliació opcional correctament, la nota que es podrà aconseguir serà fins a un 10 per aquesta pràctica. És preferible tenir 1 ampliació ben desenvolupada que una quantitat superior i que estiguin incorrectes.

Alguns dels aspectes que es valoraran són:  

Funcionalitat correcta del projecte  

Estructuració de la pràctica

Decisions de disseny preses  

Elegància de la solució proposada a nivell de programació  

Seguretat i extensibilitat de l’aplicatiu  

Compliment dels estàndards i convencions a l’hora de desenvolupar una aplicació web en Java+Netbeans (Java Code Conventions).  

Qualitat de la documentació presentada.
