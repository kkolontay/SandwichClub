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
    public static final  String KEY_MAIN_NAME = "mainName";
    public static final String KEY_NAME = "name";
    public static final String KEY_ALSO_KNOWS_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json)  {
        Sandwich sandwichObject = new Sandwich();
        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject name = sandwich.getJSONObject(JsonUtils.KEY_NAME);
            String  mainName = name.optString(JsonUtils.KEY_MAIN_NAME, "noName");
            JSONArray knowsAs = name.getJSONArray(JsonUtils.KEY_ALSO_KNOWS_AS);
            String place = sandwich.optString(JsonUtils.KEY_PLACE_OF_ORIGIN, "no Place");
            String description = sandwich.optString(JsonUtils.KEY_DESCRIPTION, "no description");
            String image = sandwich.optString(JsonUtils.KEY_IMAGE, "https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&ved=2ahUKEwjX4bGEp5TiAhUsVd8KHSe3BTsQjRx6BAgBEAU&url=https%3A%2F%2Fstackoverflow.com%2Fquestions%2F7995080%2Fhtml-if-image-is-not-found&psig=AOvVaw16LBOki_QxuRnAZfqCc3-w&ust=1557692537089317");
            JSONArray ingredients = sandwich.getJSONArray(JsonUtils.KEY_INGREDIENTS);
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
