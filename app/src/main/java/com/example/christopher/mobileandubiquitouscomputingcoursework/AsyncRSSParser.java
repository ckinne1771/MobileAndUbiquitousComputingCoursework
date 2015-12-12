package com.example.christopher.mobileandubiquitouscomputingcoursework;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import  android.widget.TextView;

import java.net.MalformedURLException;
import java.util.LinkedList;

/**
 * Created by Christopher on 12/12/2015.
 */
public class AsyncRSSParser extends AsyncTask<String, Integer, RSSDataItemClass> {

    private Context appcontext;
    private String urlRSSToParse;
    public static LinkedList<RSSDataItemClass> rssData;

    public AsyncRSSParser(Context currentAppContext, String urlRSS)
    {
        appcontext = currentAppContext;
        urlRSSToParse = urlRSS;
        rssData = new LinkedList<>();
    }

    @Override
    protected void onPreExecute()
    {
        Toast.makeText(appcontext, "Parsing Started!", Toast.LENGTH_SHORT).show();;
    }


   @Override
    protected RSSDataItemClass doInBackground(String... params)
    {
        RSSDataItemClass parsedData;
        ParserClass rssParser = new ParserClass();
        try
        {
            rssParser.parseRSSData(urlRSSToParse);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        parsedData = rssParser.getRSSDataItem();
        rssData.addAll(rssParser.parseList);

        return parsedData;
    }

    @Override
    protected void onPostExecute(RSSDataItemClass result)
    {
        Toast.makeText(appcontext, "ParsingFinished!", Toast.LENGTH_SHORT).show();
    }

}
