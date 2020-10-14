package core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;
import java.util.Scanner;


public class TranslatorAPI {
    public static final Scanner scanner = new Scanner(System.in);
    public static TranslatorAPI TranslationRequest = new TranslatorAPI();
    String microsoftBingAPIKey = "c1fd29d6985e4d6c942f80a054cf6928";
    String translatorURL = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=vi";
    // Factory for calls, which can be used to send HTTP requests and read their responses.
    OkHttpClient dictClient = new OkHttpClient();

    // This function beautify the json response which we get from Translator API endpoint
    public String crunchifyPrettyJSONUtility(String json_text) {

        // A parser to parse Json into a parse tree of JsonElements
        JsonParser dictParser = new JsonParser();

        // A class representing an element of Json. It could either be a JsonObject, a JsonArray, a JsonPrimitive or a JsonNull.
        JsonElement dictJson = dictParser.parse(json_text);

        // This is the main class for using Gson. Gson is typically used by first constructing a Gson instance and then invoking toJson(Object) or
        // fromJson(String, Class) methods on it. Gson instances are Thread-safe so you can reuse them freely across multiple threads.
        Gson dictGson = new GsonBuilder().setPrettyPrinting().create();

        // return simple JSON. Converts a tree of JsonElements into its equivalent JSON representation.
        String beautifyResponse = dictGson.toJson(dictJson);

        return beautifyResponse;
    }

    public String result(String toFind) throws IOException {
        String preprocessedString = TranslationRequest.makePOSTcalls(toFind);
        String detectedlanguage = preprocessedString.substring(34, 36);
        int notationleft = 14;
        String meaning = "";
        String res = "";
        char[] chararr = preprocessedString.toCharArray();
        for (int i = 0; i < chararr.length; i++) {
            if (chararr[i] == '"') notationleft--;

            if (notationleft == 1) {
                meaning += chararr[i];
            }
            if (notationleft == 0) break;
        }
        meaning += '"';
        res += detectedlanguage + " " + meaning;
        return res;

    }

    // This function performs a simple POST call to Microsoft Translator Text Endpoint.
    public String makePOSTcalls(String word) throws IOException {
        String ctnt = "[{\n\t\"Text\": \"" + word + "\"\n}]";
        // An RFC 2045 Media Type, appropriate to describe the content type of an HTTP request or response body.
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody requestBody = RequestBody.create(mediaType,
                ctnt);

        // An HTTP request. Instances of this class are immutable if their body is null or itself immutable.
        Request dictRequest = new Request.Builder().url(translatorURL).post(requestBody)
                .addHeader("Ocp-Apim-Subscription-Key", microsoftBingAPIKey).addHeader("Content-type", "application/json").build();

        // An HTTP response. Instances of this class are not immutable: the response body is a one-shot value that may be consumed only once and then closed.
        // All other properties are immutable.

        Response servResponse = dictClient.newCall(dictRequest).execute();

        return servResponse.body().string();
    }

}