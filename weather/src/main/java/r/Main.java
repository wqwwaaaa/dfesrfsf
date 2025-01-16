package r;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    private static final String API_KEY = "244d7a0eb22b5e0d3aa345d6a25591fe";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите город: ");
        final String city = scanner.nextLine();
        System.out.println("Введите цифру: ");
        System.out.println("1 - Описание");
        System.out.println("2 - Температура");
        System.out.println("3 - Скорость ветра");
        System.out.println("0 - выход");
        System.out.println(" ");
        while (true) {
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                        try {
                            String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                            URL url = new URL(urlString);

                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");

                            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            String inputLine;
                            StringBuilder response = new StringBuilder();
                            while ((inputLine = in.readLine()) != null) {
                                response.append(inputLine);
                            }
                            in.close();
                            conn.disconnect();

                            JSONObject jsonResponse = new JSONObject(response.toString());

                          //  JSONObject main = jsonResponse.getJSONObject("main");
                            JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0);
                            JSONObject wind = jsonResponse.getJSONObject("wind");

                            String description = weather.getString("description");
                         //   double temperature = main.getDouble("temp");
                          //  int humidity = main.getInt("humidity");
                          //  double speed = wind.getDouble("speed");

                            System.out.println("Погода в " + city + ":");
                            System.out.println("Описание: " + description);
                        /*    System.out.println("Температура: " + temperature + "C");
                            System.out.println("Влажность: " + humidity + "%");
                            System.out.println("Скорость ветра: " + speed + " м/с");*/
                         //   System.out.println(response);

                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    }

                    case 2:

                        try {
                            String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                            URL url = new URL(urlString);

                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");

                            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            String inputLine;
                            StringBuilder response = new StringBuilder();
                            while ((inputLine = in.readLine()) != null) {
                                response.append(inputLine);
                            }
                            in.close();
                            conn.disconnect();

                            JSONObject jsonResponse = new JSONObject(response.toString());

                            JSONObject main = jsonResponse.getJSONObject("main");
                            JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0);
                            JSONObject wind = jsonResponse.getJSONObject("wind");

                            String description = weather.getString("description");
                            double temperature = main.getDouble("temp");
                            int humidity = main.getInt("humidity");
                            double speed = wind.getDouble("speed");

                            System.out.println("Погода в " + city + ":");
                        //    System.out.println("Описание: " + description);
                            System.out.println("Температура: " + temperature + "C");
                         /*   System.out.println("Влажность: " + humidity + "%");
                            System.out.println("Скорость ветра: " + speed + " м/с");*/
                            //   System.out.println(response);

                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    });

                case 3:
                        try {
                            String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                            URL url = new URL(urlString);

                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");

                            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            String inputLine;
                            StringBuilder response = new StringBuilder();
                            while ((inputLine = in.readLine()) != null) {
                                response.append(inputLine);
                            }
                            in.close();
                            conn.disconnect();

                            JSONObject jsonResponse = new JSONObject(response.toString());

                            JSONObject main = jsonResponse.getJSONObject("main");
                            JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0);
                            JSONObject wind = jsonResponse.getJSONObject("wind");

                            String description = weather.getString("description");
                            double temperature = main.getDouble("temp");
                            int humidity = main.getInt("humidity");
                            double speed = wind.getDouble("speed");

                            System.out.println("Погода в " + city + ":");
                            //System.out.println("Описание: " + description);
                            //System.out.println("Температура: " + temperature + "C");
                            //System.out.println("Влажность: " + humidity + "%");
                            System.out.println("Скорость ветра: " + speed + " м/с");
                            //   System.out.println(response);

                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
    
            }
        }
    }
}