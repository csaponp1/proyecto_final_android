package com.example.login;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


public class Producto {
    private int id,marca;
    private double precio;
    private String producto,imagen,descripcion;
    private String url_api = "https://localhost:5001/api/productos/";

    public Producto(){};
    public Producto(int id, int marca, double precio, String producto, String imagen,String descripcion) {
        this.id = id;
        this.marca = marca;
        this.precio = precio;
        this.producto = producto;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String get(){
        String salida="";

        try{
            URL url = new URL(url_api);
            HttpURLConnection c_api= (HttpURLConnection) url.openConnection();
            c_api.setRequestMethod("GET");
            c_api.setRequestProperty("Accept","application/json");

            if(c_api.getResponseCode()==200){
                InputStreamReader entrada = new InputStreamReader(c_api.getInputStream());
                BufferedReader lectura = new BufferedReader(entrada);
                salida = lectura.readLine();
                System.out.println(salida);
            }
            else{
                salida="";
                System.out.println("error, no se puede conectar a la Api"+c_api.getResponseCode());
            }

            c_api.disconnect();
        }catch(IOException ex){
            System.out.println("xxxXXXerrorXXXxxx"+ex.getMessage());
        }
        return salida;
    }

    public String[] leer() {

        String[] datos = new String[6];
        try {


            JSONArray arreglo = new JSONArray(get());

            for (int i = 0; i < arreglo.length(); i++) {
                JSONObject atributo = arreglo.getJSONObject(i);
                datos[0] = String.valueOf(atributo.getInt("idproductos"));
                datos[1] = atributo.getString("producto");
                datos[2] = atributo.getString("idmarca");
                datos[3] = atributo.getString("descripcion");
                datos[4] = atributo.getString("imagen");
                datos[5] = String.valueOf(atributo.getInt("precio_costo"));


            }

        } catch (JSONException ex) {
            System.out.println("xxxXXXerror al leerXXXxxx" + ex.getMessage());
        }
        return datos;
    }
}
