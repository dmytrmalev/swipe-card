package project.customlist.com.myapplication.card;

import java.util.ArrayList;

/**
 * Created by Admin on 3/20/2016.
 */
public class CardResponse {
    ArrayList<CardItem> items;

    public ArrayList<CardItem> getItems()
    {
        return items;
    }

    public void setItems(ArrayList<CardItem> items)
    {
        this.items = items;
    }
}
