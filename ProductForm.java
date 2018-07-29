import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class Assgn2 extends Application{
    GridPane gridPane = new GridPane();
    GridPane gridPane1 = new GridPane();
    GridPane gridPane2 = new GridPane();
    GridPane gridPane3 = new GridPane();
    Button backbutton1 = new Button("Back");
    Button backbutton3 = new Button("Back");
    Scene scene, scene1, scene2, scene3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Text prodName = new Text("Product Name");
        Text shortDesc = new Text("Short Description");
        Text sku = new Text("Stock Keeping Unit");
        Text prodDim = new Text("Product Dimensions");
        Text shipWeight = new Text("Shipping Weight");
        Text acrs = new Text("Average Customer Review Score");
        Text stdPrice = new Text("Standard Price to Customer");
        Text suppCost = new Text("Cost of Product from Supplier");
        Text prodType = new Text("Product Type");
        Text authName = new Text("Author Name");
        Text publisher = new Text("Publisher");
        Text year = new Text("Year of Publication");
        Text pagecount = new Text("Page Count");
        Text artistName = new Text("Artist Name");
        Text producerName = new Text("Producer Name");
        Text trackCount = new Text("Track Count");
        Text playTime = new Text("Play Time");
        Text skaColor = new Text("Color");
        Text skaVoltage = new Text("Voltage");
        Text skaStyle = new Text("Style");
        Text carm = new Text("Model");
        Text carb = new Text("Brand");
        Text cary = new Text("Year");
        Text carp = new Text("Price");
        Text mpb = new Text("Brand");
        Text mpm = new Text("Model");
        Text mpc = new Text("Color");
        Text mpp = new Text("Price");
        Text sb = new Text("Brand");
        Text ss = new Text("Sport");
        Text ssi = new Text("Size");
        Text sp = new Text("Price");


        TextField name = new TextField();
        TextField desc = new TextField();
        TextField stock = new TextField();
        TextField dim = new TextField();
        TextField weight = new TextField();
        TextField review = new TextField();
        TextField price = new TextField();
        TextField cost = new TextField();
        TextField author = new TextField();
        TextField pub= new TextField();
        TextField yearofpub = new TextField();
        TextField count = new TextField();
        TextField artist = new TextField();
        TextField producer = new TextField();
        TextField tracks = new TextField();
        TextField totaltime = new TextField();
        TextField color = new TextField();
        TextField voltage = new TextField();
        TextField style = new TextField();
        TextField carmodel = new TextField();
        TextField carbrand = new TextField();
        TextField caryear = new TextField();
        TextField carprice = new TextField();
        TextField mobilephonebrand = new TextField();
        TextField mobilephonemodel = new TextField();
        TextField mobilephonecolor = new TextField();
        TextField mobilephoneprice = new TextField();
        TextField sportsbrand = new TextField();
        TextField sportssport = new TextField();
        TextField sportssize = new TextField();
        TextField sportsprice = new TextField();

        TextArea status = new TextArea();
        status.setPrefHeight(100);
        status.setPrefWidth(200);

        ToggleGroup prod = new ToggleGroup();
        RadioButton book = new RadioButton("Book");
        book.setToggleGroup(prod);
        RadioButton cd = new RadioButton("CD");
        cd.setToggleGroup(prod);
        RadioButton ska = new RadioButton("Small Kitchen Appliances");
        ska.setToggleGroup(prod);
        RadioButton cars = new RadioButton("Cars");
        cars.setToggleGroup(prod);
        RadioButton mobilePhones = new RadioButton("Mobile Phones");
        mobilePhones.setToggleGroup(prod);
        RadioButton sports = new RadioButton("Sports");
        sports.setToggleGroup(prod);

        Button submit = new Button("Submit");
        Button backbutton2 = new Button("Back");


        gridPane.setMinSize(800, 800);

        gridPane.setPadding(new Insets(20, 20, 20, 20));

        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(prodName, 0, 0);
        gridPane.add(name, 1, 0);
        gridPane.add(shortDesc, 0, 1);
        gridPane.add(desc, 1, 1);
        gridPane.add(sku, 0, 2);
        gridPane.add(stock, 1, 2);
        gridPane.add(prodDim, 0, 3);
        gridPane.add(dim, 1, 3);
        gridPane.add(shipWeight, 0, 4);
        gridPane.add(weight, 1, 4);
        gridPane.add(acrs, 0, 5);
        gridPane.add(review, 1, 5);
        gridPane.add(stdPrice, 0, 6);
        gridPane.add(price, 1, 6);
        gridPane.add(suppCost, 0, 7);
        gridPane.add(cost, 1, 7);
        gridPane.add(prodType, 0, 8);
        gridPane.add(book, 1, 8);
        gridPane.add(cd, 2, 8);
        gridPane.add(ska, 1, 9);
        gridPane.add(cars,2,9);
        gridPane.add(mobilePhones,3,8);
        gridPane.add(sports,3,9);
        gridPane.add(submit,1,15);
        gridPane.add(backbutton2,1,16);
        gridPane.add(status,1,18);

        prodName.setStyle("-fx-font: normal bold 16px 'serif' ");
        shortDesc.setStyle("-fx-font: normal bold 16px 'serif' ");
        sku.setStyle("-fx-font: normal bold 16px 'serif' ");
        prodDim.setStyle("-fx-font: normal bold 16px 'serif' ");
        shipWeight.setStyle("-fx-font: normal bold 16px 'serif' ");
        acrs.setStyle("-fx-font: normal bold 16px 'serif' ");
        stdPrice.setStyle("-fx-font: normal bold 16px 'serif' ");
        suppCost.setStyle("-fx-font: normal bold 16px 'serif' ");
        prodType.setStyle("-fx-font: normal bold 16px 'serif' ");
        book.setStyle("-fx-font: normal bold 16px 'serif' ");
        cd.setStyle("-fx-font: normal bold 16px 'serif' ");
        ska.setStyle("-fx-font: normal bold 16px 'serif' ");
        authName.setStyle("-fx-font: normal bold 16px 'serif' ");
        publisher.setStyle("-fx-font: normal bold 16px 'serif' ");
        year.setStyle("-fx-font: normal bold 16px 'serif' ");
        pagecount.setStyle("-fx-font: normal bold 16px 'serif' ");
        artistName.setStyle("-fx-font: normal bold 16px 'serif' ");
        producerName.setStyle("-fx-font: normal bold 16px 'serif' ");
        trackCount.setStyle("-fx-font: normal bold 16px 'serif' ");
        playTime.setStyle("-fx-font: normal bold 16px 'serif' ");
        skaColor.setStyle("-fx-font: normal bold 16px 'serif' ");
        skaStyle.setStyle("-fx-font: normal bold 16px 'serif' ");
        skaVoltage.setStyle("-fx-font: normal bold 16px 'serif' ");
        submit.setStyle("-fx-font: normal bold 16px 'serif' ");
        backbutton2.setStyle("-fx-font: normal bold 16px 'serif' ");
        cars.setStyle("-fx-font: normal bold 16px 'serif' ");
        mobilePhones.setStyle("-fx-font: normal bold 16px 'serif' ");
        sports.setStyle("-fx-font: normal bold 16px 'serif' ");
        carm.setStyle("-fx-font: normal bold 16px 'serif' ");
        carb.setStyle("-fx-font: normal bold 16px 'serif' ");
        cary.setStyle("-fx-font: normal bold 16px 'serif' ");
        carp.setStyle("-fx-font: normal bold 16px 'serif' ");
        mpb.setStyle("-fx-font: normal bold 16px 'serif' ");
        mpc.setStyle("-fx-font: normal bold 16px 'serif' ");
        mpm.setStyle("-fx-font: normal bold 16px 'serif' ");
        mpp.setStyle("-fx-font: normal bold 16px 'serif' ");
        sb.setStyle("-fx-font: normal bold 16px 'serif' ");
        ss.setStyle("-fx-font: normal bold 16px 'serif' ");
        ssi.setStyle("-fx-font: normal bold 16px 'serif' ");
        sp.setStyle("-fx-font: normal bold 16px 'serif' ");
        status.setStyle("-fx-font: normal bold 16px 'serif' ");

        book.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {


                    gridPane.add(authName, 0, 11);
                    gridPane.add(author, 1, 11);
                    gridPane.add(publisher, 0, 12);
                    gridPane.add(pub, 1, 12);
                    gridPane.add(year, 0, 13);
                    gridPane.add(yearofpub, 1, 13);
                    gridPane.add(pagecount, 0, 14);
                    gridPane.add(count, 1, 14);
                } else {
                    gridPane.getChildren().remove(authName);
                    gridPane.getChildren().remove(author);
                    gridPane.getChildren().remove(publisher);
                    gridPane.getChildren().remove(pub);
                    gridPane.getChildren().remove(year);
                    gridPane.getChildren().remove(yearofpub);
                    gridPane.getChildren().remove(pagecount);
                    gridPane.getChildren().remove(count);

                }
            }
        });

        cd.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {


                    gridPane.add(artistName, 0, 11);
                    gridPane.add(artist, 1, 11);
                    gridPane.add(producerName, 0, 12);
                    gridPane.add(producer, 1, 12);
                    gridPane.add(trackCount, 0, 13);
                    gridPane.add(tracks, 1, 13);
                    gridPane.add(playTime, 0, 14);
                    gridPane.add(totaltime, 1, 14);
                } else {
                    gridPane.getChildren().remove(artistName);
                    gridPane.getChildren().remove(artist);
                    gridPane.getChildren().remove(producerName);
                    gridPane.getChildren().remove(producer);
                    gridPane.getChildren().remove(trackCount);
                    gridPane.getChildren().remove(tracks);
                    gridPane.getChildren().remove(playTime);
                    gridPane.getChildren().remove(totaltime);

                }
            }
        });

        ska.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {


                    gridPane.add(skaColor, 0, 11);
                    gridPane.add(color, 1, 11);
                    gridPane.add(skaStyle, 0, 12);
                    gridPane.add(style, 1, 12);
                    gridPane.add(skaVoltage, 0, 13);
                    gridPane.add(voltage, 1, 13);
                } else {
                    gridPane.getChildren().remove(skaColor);
                    gridPane.getChildren().remove(color);
                    gridPane.getChildren().remove(skaStyle);
                    gridPane.getChildren().remove(style);
                    gridPane.getChildren().remove(skaVoltage);
                    gridPane.getChildren().remove(voltage);

                }
            }
        });

        cars.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {


                    gridPane.add(carb, 0, 11);
                    gridPane.add(carbrand, 1, 11);
                    gridPane.add(carm, 0, 12);
                    gridPane.add(carmodel, 1, 12);
                    gridPane.add(cary, 0, 13);
                    gridPane.add(caryear, 1, 13);
                    gridPane.add(carp, 0, 14);
                    gridPane.add(carprice, 1, 14);
                } else {
                    gridPane.getChildren().remove(carb);
                    gridPane.getChildren().remove(carbrand);
                    gridPane.getChildren().remove(carm);
                    gridPane.getChildren().remove(carmodel);
                    gridPane.getChildren().remove(cary);
                    gridPane.getChildren().remove(caryear);
                    gridPane.getChildren().remove(carp);
                    gridPane.getChildren().remove(carprice);

                }
            }
        });

        mobilePhones.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {


                    gridPane.add(mpb, 0, 11);
                    gridPane.add(mobilephonebrand, 1, 11);
                    gridPane.add(mpm, 0, 12);
                    gridPane.add(mobilephonemodel, 1, 12);
                    gridPane.add(mpc, 0, 13);
                    gridPane.add(mobilephonecolor, 1, 13);
                    gridPane.add(mpp, 0, 14);
                    gridPane.add(mobilephoneprice, 1, 14);
                } else {
                    gridPane.getChildren().remove(mpb);
                    gridPane.getChildren().remove(mobilephonebrand);
                    gridPane.getChildren().remove(mpm);
                    gridPane.getChildren().remove(mobilephonemodel);
                    gridPane.getChildren().remove(mpc);
                    gridPane.getChildren().remove(mobilephonecolor);
                    gridPane.getChildren().remove(mpp);
                    gridPane.getChildren().remove(mobilephoneprice);

                }
            }
        });

        sports.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {


                    gridPane.add(sb, 0, 11);
                    gridPane.add(sportsbrand, 1, 11);
                    gridPane.add(ss, 0, 12);
                    gridPane.add(sportssport, 1, 12);
                    gridPane.add(ssi, 0, 13);
                    gridPane.add(sportssize, 1, 13);
                    gridPane.add(sp, 0, 14);
                    gridPane.add(sportsprice, 1, 14);
                } else {
                    gridPane.getChildren().remove(sb);
                    gridPane.getChildren().remove(sportsbrand);
                    gridPane.getChildren().remove(ss);
                    gridPane.getChildren().remove(sportssport);
                    gridPane.getChildren().remove(ssi);
                    gridPane.getChildren().remove(sportssize);
                    gridPane.getChildren().remove(sp);
                    gridPane.getChildren().remove(sportsprice);
                }
            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                try{
                    MongoClient mongoClient = new MongoClient("localhost",27017);
                    System.out.println("connected..");

                    //MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                    DB db = mongoClient.getDB("assgn2");

                    System.out.println("Database selected..");

                    //MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                    DBCollection collection = db.getCollection("products");
                    System.out.println("Collection fetched..");

                    BasicDBObject document = new BasicDBObject();
                    document.put("prodName", name.getText());
                    document.put("shortDesc", desc.getText());
                    document.put("stockkeepingunit", stock.getText());
                    document.put("prodDim", dim.getText());
                    document.put("shipWeight", weight.getText());
                    document.put("avgCustomerreview", review.getText());
                    document.put("stdPrice", price.getText());
                    document.put("suppCost", cost.getText());

                    if(book.isSelected()){
                        document.put("authName", author.getText());
                        document.put("publisher", pub.getText());
                        document.put("yearofpublishing", yearofpub.getText());
                        document.put("pagecount", count.getText());
                    }

                    if(cd.isSelected()){
                        document.put("artistName", artist.getText());
                        document.put("producerName", producer.getText());
                        document.put("tracksCount", tracks.getText());
                        document.put("playTime", totaltime.getText());
                    }

                    if(ska.isSelected()){
                        document.put("color", color.getText());
                        document.put("style", style.getText());
                        document.put("voltage", voltage.getText());
                    }

                    if(cars.isSelected()){
                        document.put("carBrand", carbrand.getText());
                        document.put("carModel", carmodel.getText());
                        document.put("carYear", caryear.getText());
                        document.put("carPrice", carprice.getText());
                    }

                    if(mobilePhones.isSelected()){
                        document.put("mpBrand", mobilephonebrand.getText());
                        document.put("mpModel", mobilephonemodel.getText());
                        document.put("mpColor", mobilephonecolor.getText());
                        document.put("mpPrice", mobilephoneprice.getText());
                    }

                    if(sports.isSelected()){
                        document.put("spBrand", sportsbrand.getText());
                        document.put("spSport", sportssport.getText());
                        document.put("spSize", sportssize.getText());
                        document.put("spPrice", sportsprice.getText());
                    }

                    collection.insert(document);

                    status.appendText("Success");
                }
                catch (Exception ex){
                    status.appendText(ex.getMessage());
                }
            }
        });



        gridPane1.setMinSize(800, 800);

        gridPane1.setPadding(new Insets(20, 20, 20, 20));

        gridPane1.setVgap(10);
        gridPane1.setHgap(10);

        gridPane1.setAlignment(Pos.CENTER);

        Button query1 = new Button("Query 1");
        Button query2 = new Button("Query 2");
        Button query3 = new Button("Query 3");
        Button query4 = new Button("Query 4");
        Button query5 = new Button("Query 5");
        Button query6 = new Button("Query 6");
        Button query7 = new Button("Query 7");
        Button query8 = new Button("Query 8");
        Button query9 = new Button("Query 9");
        Button query10 = new Button("Query 10");
        TextArea queryout = new TextArea();


        query1.setStyle("-fx-font: normal bold 16px 'serif' ");
        query2.setStyle("-fx-font: normal bold 16px 'serif' ");
        query3.setStyle("-fx-font: normal bold 16px 'serif' ");
        query4.setStyle("-fx-font: normal bold 16px 'serif' ");
        query5.setStyle("-fx-font: normal bold 16px 'serif' ");
        query6.setStyle("-fx-font: normal bold 16px 'serif' ");
        query7.setStyle("-fx-font: normal bold 16px 'serif' ");
        query8.setStyle("-fx-font: normal bold 16px 'serif' ");
        query9.setStyle("-fx-font: normal bold 16px 'serif' ");
        query10.setStyle("-fx-font: normal bold 16px 'serif' ");
        backbutton1.setStyle("-fx-font: normal bold 16px 'serif' ");
        queryout.setStyle("-fx-font: normal bold 16px 'serif' ");


        gridPane1.add(query1, 1, 1);
        gridPane1.add(query2, 1, 3);
        gridPane1.add(query3, 1, 5);
        gridPane1.add(query4, 1, 7);
        gridPane1.add(query5, 1, 9);
        gridPane1.add(query6, 1, 11);
        gridPane1.add(query7, 1, 13);
        gridPane1.add(query8, 1, 15);
        gridPane1.add(query9, 1, 17);
        gridPane1.add(query10, 1, 19);
        gridPane1.add(queryout, 1, 21);
        gridPane1.add(backbutton1, 1, 23);

        query1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find().projection(new Document("stockkeepingunit",1).append("_id",0));

                Iterator<Document> iterator = it.iterator();

                double sum=0;

                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if(document.getString("stockkeepingunit")!=null)
                    sum += Integer.parseInt(document.getString("stockkeepingunit"));
                }

                String q1 = "Average products bought by each customer \n: " + (sum/117);
                queryout.clear();
                queryout.appendText(q1);
            }

        });

        query2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find().projection(new Document("stockkeepingunit",1).append("_id",0)).sort(new Document("stockkeepingunit",-1)).limit(1);

                Iterator<Document> iterator = it.iterator();

                String q21 ="The max value of products bought are: \n";

                while (iterator.hasNext()) {
                Document doc = iterator.next();
                    q21 += doc.getString("stockkeepingunit");
                }

                queryout.clear();
                queryout.appendText(q21);

            }

        });

        query3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find().projection(new Document("avgCustomerreview",1).append("_id",0).append("prodName",1)).sort(new Document("avgCustomerreview",-1)).limit(20);

                Iterator<Document> iterator = it.iterator();

                String o3 = "The top 20 products by customer state are:\n";
                while (iterator.hasNext()) {
                    Document doc = iterator.next();
                    o3+="\n"+doc.getString("prodName")+" "+doc.getString("avgCustomerreview");
                }
                queryout.clear();
                queryout.appendText(o3);

            }

        });

        query4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find().projection(new Document("stdPrice",1).append("_id",0).append("suppCost",1));

                Iterator<Document> iterator = it.iterator();

                double avgsalesvalue=0.0;
                String o4 = "Average sales value bought by each customer : \n";
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if(document.getString("stdPrice")!=null&&document.getString("suppCost")!=null)
                    avgsalesvalue = Integer.parseInt(document.getString("stdPrice"))-Integer.parseInt(document.getString("suppCost"));
                    o4+="\n"+avgsalesvalue;
                }
                queryout.clear();
                queryout.appendText(o4);
            }

        });


        query5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it1 = mongoCollection.find().projection(new Document("stockkeepingunit",1).append("_id",0)).sort(new Document("stockkeepingunit",1));

                Iterator<Document> iterator1 = it1.iterator();

                String q22 ="The min value of products bought are: \n";
                while (iterator1.hasNext()) {
                    Document doc = iterator1.next();
                    if(doc.getString("stockkeepingunit")!=null) {
                        if(Integer.parseInt(doc.getString("stockkeepingunit"))!=0){
                        q22 +=Integer.parseInt(doc.getString("stockkeepingunit"));
                        break;}
                    }
                }

                queryout.clear();
                queryout.appendText(q22);

            }

        });

        query6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find().projection(new Document("carPrice",1).append("_id",0)).sort(new Document("carPrice",-1)).limit(1);

                Iterator<Document> iterator = it.iterator();

                String q21 ="The most expensive car is worth: \n";

                while (iterator.hasNext()) {
                    Document doc = iterator.next();
                    q21 += doc.getInteger("carPrice");
                }

                queryout.clear();
                queryout.appendText(q21);

            }

        });

        query7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find().projection(new Document("mpPrice",1).append("_id",0)).sort(new Document("mpPrice",-1)).limit(1);

                Iterator<Document> iterator = it.iterator();

                String q21 ="The most expensive mobile phone is worth: \n";

                while (iterator.hasNext()) {
                    Document doc = iterator.next();
                    q21 += doc.getInteger("mpPrice");
                }

                queryout.clear();
                queryout.appendText(q21);

            }

        });

        query8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                Document query = new Document("mpColor","Blue");

                FindIterable it = mongoCollection.find(query).projection(new Document("_id",0));

                Iterator<Document> iterator = it.iterator();

                String q21 ="List of all the blue colored mobile phones: \n";

                while (iterator.hasNext()) {
                    Document doc = iterator.next();
                    q21 +="\nMobile Phone Brand : " + doc.getString("mpBrand") +
                            "\nMobile Phone Model : " + doc.getString("mpModel") +
                            "\nMobile Phone Color : " + doc.getString("mpColor") +
                            "\nMobile Phone Price : " + doc.getInteger("mpPrice") +
                            "\n\n";;
                }

                queryout.clear();
                queryout.appendText(q21);

            }

        });

        query9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                Document query = new Document("carBrand","Chevrolet");

                FindIterable it = mongoCollection.find(query).projection(new Document("_id",0));

                Iterator<Document> iterator = it.iterator();

                String q21 ="List of all the chevrolet cars: \n";

                while (iterator.hasNext()) {
                    Document doc = iterator.next();
                    q21 +="\nCar's Brand : " + doc.getString("carBrand") +
                            "\nCar's Model : " + doc.getString("carModel") +
                            "\nCar's Year : " + doc.getInteger("carYear") +
                            "\nCar's Price : " + doc.getInteger("carPrice") +
                            "\n\n";;
                }

                queryout.clear();
                queryout.appendText(q21);

            }

        });

        query10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                Document query = new Document("spSize","L");

                FindIterable it = mongoCollection.find(query).projection(new Document("_id",0));

                Iterator<Document> iterator = it.iterator();

                String q21 ="All Large Size Sports Products: \n";

                while (iterator.hasNext()) {
                    Document doc = iterator.next();
                    q21 +="\nSport's Brand : " + doc.getString("spBrand") +
                            "\nSport : " + doc.getString("spSport") +
                            "\nSport's Size : " + doc.getString("spSize") +
                            "\nSport's Price : " + doc.getInteger("spPrice") +
                            "\n\n";;
                }

                queryout.clear();
                queryout.appendText(q21);

            }

        });

        scene = new Scene(gridPane);
        scene1 = new Scene(gridPane1);

        backbutton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(scene2);
                status.clear();
                name.clear();
                desc.clear();
                stock.clear();
                dim.clear();
                weight.clear();
                review.clear();
                price.clear();
                cost.clear();
                author.clear();
                pub.clear();
                yearofpub.clear();
                count.clear();
                artist.clear();
                yearofpub.clear();
                count.clear();
                artist.clear();
                producer.clear();
                tracks.clear();
                totaltime.clear();
                color.clear();
                voltage.clear();
                style.clear();
                carmodel.clear();
                carbrand.clear();
                caryear.clear();
                carprice.clear();
                mobilephonebrand.clear();
                mobilephonemodel.clear();
                mobilephonecolor.clear();
                mobilephoneprice.clear();
                sportsbrand.clear();
                sportssport.clear();
                sportssize.clear();
                sportsprice.clear();
            }
        });

        backbutton1.setOnAction(new EventHandler<ActionEvent>() {
                                  @Override
                                  public void handle(ActionEvent e) {
                                      stage.setScene(scene2);
                                      queryout.clear();
                                  }
                              });
        String heading = "Welcome! What would you like to do?";

        Text t = new Text();

        t.setText(heading);

        Button hp1 = new Button("Insert");
        Button hp2 = new Button("Display");
        Button hp3 = new Button("Query");

        hp1.setAlignment(Pos.CENTER);
        hp2.setAlignment(Pos.CENTER);
        hp3.setAlignment(Pos.CENTER);

        hp1.setStyle("-fx-font: normal bold 16px 'serif' ");
        hp2.setStyle("-fx-font: normal bold 16px 'serif' ");
        hp3.setStyle("-fx-font: normal bold 16px 'serif' ");
        t.setStyle("-fx-font: normal bold 40px 'serif' ");

        gridPane2.setMinSize(800, 800);

        gridPane2.setPadding(new Insets(20, 20, 20, 20));

        gridPane2.setVgap(30);
        gridPane2.setHgap(30);

        gridPane2.setAlignment(Pos.CENTER);

        gridPane2.add(t, 1, 1);
        gridPane2.add(hp1, 1, 5);
        gridPane2.add(hp2, 1, 7);
        gridPane2.add(hp3, 1, 9);


        hp1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(scene);
            }
        });

        hp2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(scene3);
            }
        });

        hp3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(scene1);
            }
        });

        scene2 = new Scene(gridPane2);

        String dp = "Display products according to different categories";
        TextArea output = new TextArea();
        Text title = new Text();

        title.setText(dp);

        Button dp1 = new Button("CD");
        Button dp2 = new Button("Books");
        Button dp3 = new Button("Small Kitchen Appliances");
        Button dp4 = new Button("Cars");
        Button dp5 = new Button("Mobile Phones");
        Button dp6 = new Button("Sports");

        hp1.setAlignment(Pos.CENTER);
        hp2.setAlignment(Pos.CENTER);
        hp3.setAlignment(Pos.CENTER);

        dp1.setStyle("-fx-font: normal bold 16px 'serif' ");
        dp2.setStyle("-fx-font: normal bold 16px 'serif' ");
        dp3.setStyle("-fx-font: normal bold 16px 'serif' ");
        dp4.setStyle("-fx-font: normal bold 16px 'serif' ");
        dp5.setStyle("-fx-font: normal bold 16px 'serif' ");
        dp6.setStyle("-fx-font: normal bold 16px 'serif' ");
        title.setStyle("-fx-font: normal bold 32px 'serif' ");
        output.setStyle("-fx-font: normal bold 14px 'serif' ");
        backbutton3.setStyle("-fx-font: normal bold 16px 'serif' ");

        gridPane3.setMinSize(800, 800);

        gridPane3.setPadding(new Insets(20, 20, 20, 20));

        gridPane3.setVgap(30);
        gridPane3.setHgap(30);

        gridPane3.setAlignment(Pos.CENTER);

        gridPane3.add(title, 1, 1);
        gridPane3.add(dp1, 1, 3);
        gridPane3.add(dp2, 1, 5);
        gridPane3.add(dp3, 1, 7);
        gridPane3.add(dp4, 1, 9);
        gridPane3.add(dp5, 1, 11);
        gridPane3.add(dp6, 1, 13);
        gridPane3.add(output, 1, 15);
        gridPane3.add(backbutton3, 1, 18);

        dp1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find();

                Iterator<Document> iterator = it.iterator();
                String op = "The output is";
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if (document.getString("artistName")!= null&&document.getString("producerName")!= null&&document.getString("tracksCount")!= null&&document.getString("playTime")!= null) {
                        op += "\nArtist Name : " + document.getString("artistName") +
                                "\nProducer Name : " + document.getString("producerName") +
                                "\nTracks Count : " + document.getString("tracksCount") +
                                "\nPlay Time : " + document.getString("playTime") + "\n\n";
                    }
                }
                output.clear();
                output.appendText(op);

            }

        });

        dp2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find();

                Iterator<Document> iterator = it.iterator();
                String op1 = "The output is \n";
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if (document.getString("authName")!= null&&document.getString("publisher")!= null&&document.getInteger("yearofpublishing")!= null&&document.getString("pagecount")!= null) {
                     op1 += "\nAuthor Name : " + document.getString("authName") +
                                "\nPublisher Name : " + document.getString("publisher") +
                                "\nYear of Publishing : " + document.getInteger("yearofpublishing") +
                                "\nPage Count : " + document.getString("pagecount") + "\n\n";
                    }
                }
                output.clear();
                output.appendText(op1);

            }

        });

        dp3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find();

                Iterator<Document> iterator = it.iterator();
                String op1 = "The output is \n";
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if (document.getString("color")!= null&&document.getString("style")!= null&&document.getString("voltage")!= null) {
                        op1 += "\nColor : " + document.getString("color") +
                                "\nStyle : " + document.getString("style") +
                                "\nVoltage : " + document.getString("voltage") + "\n\n";
                    }
                }
                output.clear();
                output.appendText(op1);

            }

        });

        dp4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find();

                Iterator<Document> iterator = it.iterator();
                String op1 = "The output is \n";
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if (document.getString("carBrand")!= null&&document.getString("carModel")!= null&&document.getInteger("carYear")!= null&&document.getInteger("carPrice")!= null) {
                        op1 += "\nCar Brand : " + document.getString("carBrand") +
                                "\nCar Model : " + document.getString("carModel") +
                                "\nCar Year : " + document.getInteger("carYear") +
                                "\nCar Price : " + document.getInteger("carPrice") +
                                "\n\n";
                    }
                }
                output.clear();
                output.appendText(op1);

            }

        });

        dp5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find();

                Iterator<Document> iterator = it.iterator();
                String op1 = "The output is \n";
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if (document.getString("mpBrand")!= null&&document.getString("mpModel")!= null&&document.getString("mpColor")!= null&&document.getInteger("mpPrice")!= null) {
                        op1 += "\nMobile Phone Brand : " + document.getString("mpBrand") +
                                "\nMobile Phone Model : " + document.getString("mpModel") +
                                "\nMobile Phone Color : " + document.getString("mpColor") +
                                "\nMobile Phone Price : " + document.getInteger("mpPrice") +
                                "\n\n";
                    }
                }
                output.clear();
                output.appendText(op1);

            }

        });

        dp6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                MongoClient mongoClient = new MongoClient("localhost", 27017);
                System.out.println("connected..");

                MongoDatabase mongoDatabase = mongoClient.getDatabase("assgn2");
                System.out.println("Database selected..");

                MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("products");
                System.out.println("Collection fetched..");

                FindIterable it = mongoCollection.find();

                Iterator<Document> iterator = it.iterator();
                String op1 = "The output is \n";
                while (iterator.hasNext()) {
                    Document document = iterator.next();
                    if (document.getString("spBrand")!= null&&document.getString("spSport")!= null&&document.getString("spSize")!= null&&document.getInteger("spPrice")!= null) {
                        op1 += "\nSports Brand : " + document.getString("spBrand") +
                                "\nSport : " + document.getString("spSport") +
                                "\nSize : " + document.getString("spSize") +
                                "\nPrice : " + document.getInteger("spPrice") +
                                "\n\n";
                    }
                }
                output.clear();
                output.appendText(op1);

            }

        });

        backbutton3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                output.clear();
                stage.setScene(scene2);
            }
        });


        scene3 = new Scene(gridPane3);

        stage.setTitle("Product Form");

        stage.setScene(scene2);

        stage.show();
    }
}
