package com.example.christopher.mobileandubiquitouscomputingcoursework;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import  android.widget.TextView;

import java.net.MalformedURLException;
import java.util.LinkedList;


public class AsyncRSSParser extends AsyncTask<String, Integer, RSSDataItemClass> {

    private Context appcontext;
    private String urlRSSToParse;
    public static LinkedList<RSSDataItemClass> rssData;

    //Constructor. Sets up the context, url to parse and creates a new list.
    public AsyncRSSParser(Context currentAppContext, String urlRSS)
    {
        appcontext = currentAppContext;
        urlRSSToParse = urlRSS;
        rssData = new LinkedList<>();
    }

    //Before parsing, displays toast message.
    @Override
    protected void onPreExecute()
    {
        Toast.makeText(appcontext, "Parsing Started!", Toast.LENGTH_SHORT).show();;
    }


    //Parsing is executied here.
   @Override
    protected RSSDataItemClass doInBackground(String... params)
    {
        RSSDataItemClass parsedData;
        ParserClass rssParser = new ParserClass();
        try
        {
            //attempt to parse data
            rssParser.parseRSSData(urlRSSToParse);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        parsedData = rssParser.getRSSDataItem();
        //add all the parsed fdata into the new list
        rssData.addAll(rssParser.parseList);

        return parsedData;
    }

    //after parsing, display toast message
    @Override
    protected void onPostExecute(RSSDataItemClass result)
    {
        Toast.makeText(appcontext, "ParsingFinished!", Toast.LENGTH_SHORT).show();
    }

}
