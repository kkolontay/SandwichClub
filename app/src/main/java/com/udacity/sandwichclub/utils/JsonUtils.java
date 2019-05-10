package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json)  {
        Sandwich sandwichObject = new Sandwich();
        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject name = sandwich.getJSONObject("name");
            String  mainName = name.getString("mainName");
            JSONArray knowsAs = name.getJSONArray("alsoKnownAs");
            String place = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");
            JSONArray ingredients = sandwich.getJSONArray("ingredients");
            sandwichObject.setMainName(mainName);
            sandwichObject.setAlsoKnownAs(convertorJSONArreayToList(knowsAs));
            sandwichObject.setDescription(description);
            sandwichObject.setImage(image);
            sandwichObject.setIngredients(convertorJSONArreayToList(ingredients));
            sandwichObject.setPlaceOfOrigin(place);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return sandwichObject;
    }

    public static ArrayList<String> convertorJSONArreayToList(final JSONArray array) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i < array.length(); i++) {
            try {
                list.add(array.getString(i));
            } catch ( Exception e) {
                e.printStackTrace();
            }

        }
        return  list;

    }
}
