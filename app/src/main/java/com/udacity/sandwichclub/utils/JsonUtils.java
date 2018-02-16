package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {



    public static Sandwich parseSandwichJson(String json) throws JSONException {
        Sandwich deliciousSandwich = new Sandwich();

        //Get sandwich item
        JSONObject sandwich = new JSONObject(json);
        JSONObject jsonName = sandwich.getJSONObject("name");

        //Get mainName
        String mainName = jsonName.getString("mainName");
        deliciousSandwich.setMainName(mainName);

        //Get alsoKnownAs
        JSONArray alsoKnownAs = jsonName.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAsList = new ArrayList<>();
        for(int i=0; i < alsoKnownAs.length(); i++){
            alsoKnownAsList.add(alsoKnownAs.getString(i));
        }
        deliciousSandwich.setAlsoKnownAs(alsoKnownAsList);

        //Get placeOfOrigin
        String placeOfOrigin = sandwich.getString("placeOfOrigin");
        deliciousSandwich.setPlaceOfOrigin(placeOfOrigin);

        //Get description
        String description = sandwich.getString("description");
        deliciousSandwich.setDescription(description);

        //Get imageUrl
        String imageUrl = sandwich.getString("image");
        deliciousSandwich.setImage(imageUrl);

        //Get ingredients
        JSONArray ingredients = sandwich.getJSONArray("ingredients");
        List<String> ingredientsList = new ArrayList<>();
        for(int i=0; i < ingredients.length(); i++){
            ingredientsList.add(ingredients.getString(i));
        }
        deliciousSandwich.setIngredients(ingredientsList);

        return deliciousSandwich;
    }

    /* JSON Input Example
        {
            "name": {
                "mainName": "Kebap",
                "alsoKnownAs": []
            },
            "placeOfOrigin": "Turkey",
            "description": "A kebap...",
            "image": "https://.URL-TO-IMAGE.jpg",
            "ingredients": [
                            "Wrap",
                            "Meat"
                           ]
        }
     */
}
