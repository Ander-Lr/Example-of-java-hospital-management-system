package hospital;

import com.mongodb.MongoException;//MANEJO EXCEPCIÓN
import com.mongodb.client.MongoClient;//PARA CONECTAR A LA DB
import com.mongodb.client.MongoClients;//PARA CONECTAR A LA DB
import com.mongodb.client.MongoCollection;//COLECCIÓN DONDE SE GUARDAN RESULTADOS DB
import com.mongodb.client.MongoDatabase;//PARA OBTERNER DB DE MONGO
import java.util.ArrayList;//PARA GUARDAR RESULTADOS DB (READ)
import java.util.List;//PARA GUARDAR RESULTADOS DB (READ)
import org.bson.Document;//PARA OBTENER LOS RESULTADOS EN FORMA DE DOCUMENTOS

public class ConnectionDBMejia {

  //NOMBRE DB
  public String DB = "P2HospitalMejiaJefferson";

  //REALIZA CONEXIÓN A DB
  public MongoDatabase createConnection() {
    try {
      MongoClient client = MongoClients.create("mongodb://localhost:27017");
      return client.getDatabase(DB);
    } catch (MongoException e) {
      e.printStackTrace();
    }
    return null;
  }

  //CREATE - RETORNA TRUE SI CREÓ
  public boolean createDocument(Document document, String collectionName) {
    try {
      MongoDatabase db = createConnection();
      if (db != null) {
        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.insertOne(document);
        return true;
      }
    } catch (MongoException e) {
      e.printStackTrace();
    }
    return false;
  }

  //READ - RETORNA RESULTADOS DE BÚSQUEDA
  public List<Document> readDocument(Document document, String collectionName) {
    List<Document> results = new ArrayList<>();
    try {
      MongoDatabase db = createConnection();
      MongoCollection<Document> collection = db.getCollection(collectionName);
      results = collection.find(document).into(results);
      return results;
    } catch (MongoException e) {
      e.printStackTrace();
    }
    return results;
  }

  //DELETE - RETORNA TRUE SI ELIMINÓ
  public boolean deleteDocument(Document document, String collectionName) {
    try {
      MongoDatabase db = createConnection();
      if (db != null) {
        MongoCollection<Document> collection
                = db.getCollection(collectionName);
        collection.deleteOne(document);
        return true;
      }
    } catch (MongoException e) {
      e.printStackTrace();
    }
    return false;
  }

  //UPDATE - RETORNA TRUE SI ACTUALIZÓ
  public boolean updateDocument(Document document,
          Document update, String collectionName) {
    try {
      MongoDatabase db = createConnection();
      if (db != null) {
        MongoCollection<Document> collection = db.getCollection(collectionName);
        collection.updateOne(document, new Document("$set", update));
        return true;
      }

    } catch (MongoException e) {
      e.printStackTrace();
    }
    return false;
  }
}
