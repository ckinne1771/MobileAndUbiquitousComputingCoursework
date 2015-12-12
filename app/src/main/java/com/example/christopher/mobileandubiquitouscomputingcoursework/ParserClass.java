package com.example.christopher.mobileandubiquitouscomputingcoursework;

/**
 * Created by Christopher on 11/12/2015.
 */

        import android.util.Log;

        import org.xmlpull.v1.XmlPullParser;
        import org.xmlpull.v1.XmlPullParserException;
        import org.xmlpull.v1.XmlPullParserFactory;

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.StringReader;
        import java.io.StringWriter;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.LinkedList;


/**
 * Created by rla on 17/10/2014.
 */
public class ParserClass {

    private RSSDataItemClass RSSDataItem;
    public static LinkedList<RSSDataItemClass> parseList = new LinkedList<>();

    public void setRSSDataItem(String sItemData)
    {
        RSSDataItem.setOccupancy(sItemData);
        RSSDataItem.setOccupiedSpaces(sItemData);
        RSSDataItem.setCarParkStatus(sItemData);

    }

    public RSSDataItemClass getRSSDataItem()
    {
        return this.RSSDataItem;
    }

    public ParserClass()
    {
        RSSDataItem = new RSSDataItemClass();
        setRSSDataItem(null);

    }

    public void parseRSSDataItem(XmlPullParser theParser, int theEventType)
    {

        try
        {
            while (theEventType != XmlPullParser.END_DOCUMENT)
            {
                // Found a start tag
                if(theEventType == XmlPullParser.START_TAG)
                {
                    if (theParser.getName().equalsIgnoreCase("situation"))
                    {
                        this.RSSDataItem =  new RSSDataItemClass();

                    }

                    // Check which Tag has been found
                    if (theParser.getName().equalsIgnoreCase("carParkOccupancy"))
                    {
                        // Now just get the associated text
                        this.RSSDataItem.setOccupancy(theParser.nextText());
                        // store data in class

                    }
                    else
                        // Check which Tag we have
                        if (theParser.getName().equalsIgnoreCase("occupiedSpaces"))
                        {
                            // Now just get the associated text
                            this.RSSDataItem.setOccupiedSpaces(theParser.nextText());
                            parseList.add(this.RSSDataItem);
                        }
                        else
                            // Check which Tag we have
                            if (theParser.getName().equalsIgnoreCase("carParkStatus"))
                            {
                                // Now just get the associated text
                                this.RSSDataItem.setCarParkStatus(theParser.nextText());

                            }
                    else {
                                if (theEventType == XmlPullParser.END_TAG) {
                                    if (theParser.getName().equalsIgnoreCase("situation")) {


                                    }
                                }
                            }

                }

                // Get the next event
                theEventType = theParser.next();

            } // End of while

        }
        catch (XmlPullParserException parserExp1)
        {
            Log.e("MyTag","Parsing error" + parserExp1.toString());
        }

        catch (IOException parserExp1)
        {
            Log.e("MyTag","IO error during parsing");
        }

    }

    public void parseRSSData(String RSSItemsToParse) throws MalformedURLException {
        URL rssURL = new URL(RSSItemsToParse);
        InputStream rssInputStream;
        try
        {
            XmlPullParserFactory parseRSSfactory = XmlPullParserFactory.newInstance();
            parseRSSfactory.setNamespaceAware(true);
            XmlPullParser RSSxmlPP = parseRSSfactory.newPullParser();
            String xmlRSS = getStringFromInputStream(getInputStream(rssURL), "UTF-8");
            RSSxmlPP.setInput(new StringReader(xmlRSS));
            int eventType = RSSxmlPP.getEventType();

            parseRSSDataItem(RSSxmlPP,eventType);

        }
        catch (XmlPullParserException ae1)
        {
            Log.e("MyTag","Parsing error" + ae1.toString());
        }
        catch (IOException ae1)
        {
            Log.e("MyTag","IO error during parsing");
        }

        Log.e("MyTag","End document");
    }

    public InputStream getInputStream(URL url) throws IOException
    {
        return url.openConnection().getInputStream();
    }

    public static String getStringFromInputStream(InputStream stream, String charsetName) throws IOException
    {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, charsetName);
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
        return writer.toString();
    }
}