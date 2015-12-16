package com.example.christopher.mobileandubiquitouscomputingcoursework;


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


public class ParserClass {

    private RSSDataItemClass RSSDataItem;
    public static LinkedList<RSSDataItemClass> parseList = new LinkedList<>();

    //Set the values in the object used to store parsing data
    public void setRSSDataItem(String sItemData)
    {
        RSSDataItem.setOccupancy(sItemData);
        RSSDataItem.setOccupiedSpaces(sItemData);
        RSSDataItem.setCarParkStatus(sItemData);

    }

    //get the object used to store parsing data
    public RSSDataItemClass getRSSDataItem()
    {
        return this.RSSDataItem;
    }

    //constructor
    public ParserClass()
    {
        RSSDataItem = new RSSDataItemClass();
        setRSSDataItem(null);

    }

    //parsing code
    public void parseRSSDataItem(XmlPullParser theParser, int theEventType)
    {

        try
        {
            //while not at the end to the feed
            while (theEventType != XmlPullParser.END_DOCUMENT)
            {
                // Found a start tag
                if(theEventType == XmlPullParser.START_TAG)
                {
                    if (theParser.getName().equalsIgnoreCase("situation"))
                    {
                        this.RSSDataItem =  new RSSDataItemClass();

                    }

                    // If the tag is the occupancy
                    if (theParser.getName().equalsIgnoreCase("carParkOccupancy"))
                    {
                        //store occupancy
                        this.RSSDataItem.setOccupancy(theParser.nextText());


                    }
                    else
                        // If the tag is occupied spaces
                        if (theParser.getName().equalsIgnoreCase("occupiedSpaces"))
                        {
                            //Store occupied spaces. As this is the last item we need, we add the object used
                            //to store the parsed data into a list
                            this.RSSDataItem.setOccupiedSpaces(theParser.nextText());
                            parseList.add(this.RSSDataItem);
                        }
                        else
                            // If the tag is the car park status
                            if (theParser.getName().equalsIgnoreCase("carParkStatus"))
                            {
                                // Store the car park status
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